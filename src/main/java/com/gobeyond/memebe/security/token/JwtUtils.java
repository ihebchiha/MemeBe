package com.gobeyond.memebe.security.token;

import java.util.Date;

import com.gobeyond.memebe.service.impl.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtils {

	@Value("${memebe.app.jwtSecret}")
	private String jwtSecret;

	@Value("${memebe.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {

		UserDetailsServiceImpl userPrincipal = (UserDetailsServiceImpl) authentication.getPrincipal();
		long expirationDate = new Date().getTime() + jwtExpirationMs;
		return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date(jwtExpirationMs))
				.setExpiration(new Date(expirationDate)).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			log.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			log.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			log.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			log.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			log.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}
