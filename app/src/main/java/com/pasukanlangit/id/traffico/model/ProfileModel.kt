package com.pasukanlangit.id.traffico.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileModel(
    val imgUrl: String,
    val name: String
): Parcelable
