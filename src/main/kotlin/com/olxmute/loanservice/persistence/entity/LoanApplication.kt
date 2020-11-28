package com.olxmute.loanservice.persistence.entity

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "loan_applications")
class LoanApplication(
    val monthlyLiability: BigDecimal,
    val requestedAmount: BigDecimal,
    val requestedTerm: Int,

    @Enumerated(EnumType.STRING)
    val status: LoanApplicationStatus = LoanApplicationStatus.MANUAL,

    @ManyToOne(fetch = FetchType.LAZY)
    var user: User? = null

) : BaseEntity()

enum class LoanApplicationStatus {
    APPROVED,
    MANUAL,
    REJECTED,
}