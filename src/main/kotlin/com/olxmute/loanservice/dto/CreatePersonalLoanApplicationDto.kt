package com.olxmute.loanservice.dto

import com.olxmute.loanservice.validation.Money
import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

class CreatePersonalLoanApplicationDto(

    @get:Money
    var monthlyLiability: BigDecimal?,

    @get:Money
    var requestedAmount: BigDecimal?,

    @get:NotNull
    @get:Min(1)
    var requestedTerm: Int?,

    )