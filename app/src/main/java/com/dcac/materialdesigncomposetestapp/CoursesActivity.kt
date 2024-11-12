package com.dcac.materialdesigncomposetestapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dcac.materialdesigncomposetestapp.data.CoursesDataSource
import com.dcac.materialdesigncomposetestapp.model.Course
import com.dcac.materialdesigncomposetestapp.ui.theme.MaterialDesignComposeTestAppTheme

class CoursesActivity : ComponentActivity() {
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
                                        painter = painterResource(R.drawable.logo_courses),
                                        contentDescription = null
                                    )
                                    Text(
                                        text = "Courses",
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
                        CoursesApp(context)
                    }
                }
            }
        }
    }
}


@Composable
fun CoursesApp(context: Context) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = dimensionResource(R.dimen.padding_small)),
            contentPadding = PaddingValues(
                top = dimensionResource(R.dimen.padding_small),
                bottom = dimensionResource(R.dimen.padding_small)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        ) {
            items(CoursesDataSource.courses) { course ->
                CourseCard(course)
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
fun CourseCard(course: Course) {
    Card() {
        Row(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(course.courseResourceId),     // Load the image associated with the assertion
                contentDescription = stringResource(course.courseTitle),   // Describe the image for accessibility
                modifier = Modifier
                    .width(68.dp)            //Image fill all the width available
                    .height(68.dp),          // define fix height
                contentScale = ContentScale.Crop  // Cut the image to fill the space while maintaining the ratio
            )
            Column(modifier = Modifier
                .padding(start = dimensionResource(R.dimen.padding_medium),
                    top=dimensionResource(R.dimen.padding_medium),
                    end=dimensionResource(R.dimen.padding_medium))) {
                Text(
                    text = LocalContext.current.getString(course.courseTitle),     // Get the text of the assertion
                    fontSize = 11.sp, // use a style for the text define in the theme
                    style = MaterialTheme.typography.labelSmall
                )
                Row(modifier=Modifier.padding(top=dimensionResource(R.dimen.padding_small))) {
                    Icon(
                        painter = painterResource(R.drawable.course_icon_list_50),     // Load the image associated with the assertion
                        contentDescription = stringResource(R.string.course_icon_list)   // Describe the image for accessibility ,  // Cut the image to fill the space while maintaining the ratio
                        )
                    Text(
                        text = course.courseNumber.toString(),    // Get the text of the assertion
                        modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_small)),
                        style = MaterialTheme.typography.bodyLarge
                        )
                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CoursesActivityPreview() {
    MaterialDesignComposeTestAppTheme {
        CoursesApp(context= LocalContext.current)
    }
}