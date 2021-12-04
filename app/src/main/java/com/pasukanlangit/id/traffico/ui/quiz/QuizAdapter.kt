package com.pasukanlangit.id.traffico.ui.quiz

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.pasukanlangit.id.traffico.databinding.ItemQuizBinding
import com.pasukanlangit.id.traffico.model.Quiz

class QuizAdapter(private val quizzes: List<Quiz>): RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {
    inner class QuizViewHolder(private val binding: ItemQuizBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val quiz = quizzes[position]
            with(binding){
                tvNumber.text = "${position.plus(1)}"
                ivQuestion.setImageResource(quiz.image)
                tvQuestion.text = quiz.question

                /**
                 * create radio button programmatically for multiple choice
                 * */
                quiz.multipleChoice.forEach { choice ->
                    val radioButton = RadioButton(this.root.context)
                    radioButton.text = choice

                    radioButton.setOnClickListener {
                        quizzes[position].answerChosen = choice
                    }
                    rgMultipleChoice.addView(radioButton)
                }
            }
        }
    }

    fun getQuizAnswered(): List<Quiz> = quizzes.filter { it.answerChosen.isNotEmpty() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizAdapter.QuizViewHolder {
        val view = ItemQuizBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuizAdapter.QuizViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = quizzes.size
}