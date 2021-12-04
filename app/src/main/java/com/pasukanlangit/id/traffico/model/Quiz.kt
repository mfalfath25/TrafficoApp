package com.pasukanlangit.id.traffico.model

import android.os.Parcelable
import com.pasukanlangit.id.traffico.R
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Quiz(
    val id: String = UUID.randomUUID().toString(),
    val lessonId: String,
    val image: Int,
    val question: String,
    val multipleChoice: List<String>,
    val correctAnswer: String,
    var answerChosen: String = ""
): Parcelable

fun getAllQuizzes() =
    listOf(
        Quiz(
            lessonId = "Quiz 1",
            image = R.drawable.warning,
            question = "Rambu apakah ini?",
            multipleChoice = listOf(
                "Dilarang Berhenti",
                "Dilarang Putar Balik",
                "Dilarang Balik Putar"
            ),
            correctAnswer = "Dilarang Berhenti"
        ),
        Quiz(
            lessonId = "Quiz 1",
            image = R.drawable.traffic_light,
            question = "Rambu apakah ini?",
            multipleChoice = listOf(
                "Dilarang Berhenti",
                "Dilarang Putar Balik",
                "Dilarang Balik Putar",
                "Putar Balik Arah"
            ),
            correctAnswer = "Dilarang Putar Balik"
        ),
        Quiz(
            lessonId = "Quiz 1",
            image = R.drawable.directions,
            question = "Rambu apakah ini?",
            multipleChoice = listOf(
                "Dilarang Berhenti",
                "Dilarang Putar Balik"
            ),
            correctAnswer = "Dilarang Berhenti"
        ),
        Quiz(
            lessonId = "Quiz 1",
            image = R.drawable.warning,
            question = "Rambu apakah ini?",
            multipleChoice = listOf(
                "Dilarang Berhenti",
                "Dilarang Putar Balik",
                "Dilarang Balik Putar",
                "Putar Balik Arah"
            ),
            correctAnswer = "Dilarang Berhenti"
        ),

        Quiz(
            lessonId = "Quiz 2",
            image = R.drawable.warning,
            question = "Rambu apakah ini?",
            multipleChoice = listOf(
                "Dilarang Berhenti",
                "Dilarang Putar Balik",
                "Dilarang Balik Putar",
                "Putar Balik Arah"
            ),
            correctAnswer = "Dilarang Berhenti"
        ),
        Quiz(
            lessonId = "Quiz 2",
            image = R.drawable.traffic_light,
            question = "Rambu apakah ini?",
            multipleChoice = listOf(
                "Dilarang Berhenti",
                "Dilarang Putar Balik",
                "Dilarang Balik Putar",
                "Putar Balik Arah"
            ),
            correctAnswer = "Dilarang Putar Balik"
        ),
        Quiz(
            lessonId = "Quiz 2",
            image = R.drawable.directions,
            question = "Rambu apakah ini?",
            multipleChoice = listOf(
                "Dilarang Berhenti",
                "Dilarang Putar Balik",
                "Dilarang Balik Putar",
                "Putar Balik Arah"
            ),
            correctAnswer = "Dilarang Balik Putar"
        )
    )