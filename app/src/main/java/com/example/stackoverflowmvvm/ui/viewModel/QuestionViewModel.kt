package com.example.stackoverflowmvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stackoverflowmvvm.data.api.StackOverflowService
import com.example.stackoverflowmvvm.data.model.Questions
import com.example.stackoverflowmvvm.data.model.ResponseWrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionViewModel : ViewModel() {

    val questionsResponse = MutableLiveData<List<Questions>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    var page = 1
    fun getQuestions() {
        StackOverflowService.api.getQuestions(page)
            .enqueue(object : Callback<ResponseWrapper<Questions>> {
                override fun onResponse(
                    call: Call<ResponseWrapper<Questions>>,
                    response: Response<ResponseWrapper<Questions>>
                ) {
                    if (response.isSuccessful) {
                        val questions = response.body()
                        questions?.let {
                            questionsResponse.value = questions.items
                            loading.value = false
                            error.value = null
                        }
                    }
                }
                override fun onFailure(call: Call<ResponseWrapper<Questions>>, t: Throwable) {
                    onError(t.localizedMessage)
                    loading.value = false
                    error.value = null
                }
            })
    }

    private fun onError(message: String) {
        error.value = message
        loading.value = false
    }
}