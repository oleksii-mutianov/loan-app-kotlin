package com.olxmute.loanservice.security.token

import javax.servlet.http.HttpServletRequest

fun HttpServletRequest.resolveJwtToken() = getHeader("Authorization")
        ?.substringAfter("Bearer ", missingDelimiterValue = "")
        .orEmpty()