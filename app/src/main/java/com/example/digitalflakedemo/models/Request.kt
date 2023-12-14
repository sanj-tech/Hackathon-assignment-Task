package com.example.digitalflakedemo.models

data class Request(
    val body: Body,
    val header: List<Any>,
    val method: String,
    val url: Url
)