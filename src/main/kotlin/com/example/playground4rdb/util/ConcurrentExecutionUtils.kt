package com.example.playground4rdb.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.stream.IntStream

object ConcurrentExecutionUtils {
    fun execute(task: suspend () -> Unit, nThread: Int) {
        val executor = Executors.newFixedThreadPool(nThread)

        val futures = IntStream.range(0, 10)
            .mapToObj {
                CompletableFuture.supplyAsync {
                    runBlocking { withContext(Dispatchers.Default) { task() } }
                }
            }
            .toList()

        CompletableFuture.allOf(*futures.toTypedArray()).join()

        executor.shutdown()
    }
}
