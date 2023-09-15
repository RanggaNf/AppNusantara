package com.dicoding.projectappnusantara

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Nusantara(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable