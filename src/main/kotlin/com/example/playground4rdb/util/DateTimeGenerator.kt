package com.example.playground4rdb.util

import java.time.LocalDateTime
import java.util.*

object DateTimeGenerator {
    fun gen(): LocalDateTime {
        val random = Random()

        return LocalDateTime.now()
            .minusYears(10)
            .plusYears(random.nextLong(11))
            .withMonth(random.nextInt(12) + 1)
            .withDayOfMonth(random.nextInt(28) + 1)
            .withHour(random.nextInt(24))
            .withMinute(random.nextInt(60))
            .withSecond(random.nextInt(60))
    }
}
