package com.pasukanlangit.id.traffico.ui.lesson

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.pasukanlangit.id.traffico.R
import com.pasukanlangit.id.traffico.databinding.ItemLessonBinding
import com.pasukanlangit.id.traffico.model.LessonsModel

class LessonAdapter(private val lessons: List<LessonsModel>, private val listener: LessonEvent): RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    private val lessonsIndexFinished = lessons.indexOf(lessons.singleOrNull { it.isFinished })

    inner class LessonViewHolder(private val binding: ItemLessonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val lesson = lessons[position]
            val isLessThanIndexFinished = lessonsIndexFinished != -1 && position <= lessonsIndexFinished+1
            /**if position greater than 1 check previous lesson is finished or not, if true so current lesson must unlock,*/
            val isLessonUnlock = isLessThanIndexFinished || position == 0
            with(binding){
                ivLogo.setImageResource(lesson.logo)
                tvTitle.text = lesson.title
                tvDesc.text = lesson.description

                badgeFinished.isVisible = lesson.isFinished || position < lessonsIndexFinished

                /** add badge new in last item*/
                badgeNew.isVisible = position == lessons.size-1
                buttonAction.text = lesson.id

                if(isLessonUnlock){
                    buttonAction.setBackgroundResource(R.drawable.primary_rounded_small)
                    buttonAction.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_expand_right, 0)
                }else{
                    buttonAction.setBackgroundResource(R.drawable.grey_rounded_small)
                    buttonAction.setCompoundDrawablesWithIntrinsicBounds(0,0, R.drawable.ic_lock, 0)
                }

                buttonAction.setOnClickListener {
//                    listener.onQuizClicked(lesson)
                    if(isLessonUnlock){
                        listener.onQuizClicked(lesson)
                    }else{
                        Toast.makeText(this.root.context, "Selesaikan Quiz Lessons-$position terlebih dahulu", Toast.LENGTH_SHORT).show()
                    }
                }

                wrapperTop.setOnClickListener {
                    if(isLessonUnlock){
                        listener.onLessonRootClicked(lesson)
                    }else{
                        Toast.makeText(this.root.context, "Selesaikan Quiz Lessons-$position terlebih dahulu", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LessonAdapter.LessonViewHolder {
        val view = ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonAdapter.LessonViewHolder, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int = lessons.size

    interface LessonEvent{
        fun onLessonRootClicked(lessons: LessonsModel)
        fun onQuizClicked(lessons: LessonsModel)
    }
}