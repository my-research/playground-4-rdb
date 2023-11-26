package com.example.playground4rdb.util

object NameGenerator {
    fun gen(): String {
        val randomLastName = lastNames.random()
        val randomFirstName = firstNames.random()

        return "$randomLastName$randomFirstName"
    }

    private val lastNames = arrayOf("김", "강", "홍", "제", "어", "채", "장", "이", "박", "최", "정", "강", "조", "윤", "주", "임", "허")
    private val firstNames = arrayOf(
        "원익",
        "혜진",
        "태기",
        "민석",
        "민준",
        "서연",
        "하준",
        "지우",
        "준서",
        "서준",
        "예준",
        "지후",
        "준영",
        "지훈",
        "영철",
        "영수",
        "민수",
        "미하",
        "준철",
        "상수",
        "정화",
        "민해",
        "해찬",
        "구영",
        "영화",
        "영숙",
        "민수",
        "민찬",
        "찬들",
        "이나",
        "주선",
        "가람"
    )
}
