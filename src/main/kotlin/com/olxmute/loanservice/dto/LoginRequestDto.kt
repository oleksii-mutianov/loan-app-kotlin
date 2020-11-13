package com.olxmute.loanservice.dto

import javax.validation.constraints.NotEmpty

data class LoginRequestDto(
    @get:NotEmpty
    val email: String?,

    @get:NotEmpty
    val password: String?
)