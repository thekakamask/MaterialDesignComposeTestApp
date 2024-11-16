package com.dcac.materialdesigncomposetestapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class WellnessAdvice(
    @StringRes val name: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int,
)
