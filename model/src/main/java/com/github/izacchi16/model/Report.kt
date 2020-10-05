package com.github.izacchi16.model

data class Report(
    val id: String,
    val file: File,
    val author: User,
    val teacher: User
)
