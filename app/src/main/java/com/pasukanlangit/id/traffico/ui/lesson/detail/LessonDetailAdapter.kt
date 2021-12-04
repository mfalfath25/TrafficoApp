package com.pasukanlangit.id.traffico.ui.lesson.detail

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.pasukanlangit.id.traffico.databinding.ItemDetailLessonWhiteBinding
import com.pasukanlangit.id.traffico.model.DetailLessons

class LessonDetailAdapter(private val context: Context, private val lessons : List<DetailLessons>) : PagerAdapter() {


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun getCount(): Int = lessons.size

    @SuppressLint("SetTextI18n")
    override fun instantiateItem(container: ViewGroup, position: Int): View {
        val binding = ItemDetailLessonWhiteBinding.inflate(LayoutInflater.from(context), container, false)
        val itemLesson = lessons[position]
        with(binding){
            ivLogo.setImageResource(itemLesson.logo)
            tvPosition.text = "${position.plus(1)}/${lessons.size}"
            tvTitle.text = itemLesson.title
            tvDesc.text = itemLesson.description
        }
        container.addView(binding.root,0)
        return binding.root
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
}