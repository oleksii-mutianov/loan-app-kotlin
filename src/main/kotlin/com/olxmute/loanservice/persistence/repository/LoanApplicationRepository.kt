package com.olxmute.loanservice.persistence.repository

import com.olxmute.loanservice.persistence.entity.LoanApplication
import org.springframework.data.jpa.repository.JpaRepository

interface LoanApplicationRepository : JpaRepository<LoanApplication, String> {

    fun findByIdAndUser_Id(loanApplicationId: String, userId: String): LoanApplication?

}