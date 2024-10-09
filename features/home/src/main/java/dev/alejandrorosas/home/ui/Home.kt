package dev.alejandrorosas.home.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.alejandrorosas.core.R
import dev.alejandrorosas.core.ui.AppTheme

@Composable
fun Home(navController: NavController) {
    Screen(onButtonClick = { navController.navigate("feature_template") })
}

@Composable
fun Screen(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    AppTheme {
        Scaffold(
            modifier = modifier,
            topBar = {
                @OptIn(ExperimentalMaterial3Api::class)
                TopAppBar(
                    title = {
                        Text(stringResource(id = R.string.app_name))
                    },
                )
            },
        ) {
            ScreenContent(onButtonClick = onButtonClick, Modifier.padding(it))
        }
    }
}

@Composable
fun ScreenContent(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(16.dp),
    ) {
        Button(
            onClick = { onButtonClick() },
            modifier =
                Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth(),
        ) {
            Text("Navigate to Feature")
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    Screen(onButtonClick = {})
}
