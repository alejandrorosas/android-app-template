package dev.alejandrorosas.home

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.alejandrorosas.home.ui.Screen

class HomePreviewsScreenshots {
    @Preview
    @Composable
    private fun HomePreview() {
        Screen(onButtonClick = {})
    }

    @Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Composable
    private fun HomePreviewDarkMode() {
        Screen(onButtonClick = {})
    }
}
