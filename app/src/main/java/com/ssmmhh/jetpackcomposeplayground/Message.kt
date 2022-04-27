package com.ssmmhh.jetpackcomposeplayground

data class Message(
    val author: String,
    val text: String
) {
    companion object {
        val TEST_MESSAGE_1 = Message(
            author = "Mahdi",
            text = "Hey are u up for tonight?"
        )
    }
}