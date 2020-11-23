package com.olxmute.loanservice.controller

import com.olxmute.loanservice.dto.CreatePersonalLoanApplicationDto
import com.olxmute.loanservice.dto.LoanApplicationResponseDto
import com.olxmute.loanservice.dto.PageResult
import com.olxmute.loanservice.security.Access
import com.olxmute.loanservice.security.data.JwtUser
import com.olxmute.loanservice.service.LoanApplicationService
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("v1")
class LoanApplicationController(
    private val loanApplicationService: LoanApplicationService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("loans")
    @Access.CreatePersonalLoans
    fun createPersonalLoan(
        @Valid @RequestBody loanApplicationDto: CreatePersonalLoanApplicationDto,
        @AuthenticationPrincipal jwtUser: JwtUser
    ): LoanApplicationResponseDto = loanApplicationService.createLoanApplication(loanApplicationDto, jwtUser.id)

    @GetMapping("loans")
    @Access.ReadPersonalLoans
    fun getPersonalLoans(
        @AuthenticationPrincipal jwtUser: JwtUser,
        @RequestParam page: Int,
        @RequestParam pageSize: Int
    ): PageResult<LoanApplicationResponseDto> = loanApplicationService.getLoanApplications(jwtUser.id, page, pageSize)

    @GetMapping("loans/{loanApplicationId}")
    @Access.ReadPersonalLoans
    fun getPersonalLoan(
        @PathVariable loanApplicationId: String,
        @AuthenticationPrincipal jwtUser: JwtUser
    ): LoanApplicationResponseDto = loanApplicationService.getLoanApplication(loanApplicationId, jwtUser.id)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("users/{id}/loans")
    @Access.WriteAllLoans
    fun createLoanForUser(
        @Valid @RequestBody loanApplicationDto: CreatePersonalLoanApplicationDto,
        @PathVariable id: String
    ): LoanApplicationResponseDto = loanApplicationService.createLoanApplication(loanApplicationDto, id)

    @GetMapping("users/{id}/loans")
    @Access.ReadAllLoans
    fun getLoansForUser(
        @PathVariable id: String,
        @RequestParam page: Int,
        @RequestParam pageSize: Int
    ): PageResult<LoanApplicationResponseDto> = loanApplicationService.getLoanApplications(id, page, pageSize)

    @GetMapping("users/{userId}/loans/{loanApplicationId}")
    @Access.ReadAllLoans
    fun getLoanForUser(
        @PathVariable loanApplicationId: String,
        @PathVariable userId: String
    ): LoanApplicationResponseDto = loanApplicationService.getLoanApplication(loanApplicationId, userId)

}