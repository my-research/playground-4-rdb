package com.example.playground4rdb.entity

import com.example.playground4rdb.util.DateTimeGenerator
import com.example.playground4rdb.util.DescriptionGenerator
import com.example.playground4rdb.util.NameGenerator
import com.example.playground4rdb.util.PositionGenerator
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity(name = "players")
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(name = "names")
    val name: String,
    val description: String,
    val position: String,
    val uniqueTag: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)

object PlayerGenerator {
    fun gen(n: Int): List<Player> {
        val ret = mutableListOf<Player>()
        repeat(n) {
            val desc = DescriptionGenerator.gen()
            ret.add(
                Player(
                    0,
                    NameGenerator.gen(),
                    desc,
                    desc.split(" ")[2],
                    UUID.randomUUID().toString(),
                    DateTimeGenerator.gen(),
                    DateTimeGenerator.gen()
                )
            )
        }

        return ret
    }
}
