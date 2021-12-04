package com.pasukanlangit.id.traffico.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pasukanlangit.id.traffico.model.LessonsModel
import com.pasukanlangit.id.traffico.databinding.ItemScoreBinding
import com.pasukanlangit.id.traffico.ui.score.ScoreAdapter

class HomeLessonAdapter(private val lessons: List<LessonsModel>, private val listener: ScoreAdapter.ScoreEvent): RecyclerView.Adapter<HomeLessonAdapter.LessonViewHolder>() {

    inner class LessonViewHolder(private val binding: ItemScoreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val lesson = lessons[position]
            with(binding){
                ivLogo.setImageResource(lesson.logo)
                tvTitle.text = lesson.id
                tvDesc.text = lesson.description

            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeLessonAdapter.LessonViewHolder {
        val view = ItemScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeLessonAdapter.LessonViewHolder, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int = if(lessons.size > 2) 2 else lessons.size

}