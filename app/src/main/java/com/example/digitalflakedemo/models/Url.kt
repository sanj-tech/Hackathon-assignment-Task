package com.example.digitalflakedemo.models

data class Url(
    val host: List<String>,
    val path: List<String>,
    val protocol: String,
    val query: List<Query>,
    val raw: String
)