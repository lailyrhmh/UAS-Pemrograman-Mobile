package com.example.uasmobile.network

import java.io.Serializable

data class Nasional(
    val title: String,
    val link: String,
    val contentSnippet: String,
    val isoDate: String
) : Serializable {}
data class NasionalResponse(
    val data:List<Nasional>
) {}