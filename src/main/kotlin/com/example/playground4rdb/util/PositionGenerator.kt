package com.example.playground4rdb.util

object PositionGenerator {
    fun gen(): String {
        return position.random()
    }

    private val position = arrayOf(
        "ST", "SS",
        "CF", "LF", "RF",
        "LW", "RW",
        "CAM", "CM", "LCM", "RCM",
        "CDM", "LDM", "RDM",
        "LB", "RB", "LWB", "RWB",
        "CB", "LCB", "RCB", "SW",
        "GK"
    )
}
