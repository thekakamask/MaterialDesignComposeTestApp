package com.dcac.materialdesigncomposetestapp.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dcac.materialdesigncomposetestapp.R
import com.dcac.materialdesigncomposetestapp.data.SuperheroesRepository.superheroes
import com.dcac.materialdesigncomposetestapp.model.Superhero
import com.dcac.materialdesigncomposetestapp.ui.theme.MaterialDesignComposeTestAppTheme

class SuperheroesActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialDesignComposeTestAppTheme {
                val context = LocalContext.current
                Scaffold(topBar = {
                    Column {
                        CenterAlignedTopAppBar(
                            {
                                Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Center) {
                                    Image(
                                        modifier = Modifier
                                            .size(dimensionResource(id = R.dimen.image_size))
                                            .padding(dimensionResource(id = R.dimen.padding_small)),
                                        painter = painterResource(R.drawable.logo_superheroes),
                                        contentDescription = null
                                    )
                                    Text(
                                        text = "Superheroes",
                                        style = MaterialTheme.typography.displayLarge
                                    )
                                }
                            }
                        )
                        HorizontalDivider()
                    }
                }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        SuperheroesApp(context)
                    }
                }
            }
        }
    }
}


@Composable
fun SuperheroesApp(context: Context) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(superheroes) {
                SuperheroesItem(superhero = it)
            }
        }
        HorizontalDivider()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            // Fixed GoHomeButton at the bottom
            GoHomeButton(context = context)
        }
    }
}

@Composable
fun SuperheroesItem(
    superhero : Superhero,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier
        .padding(dimensionResource(id = R.dimen.padding_small))
        .clip(MaterialTheme.shapes.medium)) {
        Row(modifier = modifier
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            SuperheroesInformation(name = superhero.name,description = superhero.description, modifier = Modifier.weight(1f))
            SuperheroesIcon(image = superhero.imageRes)

        }
    }

}

@Composable
fun SuperheroesInformation(
    @StringRes name: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium),
        bottom = dimensionResource(R.dimen.padding_medium),
        start = dimensionResource(R.dimen.padding_medium),
        end = dimensionResource(R.dimen.padding_small)))  {
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(description),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
    }

}

@Composable
fun SuperheroesIcon(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .padding(top = dimensionResource(R.dimen.padding_medium),
                bottom = dimensionResource(R.dimen.padding_medium),
                end = dimensionResource(R.dimen.padding_medium),
                start = dimensionResource(R.dimen.padding_small))
            .size(dimensionResource(R.dimen.image_size))
            .clip(MaterialTheme.shapes.medium),
        painter = painterResource(image),
        contentScale = ContentScale.Crop,

        // Content Description is not needed here - image is decorative, and setting a null content
        // description allows accessibility services to skip this element during navigation.

        contentDescription = null
    )

}

@Preview(showBackground = true)
@Composable
fun SuperheroesActivityPreview() {
    MaterialDesignComposeTestAppTheme(darkTheme = false) {
        //SuperheroesApp(context= LocalContext.current)
        SuperheroesItem(Superhero(R.string.superhero_name_4, R.string.superhero_power_4, R.drawable.superhero_image4))
    }
}