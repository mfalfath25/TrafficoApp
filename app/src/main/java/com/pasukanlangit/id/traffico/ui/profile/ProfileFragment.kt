package com.pasukanlangit.id.traffico.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.pasukanlangit.id.traffico.MainViewModel
import com.pasukanlangit.id.traffico.databinding.FragmentProfileBinding
import com.pasukanlangit.id.traffico.model.ProfileModel
import kotlinx.coroutines.flow.collectLatest

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    //when update profile activity change profile, so update profile value in viewmodel
    private var updateProfileLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val profileUpdated = result.data?.getParcelableExtra<ProfileModel>(EditProfileActivity.KEY_PROFILE)
            profileUpdated?.let { profile ->
                viewModel.setProfile(profile)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEditProfile.setOnClickListener {
            updateProfileLauncher.launch(Intent(requireContext(), EditProfileActivity::class.java).putExtra(
                EditProfileActivity.KEY_PROFILE, viewModel.profile.value
            ))
        }
        observeLessons()
        observeProfile()
    }

    private fun observeProfile() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.profile.collectLatest { profile ->
                if(profile.imgUrl.isNotEmpty()){
                    Glide.with(this@ProfileFragment)
                        .load(profile.imgUrl)
                        .circleCrop()
                        .into(binding.circleImageView)
                }

                binding.tvProfile.text = profile.name
            }
        }
    }

    private fun observeLessons() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.lessons.collectLatest { lessons ->
                val lessonsIndexFinished = lessons.indexOf(lessons.singleOrNull { it.isFinished })
                val textFinishedLesosn = "${lessonsIndexFinished.plus(1)}/${lessons.size}"
                binding.tvLesson.text = textFinishedLesosn
                binding.tvQuiz.text = textFinishedLesosn
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}