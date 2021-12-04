package com.pasukanlangit.id.traffico.ui.quiz

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pasukanlangit.id.traffico.MainActivity
import com.pasukanlangit.id.traffico.databinding.ActivityQuizResultBinding
import com.pasukanlangit.id.traffico.model.LessonsModel
import com.pasukanlangit.id.traffico.model.Quiz
import com.pasukanlangit.id.traffico.ui.lesson.LessonFragment

class QuizResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizResultBinding
    private var quizzes: ArrayList<Quiz> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconBack.setOnClickListener { this.onBackPressed() }

        intent.getParcelableExtra<LessonsModel>(KEY_LESSON)?.let { lesson ->
            binding.tvTitle.text = lesson.title.uppercase()
            binding.tvDesc.text = lesson.description
        }

        intent.getParcelableArrayListExtra<Quiz>(KEY_QUIZ_ANSWERED)?.let { quizzes ->
            this.quizzes = quizzes
        }

        intent.getIntExtra(KEY_SCORE, 0).let { score ->
            binding.tvPercentage.text = "$score%"
            binding.progressCircularId.progress = score
            when (score) {
                100 -> {
                    binding.tvGreeting.text = "Sempurna!"
                    binding.progressCircularId.setIndicatorColor(Color.parseColor("#21E900"))
                }
                in 75..99 -> {
                    binding.tvGreeting.text = "Nyaris Sempurna!"
                    binding.progressCircularId.setIndicatorColor(Color.parseColor("#C4E900"))
                }
                in 50..74 -> {
                    binding.tvGreeting.text = "Tingkatkan lagi!"
                    binding.progressCircularId.setIndicatorColor(Color.parseColor("#FF774B"))
                }
                in 0..49 -> {
                    binding.tvGreeting.text = "Belajar lagi, ya!"
                    binding.progressCircularId.setIndicatorColor(Color.parseColor("#FF3D00"))
                }
            }

            binding.btnFinish.setOnClickListener {
                startActivity(Intent(this, MainActivity::class.java).putParcelableArrayListExtra(
                    MainActivity.NEW_QUIZZES, quizzes
                ))
            }

            binding.btnRetry.setOnClickListener { this.onBackPressed() }
        }


    }

    companion object {
        const val KEY_SCORE = "KEY_SCORE"
        const val KEY_LESSON = "KEY_LESSON"
        const val KEY_QUIZ_ANSWERED = "KEY_QUIZ_ANSWERED"
    }
}