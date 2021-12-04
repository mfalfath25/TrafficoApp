package com.pasukanlangit.id.traffico.ui.score

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
import com.pasukanlangit.id.traffico.databinding.FragmentScoreBinding
import com.pasukanlangit.id.traffico.model.LessonsModel
import com.pasukanlangit.id.traffico.ui.quiz.QuizActivity
import kotlinx.coroutines.flow.collectLatest

class ScoreFragment : Fragment(),
    ScoreAdapter.ScoreEvent {

    private var _binding: FragmentScoreBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentScoreBinding.inflate(layoutInflater, container, false)
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
                binding.rvScore.adapter = ScoreAdapter(lessons.sortedBy { it.title }, this@ScoreFragment)
            }
        }
    }

    private fun setUpRvLessons() {
        binding.rvScore.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLessonRootClicked(lessons: LessonsModel) {
        startActivity(
            Intent(requireContext(), QuizActivity::class.java).putExtra(
            QuizActivity.KEY_LESSON, lessons
        ))
    }

}