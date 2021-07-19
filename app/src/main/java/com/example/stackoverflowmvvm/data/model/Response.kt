package com.example.stackoverflowmvvm.data.model

import com.google.gson.annotations.SerializedName

data class ResponseWrapper<T>(
    val items: List<T>
)
data class Questions(
    @SerializedName("question_id")
    val questions: Int?,

    val title: String?)

data class Answers(
    @SerializedName("answer_id")
    val answerId: Int?,

    @SerializedName("is_accepted")
    val isAccepted: Boolean?)