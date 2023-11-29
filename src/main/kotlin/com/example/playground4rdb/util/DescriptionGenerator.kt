package com.example.playground4rdb.util

object DescriptionGenerator {
    fun gen(): String {
        return "${first.random()} ${second.random()} ${PositionGenerator.gen()}"
    }

    private val first = arrayOf(
        "신뢰할수있는",
        "침착한",
        "세세한",
        "지속적인",
        "신뢰가는",
        "최고의",
        "유연한",
        "똑똑한",
        "취약한",
        "빠른",
        "뛰어난",
        "강력한",
        "세밀한",
        "노련한",
        "느린",
        "침착한",
        "과감한"
    )

    private val second = arrayOf("헤더의", "킥의", "패스의", "크로스의", "롱볼의", "슬라이딩의", "트래픽의", "슈팅의", "홀딩의", "볼간수의","짧은패스의")
}
