package com.dcac.materialdesigncomposetestapp

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
import com.dcac.materialdesigncomposetestapp.model.Dog
import com.dcac.materialdesigncomposetestapp.model.dogs
import com.dcac.materialdesigncomposetestapp.ui.theme.MaterialDesignComposeTestAppTheme

class WoofActivity : ComponentActivity() {
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
                                        painter = painterResource(R.drawable.logo_woof),
                                        contentDescription = null
                                    )
                                    Text(
                                        text = "Woof",
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
                        WoofApp(context)
                    }
                }
            }
        }
    }
}


@Composable
fun WoofApp(context: Context) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(dogs) {
                DogItem(dog = it)
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
fun DogItem(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier
        .padding(dimensionResource(id = R.dimen.padding_small))
        .clip(MaterialTheme.shapes.small)) {
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            DogIcon(dog.imageResourceId)
            DogInformation(dog.name, dog.age)
        }
    }
}

@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(dogName),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small)),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.extraSmall),
        painter = painterResource(dogIcon),
        contentScale = ContentScale.Crop,

        // Content Description is not needed here - image is decorative, and setting a null content
        // description allows accessibility services to skip this element during navigation.

        contentDescription = null
    )
}



@Preview(showBackground = true)
@Composable
fun WoofActivityPreview() {
    MaterialDesignComposeTestAppTheme(darkTheme = false) {
        WoofApp(context= LocalContext.current)
    }
}