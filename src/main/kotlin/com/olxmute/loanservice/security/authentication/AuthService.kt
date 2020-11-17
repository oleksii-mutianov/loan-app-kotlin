package com.olxmute.loanservice.security.authentication

import com.olxmute.loanservice.dto.AuthenticationResponseDto
import com.olxmute.loanservice.dto.LoginRequestDto

interface AuthService {
    fun authenticate(loginRequestDto: LoginRequestDto): AuthenticationResponseDto
}