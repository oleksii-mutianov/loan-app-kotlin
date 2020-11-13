package com.olxmute.loanservice.security.authentication

import com.olxmute.loanservice.dto.AuthenticationResponseDto
import com.olxmute.loanservice.dto.LoginRequestDto
import com.olxmute.loanservice.security.token.JwtTokenService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    val authenticationManager: AuthenticationManager,
    val jwtTokenService: JwtTokenService
) : AuthService {
    override fun authenticate(loginRequestDto: LoginRequestDto): AuthenticationResponseDto {
        val (email, password) = loginRequestDto
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(email, password))

        val token = jwtTokenService.createToken(email.orEmpty())

        return AuthenticationResponseDto(token)
    }
}