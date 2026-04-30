package com.edutech.app.data

data class Course(
    val id: Int,
    val title: String,
    val instructor: String,
    val level: String,
    val category: String,
    val image: String,
    val description: String,
    val duration: String
)