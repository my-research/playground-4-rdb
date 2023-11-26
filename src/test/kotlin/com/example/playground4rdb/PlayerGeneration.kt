package com.example.playground4rdb

import com.example.playground4rdb.entity.PlayerGenerator
import com.example.playground4rdb.entity.PlayerJpaRepository
import jakarta.persistence.EntityManagerFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PlayerGeneration @Autowired constructor(
    private val repository: PlayerJpaRepository,
    private val entityManager: EntityManagerFactory // EntityManager 주입

) {

    @Test
    fun gen() {
        val players = PlayerGenerator.gen(100_000)

        repository.saveAll(players)
    }

    @Test
    fun genWithCoroutine(): Unit = runBlocking {
        val playerCount = 100_000
        val coroutineCount = 5 // 코루틴 개수

        val players = (0 until coroutineCount).map { _ ->
            async(Dispatchers.IO) {
                PlayerGenerator.gen(playerCount / coroutineCount)
            }
        }.awaitAll().flatten()

        repository.saveAll(players)
    }
}
