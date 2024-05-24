package com.ammartech.submissionaplikasiandroidpemula

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Martial(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
