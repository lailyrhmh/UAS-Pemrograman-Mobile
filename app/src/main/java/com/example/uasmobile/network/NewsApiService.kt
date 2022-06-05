package com.example.uasmobile.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://berita-indo-api.vercel.app/v1/cnn-news/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService{
    @GET(value = "nasional")
    fun getNasional() : Deferred<NasionalResponse>

    @GET(value = "internasional")
    fun getInternasional() : Deferred<InternasionalResponse>

//    @GET(value = "https://berita-indo-api.vercel.app/v1/cnn-news/olahraga")
//    suspend fun getOlahrahga() : List<Olahraga>
}

object NewsApi{
    val retrofitService : NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}