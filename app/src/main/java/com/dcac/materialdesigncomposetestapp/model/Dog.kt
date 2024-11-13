package com.dcac.materialdesigncomposetestapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dcac.materialdesigncomposetestapp.R

data class Dog(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

val dogs = listOf(
    Dog(R.drawable.dog_koda, R.string.dog_name_1, 2, R.string.dog_description_1),
    Dog(R.drawable.dog_lola, R.string.dog_name_2, 16, R.string.dog_description_2),
    Dog(R.drawable.dog_frankie, R.string.dog_name_3, 2, R.string.dog_description_3),
    Dog(R.drawable.dog_nox, R.string.dog_name_4, 8, R.string.dog_description_4),
    Dog(R.drawable.dog_faye, R.string.dog_name_5, 8, R.string.dog_description_5),
    Dog(R.drawable.dog_bella, R.string.dog_name_6, 14, R.string.dog_description_6),
    Dog(R.drawable.dog_moana, R.string.dog_name_7, 2, R.string.dog_description_7),
    Dog(R.drawable.dog_tzeitel, R.string.dog_name_8, 7, R.string.dog_description_8),
    Dog(R.drawable.dog_leroy, R.string.dog_name_9, 4, R.string.dog_description_9)
)