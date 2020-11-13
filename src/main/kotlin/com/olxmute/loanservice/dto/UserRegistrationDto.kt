package com.olxmute.loanservice.dto

import java.math.BigDecimal
import java.time.LocalDate

class UserRegistrationDto(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val birthDate: LocalDate,
    val employer: String,
    val salary: BigDecimal
)