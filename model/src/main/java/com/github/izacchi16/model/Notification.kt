package com.github.izacchi16.model

data class Notification(
    val id: String,
    val title: String,
    val description: String,
    val file: File,
    val course: Course
)
