package com.example.myapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey
    val id: Long,
    val author: String,
    val name: String,
    val year: Int

)