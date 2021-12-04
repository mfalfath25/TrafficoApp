package com.pasukanlangit.id.traffico.ui.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasukanlangit.id.traffico.databinding.ActivityQuizBinding
import com.pasukanlangit.id.traffico.model.LessonsModel
import com.pasukanlangit.id.traffico.model.Quiz
import com.pasukanlangit.id.traffico.model.getAllQuizzes

class QuizActivity : AppCompatActivity() {
    private var quizzes: List<Quiz> = listOf()
    private var lesson: LessonsModel? = null
    private lateinit var binding: ActivityQuizBinding
    private lateinit var quizAdapter: QuizAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconBack.setOnClickListener { this.onBackPressed() }

        intent.getParcelableExtra<LessonsModel>(KEY_LESSON)?.let { lesson ->
            this.lesson = lesson
            with(binding){
                tvTitle.text = lesson.id.uppercase()
                tvDesc.text = lesson.description
            }

            quizzes = getAllQuizzes().filter { it.lessonId == lesson.id }
            quizAdapter = QuizAdapter(quizzes)
            binding.btnComplete.isVisible = quizzes .isNotEmpty()

            setUpRvQuiz()
        }

        binding.btnComplete.setOnClickListener {
            calculateScore()
        }

    }

    private fun calculateScore() {
        val answeredQuizzes = quizAdapter.getQuizAnswered()
        var correctAnswerCount = 0
        answeredQuizzes.map { quizAnswered ->
            val checkIsCorrect = quizzes.singleOrNull { it.id == quizAnswered.id && it.answerChosen == quizAnswered.correctAnswer }
            if(checkIsCorrect != null) correctAnswerCount++
        }

        val percentageValue = ((correctAnswerCount.toFloat()/quizzes.size.toFloat())*100).toInt()

        startActivity(Intent(this, QuizResultActivity::class.java).apply {
            putExtra(QuizResultActivity.KEY_LESSON, lesson)
            putExtra(QuizResultActivity.KEY_SCORE, percentageValue)
            putParcelableArrayListExtra(QuizResultActivity.KEY_QUIZ_ANSWERED, ArrayList(answeredQuizzes))
        })
    }

    private fun setUpRvQuiz() {
        with(binding.rvQuiz){
            layoutManager = LinearLayoutManager(this@QuizActivity, LinearLayoutManager.VERTICAL, false)
            adapter = quizAdapter
        }
    }

    companion object {
        const val KEY_LESSON= "KEY_LESSON"
    }
}