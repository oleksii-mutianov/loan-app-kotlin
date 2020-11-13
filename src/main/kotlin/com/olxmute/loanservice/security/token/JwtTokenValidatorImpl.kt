package com.olxmute.loanservice.security.token

import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class JwtTokenValidatorImpl(
    private val jwtTokenService: JwtTokenService
) : JwtTokenValidator {

    override fun isValid(token: String): Boolean = try {
        token.isNotBlank() and jwtTokenService.extractExpiredAt(token).isAfter(LocalDateTime.now())
    } catch (ex: JWTVerificationException) {
        false
    }

}