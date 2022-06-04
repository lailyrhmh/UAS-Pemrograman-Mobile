package com.example.uasmobile.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://berita-indo-api.vercel.app/v1/cnn-news/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService{
    @GET(value = "nasional")
    suspend fun getNasional() : List<Nasional>

//    @GET(value = "https://berita-indo-api.vercel.app/v1/cnn-news/internasional")
//    suspend fun getInternasional() : List<Interasional>
//
//    @GET(value = "https://berita-indo-api.vercel.app/v1/cnn-news/olahraga")
//    suspend fun getOlahrahga() : List<Olahraga>
}

object NewsApi{
    val retrofitService : NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}