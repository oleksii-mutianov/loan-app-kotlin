package com.olxmute.loanservice.service

import com.olxmute.loanservice.dto.CreatePersonalLoanApplicationDto
import com.olxmute.loanservice.dto.LoanApplicationResponseDto
import com.olxmute.loanservice.dto.PageResult

interface LoanApplicationService {

    fun createLoanApplication(loanApplicationDto: CreatePersonalLoanApplicationDto, userId: String): LoanApplicationResponseDto

    fun getLoanApplications(userId: String, page: Int, pageSize: Int): PageResult<LoanApplicationResponseDto>

    fun getLoanApplication(loanApplicationId: String, userId: String): LoanApplicationResponseDto

}