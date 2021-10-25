package com.gobeyond.memebe.security;

import com.gobeyond.memebe.security.token.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}

	@Bean
	public AuthEntryPointJwt authEntryPointJwt() {
		return new AuthEntryPointJwt();
	}

	@Bean
	public JwtFilter authenticationJwtTokenFilter() {
		return new JwtFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(authEntryPointJwt()).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/api/user/**").permitAll().antMatchers("/api/test/**").authenticated().and()
				.authorizeRequests();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/api/auth/**");
	}

}
