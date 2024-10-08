package com.example.kotlin.examenmoviles0710.data.network

import com.example.kotlin.examenmoviles0710.data.network.models.Characters.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterAPIService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): CharacterResponse

    @GET("characters")
    suspend fun searchCharacters(
        @Query("name") name: String,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): CharacterResponse

}