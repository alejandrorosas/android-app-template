package dev.alejandrorosas.apptemplate

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("dev.alejandrorosas.apptemplate", appContext.packageName)
    }

    @Test
    fun testNavigation() {
        composeTestRule.onNodeWithText("Navigate to Feature").performClick()

        composeTestRule.onNodeWithTag("FeatureTemplateText").assertTextEquals("FAB has been clicked 5 times")

        composeTestRule.onNodeWithTag("FeatureTemplateBack").performClick()

        composeTestRule.onNodeWithText("Navigate to Feature").assertIsDisplayed()
    }
}
