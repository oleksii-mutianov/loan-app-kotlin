package com.olxmute.loanservice.validation

import javax.validation.Constraint
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Digits
import javax.validation.constraints.NotNull
import kotlin.reflect.KClass

@MustBeDocumented
@NotNull
@DecimalMin("0.0")
@Digits(integer = 10, fraction = 2)
@Target(AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [])
annotation class Money(

    val message: String = "Invalid money value",

    val groups: Array<KClass<out Any>> = [],

    val payload: Array<KClass<out Any>> = []

)