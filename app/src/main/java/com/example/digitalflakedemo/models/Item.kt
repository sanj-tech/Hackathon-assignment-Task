package com.example.digitalflakedemo.models

data class Item(
    val name: String,
    val protocolProfileBehavior: ProtocolProfileBehavior,
    val request: Request,
    val response: List<Any>
)