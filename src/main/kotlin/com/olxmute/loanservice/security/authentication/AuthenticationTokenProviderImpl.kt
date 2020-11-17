package com.olxmute.loanservice.security.authentication

import com.olxmute.loanservice.security.token.JwtTokenService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthenticationTokenProviderImpl(
    private val userDetailsService: UserDetailsService,
    private val jwtTokenService: JwtTokenService
) : AuthenticationTokenProvider {

    override fun getAuthentication(token: String): Authentication? {
        val email = jwtTokenService.extractSubject(token)
        val userDetails = userDetailsService.loadUserByUsername(email)
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

}