package com.example.grehighfrequencywords.feed.data

import retrofit2.Response
import retrofit2.http.GET

interface WordsApi {
    @GET("GreWord.json")
    suspend fun getGreData(): Response<GreWords>
}