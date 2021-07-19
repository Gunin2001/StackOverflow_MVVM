package com.example.stackoverflowmvvm.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackoverflowmvvm.R
import com.example.stackoverflowmvvm.ui.adaptor.QuestionAdaptor
import com.example.stackoverflowmvvm.ui.viewModel.QuestionViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val questionsAdapter = QuestionAdaptor(arrayListOf())
    private val viewModel: QuestionViewModel by viewModels()
    private val lm = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}