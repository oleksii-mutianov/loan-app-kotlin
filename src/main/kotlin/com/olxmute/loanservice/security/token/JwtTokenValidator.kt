package com.olxmute.loanservice.security.token

interface JwtTokenValidator {
    fun isValid(token: String): Boolean
}