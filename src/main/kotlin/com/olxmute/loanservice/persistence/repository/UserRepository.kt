package com.olxmute.loanservice.persistence.repository

import com.olxmute.loanservice.persistence.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {

    fun findByEmail(email: String?): User?

}