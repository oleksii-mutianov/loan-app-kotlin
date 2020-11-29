package com.olxmute.loanservice.persistence.repository

import com.olxmute.loanservice.persistence.entity.LoanApplication
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface LoanApplicationRepository : JpaRepository<LoanApplication, String>, PagingAndSortingRepository<LoanApplication, String> {

    fun findByIdAndUserId(loanApplicationId: String, userId: String): LoanApplication?

    fun findAllByUserId(userId: String, pageable: Pageable): Page<LoanApplication>

}