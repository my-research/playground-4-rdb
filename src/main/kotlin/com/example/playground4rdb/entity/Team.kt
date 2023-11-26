package com.example.playground4rdb.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    val address: String,
    val fans: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
) {
}
