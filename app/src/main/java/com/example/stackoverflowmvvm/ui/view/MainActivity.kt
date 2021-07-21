package com.example.stackoverflowmvvm.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackoverflowmvvm.R
import com.example.stackoverflowmvvm.data.model.Questions
import com.example.stackoverflowmvvm.ui.adaptor.QuestionAdaptor
import com.example.stackoverflowmvvm.ui.viewModel.QuestionViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var questionsAdapter:QuestionAdaptor
    private val viewModel: QuestionViewModel by viewModels()
    private val lm = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getQuestions()
        viewModel.questionsResponse.observe(this, Observer {
            it?.let {
                questionsAdapter = QuestionAdaptor(viewModel.questionsResponse.value as ArrayList<Questions>)
                questionsAdapter.onItemclick = {
                    val i = Intent(this, AnswerActivity::class.java)
                    i.putExtra("ID", it)
                    startActivity(i)
                }
                questions_list.apply {
                    layoutManager = lm
                    adapter = questionsAdapter
                }
            }
        })
    }
}