package com.example.stackoverflowmvvm.data.api

import com.example.stackoverflowmvvm.data.model.Answers
import com.example.stackoverflowmvvm.data.model.ResponseWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StackOverflowApi {
    @GET("/2.3/questions/{id}/answers?order=desc&sort=votes&site=stackoverflow")
    fun getAnswers(
        @Path("id") questionId: Int,
        @Query("page") page: Int
    ): Call<ResponseWrapper<Answers>>
}