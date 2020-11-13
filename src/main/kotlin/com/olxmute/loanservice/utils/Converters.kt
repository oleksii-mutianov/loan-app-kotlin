package com.olxmute.loanservice.utils

import com.olxmute.loanservice.dto.UserDto
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