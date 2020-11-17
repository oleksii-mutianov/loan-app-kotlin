package com.olxmute.loanservice.controller

import com.olxmute.loanservice.dto.UserRegistrationDto
import com.olxmute.loanservice.security.data.JwtUser
import com.olxmute.loanservice.service.UserService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun register(@RequestBody dto: UserRegistrationDto) = userService.register(dto)

    @GetMapping("me")
    @PreAuthorize("hasAuthority('READ_PERSONAL_LOANS')")
    fun getMe() = SecurityContextHolder.getContext().authentication.principal as JwtUser

    @GetMapping("me-secured")
    @PreAuthorize("hasAuthority('WRITE_ALL_LOANS')")
    fun getMeSecured() = SecurityContextHolder.getContext().authentication.principal as JwtUser
}