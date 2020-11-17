package com.olxmute.loanservice.dto

import java.math.BigDecimal
import java.time.LocalDate

class UserDto(
    val id: String,
    val firstName: String,
    val lastName: String,
    val birthDate: LocalDate,
    val employer: String,
    val salary: BigDecimal,
)