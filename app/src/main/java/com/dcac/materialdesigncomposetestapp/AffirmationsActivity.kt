package com.dcac.materialdesigncomposetestapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import com.dcac.materialdesigncomposetestapp.data.AffirmationsDatasource
import com.dcac.materialdesigncomposetestapp.model.Affirmation
import com.dcac.materialdesigncomposetestapp.ui.theme.MaterialDesignComposeTestAppTheme

class AffirmationsActivity : ComponentActivity() {
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
                                        painter = painterResource(R.drawable.logo_affirmations),
                                        contentDescription = null
                                    )
                                    Text(
                                        text = "Affirmations",
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
                        AffirmationsApp(context)
                    }
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp(context: Context) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        // Display the list of affirmations using the AffirmationsList composable
        AffirmationsList(
            affirmationList = AffirmationsDatasource().loadAffirmations(),      // Load data from Datasource
            modifier = Modifier.weight(1f)  // Fills remaining space in the Column
        )
        HorizontalDivider()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            // Fixed GoHomeButton at the bottom
            GoHomeButton(context = context)
        }

    }
    // Get the direction of the layout (for example, for right-to-left language management)
    /*val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()                       // Fills all available space
            .statusBarsPadding()                // Add padding to avoid overlapping with the status bar
            .padding(                          // Set specific margins based on layout direction
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),        // Calculation of padding for the start of the layout
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection),         // Calculation of padding for the end of the layout
            ),
    ) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            // Display the list of affirmations using the AffirmationsList composable
            AffirmationsList(
                affirmationList = Datasource().loadAffirmations(),      // Load data from Datasource
                modifier = Modifier.weight(1f)  // Fills remaining space in the Column
            )
            // Fixed GoHomeButton at the bottom
            GoHomeButton(context = context)

        }
    }*/
}

@Composable
fun AffirmationsList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    //Use a LazyColumn for display the list
    LazyColumn(modifier = modifier) {
        // Add each affirmation as list element
        items(affirmationList) { affirmation ->
            // Display each statement in a card with padding around each card
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))      // Add a space around each card in the list
            )
        }
    }

}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    // Create a map with the properties of the modifier passed as an argument
    Card(modifier = modifier.clip(MaterialTheme.shapes.small)) {
        Column(modifier = Modifier.fillMaxSize()){
            // Display an image using a painter to load the resource
            Image(
                painter = painterResource(affirmation.imageResourceId),     // Load the image associated with the assertion
                contentDescription = stringResource(affirmation.stringResourceId),   // Describe the image for accessibility
                modifier = Modifier
                    .fillMaxWidth()            //Image fill all the width available
                    .height(194.dp),          // define fix height
                contentScale = ContentScale.Crop  // Cut the image to fill the space while maintaining the ratio
            )
            //Display a text of the affirmation below the image
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),     // Get the text of the assertion
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),            //adding a padding around the text
                style = MaterialTheme.typography.displayMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AffirmationCardPreview() {
    MaterialDesignComposeTestAppTheme {
        AffirmationsApp(context= LocalContext.current)
        //AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.image1))
    }
}