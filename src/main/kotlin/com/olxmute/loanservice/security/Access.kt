package com.olxmute.loanservice.security

import org.springframework.security.access.prepost.PreAuthorize

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Access {

    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @PreAuthorize("hasAuthority('READ_PERSONAL_LOANS')")
    annotation class ReadPersonalLoans

    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @PreAuthorize("hasAuthority('CREATE_PERSONAL_LOANS')")
    annotation class CreatePersonalLoans

    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @PreAuthorize("hasAuthority('WRITE_ALL_LOANS')")
    annotation class WriteAllLoans

    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @PreAuthorize("hasAuthority('READ_ALL_LOANS')")
    annotation class ReadAllLoans

}