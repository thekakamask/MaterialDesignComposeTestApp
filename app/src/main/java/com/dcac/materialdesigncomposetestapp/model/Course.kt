package com.dcac.materialdesigncomposetestapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
cd AZn
data class Course
    (@StringRes val courseTitle : Int,
     val courseNumber : Int,
     @DrawableRes val courseResourceId: Int)