package com.pasukanlangit.id.traffico.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.pasukanlangit.id.traffico.MainActivity
import com.pasukanlangit.id.traffico.MainViewModel
import com.pasukanlangit.id.traffico.PageNavigate
import com.pasukanlangit.id.traffico.databinding.FragmentHomeBinding
import com.pasukanlangit.id.traffico.model.LessonsModel
import com.pasukanlangit.id.traffico.model.getInformations
import com.pasukanlangit.id.traffico.ui.lesson.detail.LessonDetailActivity
import com.pasukanlangit.id.traffico.ui.score.ScoreAdapter
import kotlinx.coroutines.flow.collectLatest

class HomeFragment : Fragment(), ScoreAdapter.ScoreEvent {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLearnMore.setOnClickListener {
            (activity as MainActivity).navigateToPage(PageNavigate.LESSON)
        }

        binding.btnViewAll.setOnClickListener {
            (activity as MainActivity).navigateToPage(PageNavigate.LESSON)
        }

        setUpRvInformation()
        setUpRvLessons()
        observeLessons()
    }

    private fun observeLessons() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.lessons.collectLatest { lessons ->
                binding.rvLesson.adapter = HomeLessonAdapter(lessons.sortedBy { it.title }, this@HomeFragment)
            }
        }
    }

    private fun setUpRvLessons() {
        binding.rvLesson.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setUpRvInformation() {
        binding.rvInformation.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = InformationAdapter(getInformations()){
                startActivity(Intent(requireContext(), DetailInformationActivity::class.java).putExtra(
                    DetailInformationActivity.KEY_INFORMATION, it
                ))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLessonRootClicked(lessons: LessonsModel) {
        startActivity(
            Intent(requireContext(), LessonDetailActivity::class.java).putExtra(
            LessonDetailActivity.KEY_LESSON, lessons
        ))
    }

}