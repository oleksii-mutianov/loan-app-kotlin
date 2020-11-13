package com.olxmute.loanservice.security.authentication

import org.springframework.security.core.Authentication

interface AuthenticationTokenProvider {
    fun getAuthentication(token: String): Authentication?
}