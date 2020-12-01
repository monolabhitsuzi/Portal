package com.github.izacchi16.model

import java.util.*

data class File( // TextReportでよくない？
    val id: String,
    val content: String?,
    val published_at: Date
)
