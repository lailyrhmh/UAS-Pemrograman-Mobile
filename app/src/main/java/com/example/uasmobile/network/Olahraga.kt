package com.example.uasmobile.network

import java.io.Serializable

data class Olahraga(
    val title: String,
    val link: String,
    val contentSnippet: String,
    val isoDate: String
): Serializable {}
data class OlahragaResponse(
    val data:List<Olahraga>
) {}
