package dev.alejandrorosas.featuretemplate.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import dev.alejandrorosas.core.ui.AppTheme

@Composable
fun FeatureTemplate(navController: NavController) {
    Screen { navController.popBackStack() }
}

@Composable
fun Screen(featureTemplateViewModel: FeatureTemplateViewModel = hiltNavGraphViewModel(), onNavigateBack: () -> Unit) {
    val counter: Int by featureTemplateViewModel.counter.observeAsState(0)
    AppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Feature Template")
                    },
                    navigationIcon = {
                        IconButton(onClick = { onNavigateBack() }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    IconButton(onClick = { featureTemplateViewModel.onCounterClick() }) {
                        Icon(Icons.Filled.Add, contentDescription = null)
                    }
                }
            },
        ) {
            ScreenContent(counter)
        }
    }
}

@Composable
fun ScreenContent(count: Int) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = "FAB has been clicked $count times",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth(),
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    val fakeViewModel = FeatureTemplateViewModel(1)
    Screen(fakeViewModel) { }
}
