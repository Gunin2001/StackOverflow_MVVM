package com.example.stackoverflowmvvm.ui.adaptor

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowmvvm.R
import com.example.stackoverflowmvvm.data.model.Questions
import kotlinx.android.synthetic.main.question_layout.view.*

class QuestionAdaptor(val questions: ArrayList<Questions>) :
    RecyclerView.Adapter<QuestionAdaptor.AdapterViewHolder>() {

    fun addQuestions(newQuestions: List<Questions>) {
        val currentLength = questions.size
        questions.addAll(newQuestions)
        notifyItemInserted(currentLength)
    }

    fun clearQuestions() {
        questions.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.question_layout, parent, false)
        )

    override fun getItemCount() = questions.size

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    class AdapterViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val layout = view.item_layout
        val title = view.item_title

        fun bind(question: Questions) {
            title.text = Html.fromHtml(question.title).toString()
            }
        }
    }
