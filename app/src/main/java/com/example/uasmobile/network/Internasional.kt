package com.example.uasmobile.network

import java.io.Serializable

data class Internasional(
    val title: String,
    val link: String,
    val contentSnippet: String,
    val isoDate: String
): Serializable {}
data class InternasionalResponse(
    val data:List<Internasional>
) {}
