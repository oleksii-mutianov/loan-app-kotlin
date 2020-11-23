package com.olxmute.loanservice.dto

import com.olxmute.loanservice.persistence.entity.LoanApplicationStatus
import java.math.BigDecimal
import java.time.LocalDate

class LoanApplicationResponseDto(
    val id: String?,
    val firstName: String?,
    val lastName: String?,
    val birthDate: LocalDate?,
    val employer: String?,
    val salary: BigDecimal?,
    val monthlyLiability: BigDecimal?,
    val requestedAmount: BigDecimal?,
    val requestedTerm: Int?,
    val status: LoanApplicationStatus?
)