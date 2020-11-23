package com.olxmute.loanservice.utils

import com.olxmute.loanservice.dto.CreatePersonalLoanApplicationDto
import com.olxmute.loanservice.dto.LoanApplicationResponseDto
import com.olxmute.loanservice.dto.UserDto
import com.olxmute.loanservice.persistence.entity.LoanApplication
import com.olxmute.loanservice.persistence.entity.User
import com.olxmute.loanservice.security.data.JwtUser
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

fun LocalDateTime.toLegacyDate(): Date = Timestamp.valueOf(this)

fun Date.toLocalDateTime(): LocalDateTime = LocalDateTime.ofInstant(toInstant(), ZoneId.systemDefault())

fun User.toJwtUser() = JwtUser(
        id = id!!,
        email = email,
        password = password,
        authorities = permissions.map { SimpleGrantedAuthority(it.name) }
)

fun User.toDto() = UserDto(
        id = id.orEmpty(),
        firstName = firstName,
        lastName = lastName,
        birthDate = birthDate,
        employer = employer,
        salary = salary
)

fun CreatePersonalLoanApplicationDto.toLoanApplication() = LoanApplication(
        monthlyLiability = monthlyLiability!!,
        requestedAmount = requestedAmount!!,
        requestedTerm = requestedTerm!!,
)

fun LoanApplication.toLoanApplicationResponseDto() = LoanApplicationResponseDto(
        id = id,
        firstName = user?.firstName,
        lastName = user?.lastName,
        birthDate = user?.birthDate,
        employer = user?.employer,
        salary = user?.salary,
        monthlyLiability = monthlyLiability,
        requestedAmount = requestedAmount,
        requestedTerm = requestedTerm,
        status = status
)