package com.zeus.cursoholamundo.Entities

data class GeneralResponse(
    val status: Int,
    val msn: String,
    val errors: Array<String>?,
    val result: LoginResult?
)