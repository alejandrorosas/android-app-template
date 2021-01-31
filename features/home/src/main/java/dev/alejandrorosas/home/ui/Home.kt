package dev.alejandrorosas.home.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dev.alejandrorosas.core.ui.AppTheme
import dev.alejandrorosas.home.R

@Composable
fun Home(navController: NavController) {
    Screen { navController.navigate("feature_template") }
}

@Composable
fun Screen(onButtonClick: () -> Unit) {
    AppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(stringResource(id = R.string.app_name))
                    },
                )
            },
        ) {
            ScreenContent(onButtonClick = onButtonClick)
        }
    }
}

@Composable
fun ScreenContent(onButtonClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Button(
            onClick = { onButtonClick() },
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        ) {
            Text("Navigate to Feature")
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    Screen {}
}
