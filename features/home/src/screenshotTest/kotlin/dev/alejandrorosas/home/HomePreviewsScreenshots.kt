package dev.alejandrorosas.home

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import dev.alejandrorosas.home.ui.Screen

@PreviewTest
@Preview
@Composable
fun HomePreview() {
    Screen(onButtonClick = {})
}

@PreviewTest
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreviewDarkMode() {
    Screen(onButtonClick = {})
}

