package com.olxmute.loanservice.dto

data class PageResult<E>(
    val content: List<E>,
    val pageNumber: Int,
    val pageSize: Int,
    val totalPages: Int,
    val first: Boolean,
    val last: Boolean
)