package com.pasukanlangit.id.traffico.ui.score

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ddd.androidutils.DoubleClick
import com.pasukanlangit.id.traffico.model.LessonsModel
import com.ddd.androidutils.DoubleClickListener
import com.pasukanlangit.id.traffico.databinding.ItemScoreBinding

class ScoreAdapter(private val lessons: List<LessonsModel>, private val listener: ScoreEvent): RecyclerView.Adapter<ScoreAdapter.LessonViewHolder>() {

    inner class LessonViewHolder(private val binding: ItemScoreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val lesson = lessons[position]
            with(binding){
                tvTitle.text = lesson.id
                tvDesc.text = lesson.description
                val context = this.root.context

                val doubleClick = DoubleClick(object : DoubleClickListener {
                    override fun onSingleClickEvent(view: View?) {
                        // DO STUFF SINGLE CLICK
                        Toast.makeText(context, "Klik 2 kali untuk retry", Toast.LENGTH_SHORT).show()
                    }

                    override fun onDoubleClickEvent(view: View?) {
                        // DO STUFF DOUBLE CLICK
                        listener.onLessonRootClicked(lesson)
                    }
                })

                this.root.setOnClickListener(doubleClick)
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScoreAdapter.LessonViewHolder {
        val view = ItemScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScoreAdapter.LessonViewHolder, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int = lessons.size

    interface ScoreEvent{
        fun onLessonRootClicked(lessons: LessonsModel)
    }
}