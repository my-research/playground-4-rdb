package com.example.playground4rdb.entity

import org.springframework.data.jpa.repository.JpaRepository

interface PlayerJpaRepository: JpaRepository<Player, Int> {
}
