package com.olxmute.loanservice.security.token

import java.time.LocalDateTime

interface JwtTokenService {

    fun createToken(subject: String): String

    fun extractSubject(token: String): String

    fun extractExpiredAt(token: String): LocalDateTime

}