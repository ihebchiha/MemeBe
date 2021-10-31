package com.gobeyond.memebe.controller;

import javax.validation.Valid;

import com.gobeyond.memebe.domain.dto.request.RegistrationRequest;
import com.gobeyond.memebe.domain.dto.response.RegistrationResponse;

import com.gobeyond.memebe.service.AccountService;
import com.gobeyond.memebe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AccountService accountService;

    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerUser(@Valid @RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(accountService.registerUser(request));
    }
}
