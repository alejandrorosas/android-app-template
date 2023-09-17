package dev.alejandrorosas.featuretemplate

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.alejandrorosas.featuretemplate.ui.FeatureTemplateViewModel
import dev.alejandrorosas.featuretemplate.ui.Screen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FeatureTemplateTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            Screen(featureTemplateViewModel = FeatureTemplateViewModel(5)) {}
        }
    }

    @Test
    fun testFloatingActionButtonClick() {
        composeTestRule.onNodeWithTag("FeatureTemplateText").assertTextEquals("FAB has been clicked 5 times")

        composeTestRule.onNodeWithTag("FeatureTemplateAdd").performClick()

        composeTestRule.onNodeWithTag("FeatureTemplateText").assertTextEquals("FAB has been clicked 6 times")
    }
}
