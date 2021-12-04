package com.pasukanlangit.id.traffico.model

import com.pasukanlangit.id.traffico.R
import java.util.*

data class DetailLessons(
    /**this lessonId foreign key for data class Lessons*/
    val lessonId: String,
    val id: String = UUID.randomUUID().toString(),
    val logo: Int,
    val title: String,
    val description: String
)

fun getAllLessonItems() =
    listOf(
        DetailLessons(
            lessonId = "Quiz 1",
            logo = R.drawable.rambu_putarbalik,
            title = "Rambu Dilarang Balik Arah",
            description = "Dilarang melakukan putar balik bagi kendaraan bermotor maupun tidak bermotor."
        ),
        DetailLessons(
            lessonId = "Quiz 1",
            logo = R.drawable.rambu_noparking,
            title = "Rambu Dilarang Parkir",
            description = "Dilarang melakukan parkir bagi kendaraan bermotor pada sepanjang jalan yang terpasang rambu ini."
        ),
        DetailLessons(
            lessonId = "Quiz 1",
            logo = R.drawable.rambu_kanan,
            title = "Rambu Dilarang Belok Kanan",
            description = "Dilarang belok kanan bagi kendaraan bermotor maupun tidak bermotor."
        ),
        DetailLessons(
            lessonId = "Quiz 1",
            logo = R.drawable.rambu_kiri,
            title = "Rambu Dilarang Belok Kiri",
            description = "Dilarang belok kiri bagi kendaraan bermotor maupun tidak bermotor."
        ),
        DetailLessons(
            lessonId = "Quiz 1",
            logo = R.drawable.rambu_klakson,
            title = "Rambu Dilarang Klakson",
            description = "Dilarang membunyikan klakson bagi kendaraan bermotor maupun tidak bermotor pada daerah dengan rambu ini demi kenyamanan bersama."
        ),
        DetailLessons(
            lessonId = "Quiz 2",
            logo = R.drawable.rambu_penyempitan,
            title = "Rambu Penyempitan Jalan",
            description = "Peringatan akan adanya penyempitan jalan di depan."
        ),
        DetailLessons(
            lessonId = "Quiz 2",
            logo = R.drawable.rambu_jalanlicin,
            title = "Rambu Jalan Licin",
            description = "Peringatan bahwa jalan yang akan dilewati memiliki permukaan yang licin."
        ),
        DetailLessons(
            lessonId = "Quiz 2",
            logo = R.drawable.rambu_jembatan,
            title = "Rambu Jembatan",
            description = "Peringatan bahwa di depan akan ada jembatan."
        ),
        DetailLessons(
            lessonId = "Quiz 2",
            logo = R.drawable.rambu_banyaktikungan,
            title = "Rambu Banyak Tikungan",
            description = "Peringatan bahwa jalan yang dilewati memiliki banyak tikungan."
        ),
        DetailLessons(
            lessonId = "Quiz 2",
            logo = R.drawable.rambu_simpangtiga,
            title = "Rambu Simpang Tiga",
            description = "Peringatan bahwa pengendara akan dihadapkan dengan pertigaan atau jalan simpang tiga."
        ),
        DetailLessons(
            lessonId = "Quiz 3",
            logo = R.drawable.block,
            title = "Rambu Dilarang Parkir",
            description = "Dilarang melakukan parkir bagi kendaraan bermotor pada sepanjang jalan yang terpasang rambu ini."
        ),
        DetailLessons(
            lessonId = "Quiz 3",
            logo = R.drawable.traffic_light,
            title = "Rambu Dilarang Belok Kanan",
            description = "Dilarang belok kanan bagi kendaraan bermotor maupun tidak bermotor."
        )
    )
