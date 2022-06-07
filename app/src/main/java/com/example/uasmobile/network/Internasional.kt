package com.example.uasmobile.network

import java.io.Serializable

data class Internasional(
    val title: String,
    val link: String,
    val description: String,
    val isoDate: String,
    val image: String

): Serializable {}
data class InternasionalResponse(
    val data:List<Internasional>
) {}
