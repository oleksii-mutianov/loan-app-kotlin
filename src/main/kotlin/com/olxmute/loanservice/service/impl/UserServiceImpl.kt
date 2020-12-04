package com.olxmute.loanservice.service.impl

import com.olxmute.loanservice.dto.UserDto
import com.olxmute.loanservice.dto.UserRegistrationDto
import com.olxmute.loanservice.persistence.entity.Permission
import com.olxmute.loanservice.persistence.entity.User
import com.olxmute.loanservice.persistence.repository.UserRepository
import com.olxmute.loanservice.service.UserService
import com.olxmute.loanservice.utils.toDto
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository
) : UserService {

    override fun register(dto: UserRegistrationDto): UserDto {
        val user = User(
            email = dto.email,
            password = passwordEncoder.encode(dto.password),
            firstName = dto.firstName,
            lastName = dto.lastName,
            birthDate = dto.birthDate,
            employer = dto.employer,
            salary = dto.salary,
            permissions = Permission.userPermissions
        )

        return userRepository.save(user).toDto()
    }

}