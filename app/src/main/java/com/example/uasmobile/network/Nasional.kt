package com.example.uasmobile.network

import java.io.Serializable

data class Nasional(
    val title: String,
    val link: String,
    val description: String,
    val isoDate: String,
    val image: String

) : Serializable {}
data class NasionalResponse(
    val data:List<Nasional>
) {}