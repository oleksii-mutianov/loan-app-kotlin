package com.olxmute.loanservice.security.service

import com.olxmute.loanservice.persistence.repository.UserRepository
import com.olxmute.loanservice.utils.toJwtUser
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String) =
        userRepository.findByEmail(username)?.toJwtUser()
            ?: throw UsernameNotFoundException("User not found: $username")

}