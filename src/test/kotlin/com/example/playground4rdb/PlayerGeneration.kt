package com.example.playground4rdb

import com.example.playground4rdb.entity.PlayerGenerator
import com.example.playground4rdb.entity.PlayerJpaRepository
import com.example.playground4rdb.util.ConcurrentExecutionUtils
import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.stream.IntStream


@SpringBootTest
class PlayerGeneration @Autowired constructor(
    private val repository: PlayerJpaRepository,
) {

    fun generateAndSavePlayers() {
        val players = PlayerGenerator.gen(10_000)
        repository.saveAll(players)
        println("Thread ID: ${Thread.currentThread().id} is running.")
    }

    @Test
    fun gen() {
        ConcurrentExecutionUtils.execute({ generateAndSavePlayers() }, 10)
    }
}
