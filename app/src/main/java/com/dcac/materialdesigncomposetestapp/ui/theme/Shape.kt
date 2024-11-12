package com.dcac.materialdesigncomposetestapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(50.dp),

    small = RoundedCornerShape(
        topStart = 15.dp,
        topEnd = 50.dp,
        bottomStart = 15.dp,
        bottomEnd = 15.dp
    ),

    medium = RoundedCornerShape(bottomStart = 16.dp, topEnd = 16.dp)
)