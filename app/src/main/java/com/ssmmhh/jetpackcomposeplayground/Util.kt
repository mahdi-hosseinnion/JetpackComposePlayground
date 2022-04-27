package com.ssmmhh.jetpackcomposeplayground

fun getRandomText(length: Int): String {
    val allowedChars = ('A'..'Z') + ('a'..'z')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}