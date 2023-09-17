package dev.alejandrorosas.featuretemplate.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.alejandrorosas.core.ui.AppTheme

@Composable
fun FeatureTemplate(navController: NavController) {
    Screen { navController.popBackStack() }
}

@Composable
fun Screen(
    modifier: Modifier = Modifier,
    featureTemplateViewModel: FeatureTemplateViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit,
) {
    val counter: Int by featureTemplateViewModel.counter.observeAsState(0)
    AppTheme {
        Scaffold(
            modifier = modifier,
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Feature Template")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = onNavigateBack,
                            modifier = Modifier.testTag("FeatureTemplateBack"),
                        ) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = null)
                        }
                    },
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier.testTag("FeatureTemplateAdd"),
                    onClick = featureTemplateViewModel::onCounterClick,
                ) {
                    Icon(Icons.Filled.Add, contentDescription = null)
                }
            },
        ) {
            ScreenContent(counter, Modifier.padding(it))
        }
    }
}

@Composable
fun ScreenContent(
    count: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxHeight()
                .fillMaxWidth(),
    ) {
        Text(
            text = "FAB has been clicked $count times",
            textAlign = TextAlign.Center,
            modifier =
                Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
                    .testTag("FeatureTemplateText"),
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    val fakeViewModel = FeatureTemplateViewModel(1)
    Screen(featureTemplateViewModel = fakeViewModel) { }
}
