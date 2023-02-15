package com.example.grehighfrequencywords.feed.data

class MyRepository(private val wordsApi: WordsApi) {
    suspend fun getGreData(): GreWords? {
        val response = wordsApi.getGreData()
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Api Exception")
        }
    }
}