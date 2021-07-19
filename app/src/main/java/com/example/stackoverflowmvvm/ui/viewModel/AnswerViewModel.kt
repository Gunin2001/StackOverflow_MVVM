package com.example.stackoverflowmvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stackoverflowmvvm.data.api.StackOverflowService
import com.example.stackoverflowmvvm.data.model.Answers
import com.example.stackoverflowmvvm.data.model.ResponseWrapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnswerViewModel : ViewModel() {

    val answersResponse = MutableLiveData<List<Answers>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    var questionsId = 0
    var page = 0

    private fun getAnswers() {
        StackOverflowService.api.getAnswers(questionsId, page)
            .enqueue(object : Callback<ResponseWrapper<Answers>> {
                override fun onResponse(
                    call: Call<ResponseWrapper<Answers>>,
                    response: Response<ResponseWrapper<Answers>>
                ) {
                    val answers = response.body()
                    answers?.let {
                        answersResponse.value = it.items
                        loading.value = false
                        error.value = null
                    }
                }

                override fun onFailure(call: Call<ResponseWrapper<Answers>>, t: Throwable) {
                    onError(t.localizedMessage)
                }
            })
    }

    private fun onError(message: String) {
        error.value = message
        loading.value = false
    }

}