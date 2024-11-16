package com.dcac.materialdesigncomposetestapp.data

import com.dcac.materialdesigncomposetestapp.R
import com.dcac.materialdesigncomposetestapp.model.Superhero

object SuperheroesRepository {
    val superheroes = listOf(
        Superhero(
            name = R.string.superhero_name_1,
            description = R.string.superhero_power_1,
            imageRes = R.drawable.superhero_image1
        ),
        Superhero(
            name = R.string.superhero_name_2,
            description = R.string.superhero_power_2,
            imageRes = R.drawable.superhero_image2
        ),
        Superhero(
            name = R.string.superhero_name_3,
            description = R.string.superhero_power_3,
            imageRes = R.drawable.superhero_image3
        ),
        Superhero(
            name = R.string.superhero_name_4,
            description = R.string.superhero_power_4,
            imageRes = R.drawable.superhero_image4
        ),
        Superhero(
            name = R.string.superhero_name_5,
            description = R.string.superhero_power_5,
            imageRes = R.drawable.superhero_image5
        ),
        Superhero(
            name = R.string.superhero_name_6,
            description = R.string.superhero_power_6,
            imageRes = R.drawable.superhero_image6
        )
    )
}