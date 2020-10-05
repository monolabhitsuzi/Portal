package com.github.izacchi16.model

import java.util.*

data class Task(
    val id: String,
    val group: String, // Groupってmodel必要じゃない？
    val title: String,
    val name: String,
    val description: String,
    val status: String, // これもTaskStatusっていうmodel必要そう
    val deadline: Date,
    val update_at: Date
)
