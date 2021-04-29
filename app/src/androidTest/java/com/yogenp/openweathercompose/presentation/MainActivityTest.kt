package com.yogenp.openweathercompose.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityTest : TestCase() {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun ui_components_test() {
        composeTestRule.onNodeWithText(text = "Bedfordshire Police", substring = true)
            .performClick()
        composeTestRule.onNodeWithText(text = "Bedfordshire Police is dedicated", ignoreCase = true, substring = true)
            .assertIsDisplayed()
    }

}