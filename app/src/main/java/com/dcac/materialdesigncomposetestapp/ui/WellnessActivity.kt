package com.dcac.materialdesigncomposetestapp.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dcac.materialdesigncomposetestapp.R
import com.dcac.materialdesigncomposetestapp.data.SuperheroesRepository.superheroes
import com.dcac.materialdesigncomposetestapp.data.WellnessRepository
import com.dcac.materialdesigncomposetestapp.model.Superhero
import com.dcac.materialdesigncomposetestapp.model.WellnessAdvice
import com.dcac.materialdesigncomposetestapp.ui.theme.MaterialDesignComposeTestAppTheme

class WellnessActivity : ComponentActivity() {
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
                                        painter = painterResource(R.drawable.logo_wellness),
                                        contentDescription = null
                                    )
                                    Text(
                                        text = "Wellness",
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
                        WellnessApp(wellnessList = WellnessRepository.WellnessAdvices, context)
                    }
                }
            }
        }
    }
}


@Composable
fun WellnessApp(wellnessList: List<WellnessAdvice>, context: Context) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyRow(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(wellnessList.chunked(2)) { pairOfAdvices ->
                // Découpe la liste en sous-listes de 2 éléments
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                // Limite chaque paire à la moitié de la largeur de l'écran
                ) {
                    pairOfAdvices.forEach { wellnessAdvice ->
                        WellnessCard(wellnessAdvice = wellnessAdvice)
                    }
                }
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
fun WellnessCard(wellnessAdvice: WellnessAdvice,
                 modifier: Modifier= Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer,
        label = "")
    val maxLines = if (expanded) Int.MAX_VALUE else 1
    Card(modifier = modifier
        .clip(MaterialTheme.shapes.medium)
        .padding(8.dp)
        //.height(300.dp)
        .width(300.dp)
    ){
        Column(modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
            .background(color = color)) {
            Text(
                text = LocalContext.current.getString(wellnessAdvice.name),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.padding_small),
                    top = dimensionResource(R.dimen.padding_small))
            )
            Text(
                text = LocalContext.current.getString(wellnessAdvice.title),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.padding_small))

            )
            Image(
                painter = painterResource(wellnessAdvice.image),
                contentDescription = null,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
                    .width(300.dp)            //Image fill all the width available
                    .height(180.dp),          // define fix height
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier
                .fillMaxWidth()) {
                Text(
                    text = LocalContext.current.getString(wellnessAdvice.description),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = maxLines,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(R.dimen.padding_small),)
                        .weight(1f)
                )
                Spacer(modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_small),
                        end = dimensionResource(id = R.dimen.padding_small)))
                WellnessItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )

            }
        }
    }
}

@Composable
private fun WellnessItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessActivityPreview() {
    MaterialDesignComposeTestAppTheme(darkTheme = false) {
        //WellnessApp(context= LocalContext.current)
        WellnessCard(WellnessAdvice(R.string.wellness_day_1,R.string.wellness_title_1,R.drawable.wellness_image_1,R.string.wellness_description_1))

    }
}