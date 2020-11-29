package com.olxmute.loanservice.persistence.entity

import org.hibernate.annotations.Type
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "users")
class User(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val birthDate: LocalDate,
    val employer: String,
    val salary: BigDecimal,

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    val permissions: List<Permission>,

    @OneToMany(mappedBy = "user")
    val loanApplications: Set<LoanApplication> = emptySet()

) : BaseEntity()

enum class Permission {
    READ_PERSONAL_LOANS,
    CREATE_PERSONAL_LOANS,
    READ_ALL_LOANS,
    WRITE_ALL_LOANS;

    companion object {
        val userPermissions = listOf(READ_PERSONAL_LOANS, CREATE_PERSONAL_LOANS)
        val operatorPermissions = listOf(READ_ALL_LOANS, WRITE_ALL_LOANS)
    }

}


