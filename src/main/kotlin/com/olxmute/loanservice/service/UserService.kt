package com.olxmute.loanservice.service

import com.olxmute.loanservice.dto.UserDto
import com.olxmute.loanservice.dto.UserRegistrationDto

interface UserService {

    fun register(dto: UserRegistrationDto): UserDto

}