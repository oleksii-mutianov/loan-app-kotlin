package com.olxmute.loanservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LoanServiceApplication

fun main(args: Array<String>) {
    runApplication<LoanServiceApplication>(*args)
}
