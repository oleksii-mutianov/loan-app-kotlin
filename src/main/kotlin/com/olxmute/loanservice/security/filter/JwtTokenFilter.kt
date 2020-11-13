package com.olxmute.loanservice.security.filter

import com.olxmute.loanservice.security.authentication.AuthenticationTokenProvider
import com.olxmute.loanservice.security.token.JwtTokenValidator
import com.olxmute.loanservice.security.token.resolveJwtToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtTokenFilter(
    private val authenticationTokenProvider: AuthenticationTokenProvider,
    private val tokenValidator: JwtTokenValidator
) : OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val jwtToken = request.resolveJwtToken()

        if (tokenValidator.isValid(jwtToken)) {
            authenticationTokenProvider.getAuthentication(jwtToken)
                    ?.let { SecurityContextHolder.getContext().authentication = it }
        }

        filterChain.doFilter(request, response)
    }
}