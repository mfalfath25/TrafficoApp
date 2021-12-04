package com.pasukanlangit.id.traffico.ui.lesson.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import com.pasukanlangit.id.traffico.databinding.ActivityLessonDetailBinding
import com.pasukanlangit.id.traffico.model.DetailLessons
import com.pasukanlangit.id.traffico.model.LessonsModel
import com.pasukanlangit.id.traffico.model.getAllLessonItems
import com.pasukanlangit.id.traffico.ui.quiz.QuizActivity

class LessonDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLessonDetailBinding
    private var lesson: LessonsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconBack.setOnClickListener {
            this.onBackPressed()
        }

        intent.getParcelableExtra<LessonsModel>(KEY_LESSON)?.let { lesson ->
            this.lesson = lesson
            binding.tvTitle.text = lesson.title.uppercase()
            binding.tvDesc.text = lesson.description

            val detailLessons = getAllLessonItems().filter { it.lessonId == lesson.id }
            binding.btnNext.isVisible = detailLessons.isNotEmpty()
            setUpViewPager(detailLessons)

            binding.btnNext.setOnClickListener {
                if(binding.viewpagerDetailLesson.currentItem < detailLessons.size-1) {
                    binding.viewpagerDetailLesson.currentItem = binding.viewpagerDetailLesson.currentItem + 1
                }else{
                    startActivity(Intent(this@LessonDetailActivity, QuizActivity::class.java).putExtra(
                        QuizActivity.KEY_LESSON, lesson
                    ))
                }
            }

            binding.btnPrev.setOnClickListener {
                binding.viewpagerDetailLesson.currentItem = binding.viewpagerDetailLesson.currentItem - 1
            }
        }

    }

    private fun setUpViewPager(detailLessons: List<DetailLessons>) {
        with(binding.viewpagerDetailLesson){
            adapter = LessonDetailAdapter(this@LessonDetailActivity,detailLessons)
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {}

                override fun onPageSelected(position: Int) {
                    binding.btnPrev.isVisible = position != 0
                    if(position == detailLessons.size-1){
                        binding.btnNext.text = detailLessons[position].lessonId
                    }else{
                        binding.btnNext.text  = "Lanjut"
                    }
                }

                override fun onPageScrollStateChanged(state: Int) {}

            })
        }
    }

    companion object {
        const val KEY_LESSON= "KEY_LESSON"
    }
}