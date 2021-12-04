package com.pasukanlangit.id.traffico.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pasukanlangit.id.traffico.databinding.ItemInformationBinding
import com.pasukanlangit.id.traffico.model.Information

class InformationAdapter(private val informations: List<Information>, private val listener: (Information) -> Unit): RecyclerView.Adapter<InformationAdapter.LessonViewHolder>() {

    inner class LessonViewHolder(private val binding: ItemInformationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val information = informations[position]
            with(binding) {
                iv.setImageResource(information.logo)
                tvTitle.text = "Pembuatan ${information.sim}"

                this.root.setOnClickListener {
                    listener(information)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InformationAdapter.LessonViewHolder {
        val view = ItemInformationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: InformationAdapter.LessonViewHolder, position: Int) {
       holder.bind(position)
    }

    override fun getItemCount(): Int = informations.size
}