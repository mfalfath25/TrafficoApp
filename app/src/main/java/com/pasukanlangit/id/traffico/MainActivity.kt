package com.pasukanlangit.id.traffico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.pasukanlangit.id.traffico.databinding.ActivityMainBinding
import com.pasukanlangit.id.traffico.model.Quiz

enum class PageNavigate(val id: Int){
    LESSON(R.id.lessonFragment)
}
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.containerMain.id) as NavHostFragment
        navController = navHostFragment.findNavController()

        binding.btmNavMain.setupWithNavController(navController)

        intent.getParcelableArrayListExtra<Quiz>(NEW_QUIZZES)?.let { newQuizzes ->
            viewModel.updateQuizzes(newQuizzes)
        }
    }

    fun navigateToPage(pageNavigate: PageNavigate){
        navController.navigate(pageNavigate.id)
    }

    companion object {
        const val NEW_QUIZZES = "NEW_QUIZZES"
    }
}