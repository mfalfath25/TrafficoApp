package com.pasukanlangit.id.traffico.ui.lesson

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasukanlangit.id.traffico.MainViewModel
import com.pasukanlangit.id.traffico.databinding.FragmentLessonBinding
import com.pasukanlangit.id.traffico.model.LessonsModel
import com.pasukanlangit.id.traffico.ui.lesson.detail.LessonDetailActivity
import com.pasukanlangit.id.traffico.ui.quiz.QuizActivity
import kotlinx.coroutines.flow.collectLatest

class LessonFragment : Fragment(), LessonAdapter.LessonEvent {
    private var _binding: FragmentLessonBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLessonBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRvLessons()
        observeLessons()
    }

    private fun observeLessons() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.lessons.collectLatest { lessons ->
                binding.rvLessons.adapter = LessonAdapter(lessons.sortedBy { it.title }, this@LessonFragment)
            }
        }
    }

    private fun setUpRvLessons() {
        binding.rvLessons.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onLessonRootClicked(lessons: LessonsModel) {
        startActivity(Intent(requireContext(), LessonDetailActivity::class.java).putExtra(
            LessonDetailActivity.KEY_LESSON, lessons
        ))
    }

    override fun onQuizClicked(lessons: LessonsModel) {
        startActivity(Intent(requireContext(), QuizActivity::class.java).putExtra(
            QuizActivity.KEY_LESSON, lessons
        ))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}