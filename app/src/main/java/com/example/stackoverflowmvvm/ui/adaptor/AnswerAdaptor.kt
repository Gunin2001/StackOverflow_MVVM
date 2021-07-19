package com.example.stackoverflowmvvm.ui.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowmvvm.R
import com.example.stackoverflowmvvm.data.model.Answers
import kotlinx.android.synthetic.main.answer_layout.view.*

class AnswerAdaptor(val answers: ArrayList<Answers>) :
    RecyclerView.Adapter<AnswerAdaptor.AdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.answer_layout, parent, false)
        )

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(answers[position])
    }

    override fun getItemCount() = answers.size

    class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.item_answers
        fun bind(answers: Answers) {
            title.text = answers.toString()
        }
    }
}