package com.olxmute.loanservice.security.token

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.olxmute.loanservice.utils.toLegacyDate
import com.olxmute.loanservice.utils.toLocalDateTime
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class JwtTokenServiceImpl(

    @Value("\${jwt-token.secret}")
    private val tokenSecret: String,

    @Value("\${jwt-token.time-to-live}")
    private val timeToLive: Long

) : JwtTokenService {

    override fun createToken(subject: String): String {
        val now = LocalDateTime.now()
        return JWT.create()
            .withSubject(subject)
            .withIssuedAt(now.toLegacyDate())
            .withExpiresAt(now.plusSeconds(timeToLive).toLegacyDate())
            .sign(Algorithm.HMAC512(tokenSecret))
    }

    override fun extractSubject(token: String): String {
        return token
            .decodedJwt
            .subject
    }

    override fun extractExpiredAt(token: String): LocalDateTime {
        return token
            .decodedJwt
            .expiresAt
            .toLocalDateTime()
    }

    private val String.decodedJwt
        get() = JWT.require(Algorithm.HMAC512(tokenSecret))
            .build()
            .verify(this)

}

