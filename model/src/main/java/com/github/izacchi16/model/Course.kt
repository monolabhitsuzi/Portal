package com.github.izacchi16.model

data class Course(
    val id: String,
    val name: String,
    val description: String,
    val semester: String, // 学期
    val time: Int, // 何限目か
    val location: String
)
