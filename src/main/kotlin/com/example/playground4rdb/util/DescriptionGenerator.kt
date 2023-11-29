package com.example.playground4rdb.util

object DescriptionGenerator {
    fun gen(): String {
        return "${first.random()} ${second.random()} ${PositionGenerator.gen()}"
    }

    private val first = arrayOf("리더쉽이 강한", "카리스마 있는", "빠른", "지구력이 좋은", "강력한", "세밀한", "노련한", "느린", "침착한")

    private val second = arrayOf("헤더의", "킥의", "패스의", "크로스의", "롱 볼의", "슬라이딩의", "트래픽의", "슈팅의", "홀딩의")
}
