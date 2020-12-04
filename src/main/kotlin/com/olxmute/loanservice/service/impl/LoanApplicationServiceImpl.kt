package com.olxmute.loanservice.service.impl

import com.olxmute.loanservice.dto.CreatePersonalLoanApplicationDto
import com.olxmute.loanservice.dto.LoanApplicationResponseDto
import com.olxmute.loanservice.dto.PageResult
import com.olxmute.loanservice.persistence.entity.LoanApplication
import com.olxmute.loanservice.persistence.repository.LoanApplicationRepository
import com.olxmute.loanservice.persistence.repository.UserRepository
import com.olxmute.loanservice.service.LoanApplicationService
import com.olxmute.loanservice.utils.toLoanApplication
import com.olxmute.loanservice.utils.toLoanApplicationResponseDto
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LoanApplicationServiceImpl(
    private val loanApplicationRepository: LoanApplicationRepository,
    private val userRepository: UserRepository
) : LoanApplicationService {

    override fun createLoanApplication(
        loanApplicationDto: CreatePersonalLoanApplicationDto,
        userId: String
    ): LoanApplicationResponseDto {

        val user = userRepository.findById(userId).orElseThrow { RuntimeException("User not found") }

        val loanApplication = loanApplicationDto.toLoanApplication().apply { this.user = user }

        return loanApplicationRepository.save(loanApplication).toLoanApplicationResponseDto()
    }

    @Transactional
    override fun getLoanApplications(userId: String, page: Int, pageSize: Int): PageResult<LoanApplicationResponseDto> {
        val loanApplications = loanApplicationRepository.findAllByUserId(userId, PageRequest.of(page, pageSize))

        return PageResult(
            content = loanApplications.content.map(LoanApplication::toLoanApplicationResponseDto),
            pageNumber = page,
            pageSize = pageSize,
            totalPages = loanApplications.totalPages,
            first = loanApplications.isFirst,
            last = loanApplications.isLast
        )
    }

    @Transactional
    override fun getLoanApplication(loanApplicationId: String, userId: String): LoanApplicationResponseDto {
        return loanApplicationRepository
            .findByIdAndUserId(loanApplicationId, userId)
            ?.toLoanApplicationResponseDto()
            ?: throw RuntimeException("Loan application not found")
    }

}