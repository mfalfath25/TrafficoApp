package com.pasukanlangit.id.traffico.model

import android.os.Parcelable
import com.pasukanlangit.id.traffico.R
import kotlinx.parcelize.Parcelize


@Parcelize
data class LessonsModel(
    val logo: Int,
    val title: String,
    val description: String,
    val id: String,
    var isFinished: Boolean = false
): Parcelable


fun getLessons() =
    listOf(
        LessonsModel(
            R.drawable.block,
            "Lesson 1",
            "Rambu Larangan",
            "Quiz 1"
        ),
        LessonsModel(
            R.drawable.warning,
            "Lesson 2",
            "Rambu Peringatan",
            "Quiz 2"
        ),
        LessonsModel(
            R.drawable.directions,
            "Lesson 3",
            "Rambu Petunjuk",
            "Quiz 3"
        ),
        LessonsModel(
            R.drawable.traffic_light,
            "Lesson 4",
            "Etika Berkendara",
            "Quiz 4"
        )
    )