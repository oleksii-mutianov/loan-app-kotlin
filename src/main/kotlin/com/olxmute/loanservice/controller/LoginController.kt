package com.olxmute.loanservice.controller

import com.olxmute.loanservice.dto.LoginRequestDto
import com.olxmute.loanservice.security.authentication.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("v1")
class LoginController(
    private val authService: AuthService
) {

    @PostMapping("login")
    fun login(@RequestBody @Valid loginRequestDto: LoginRequestDto) = authService.authenticate(loginRequestDto)

}