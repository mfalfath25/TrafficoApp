package com.pasukanlangit.id.traffico

import androidx.lifecycle.ViewModel
import com.pasukanlangit.id.traffico.model.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel: ViewModel() {
    private val _lessons = MutableStateFlow(getLessons())
    val lessons : StateFlow<List<LessonsModel>> = _lessons

    private val _quizzes = MutableStateFlow(getAllQuizzes())
    val quizzes : StateFlow<List<Quiz>> = _quizzes

    private val _profile = MutableStateFlow(ProfileModel(
        "",
        "Arief Daffa"
    ))
    val profile : StateFlow<ProfileModel> = _profile

    fun setProfile(profileModel: ProfileModel){
        _profile.value = profileModel
    }
    fun updateQuizzes(newQuizzes: List<Quiz>){
        val currentQuizzes = this.quizzes.value.toMutableList()
        newQuizzes.forEach { quiz ->
            currentQuizzes.removeIf { it.id == quiz.id }
            currentQuizzes.add(quiz)
        }

//        val lessonQuizFinish = this.lessons.value.singleOrNull { it.id == newQuizzes.first().lessonId }
//        lessonQuizFinish?.isFinished = true
//
//        val currentLessons = this.lessons.value.toMutableList()
//        currentLessons.removeIf { it.id == lessonQuizFinish?.id}
//        lessonQuizFinish?.let { updatedLessons ->
//            currentLessons.add(updatedLessons)
//        }

        _lessons.value = this.lessons.value.map {
            it.copy(isFinished = it.id == newQuizzes.first().lessonId)
        }
//        _lessons.value = currentLessons
        _quizzes.value = currentQuizzes
    }
}