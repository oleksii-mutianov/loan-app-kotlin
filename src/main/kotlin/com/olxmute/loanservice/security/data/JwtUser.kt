package com.olxmute.loanservice.security.data

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class JwtUser(
    private val email: String,
    private val password: String,
    private val authorities: List<GrantedAuthority>
) : UserDetails {

    override fun getAuthorities() = authorities

    override fun getPassword() = password

    override fun getUsername() = email

    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
    override fun isCredentialsNonExpired() = true
    override fun isEnabled() = true

}