package com.example.calculator

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class CalculatorActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun verifyAllButtons() {
        composeTestRule.onNodeWithText("AC").assertExists()
        composeTestRule.onNodeWithText("Del").assertExists()
        composeTestRule.onNodeWithText("+").assertExists()
        composeTestRule.onNodeWithText("-").assertExists()
        composeTestRule.onNodeWithText("/").assertExists()
        composeTestRule.onNodeWithText("x").assertExists()
        composeTestRule.onNodeWithText("=").assertExists()
        composeTestRule.onNodeWithText(".").assertExists()
        composeTestRule.onNodeWithText("1").assertExists()
        composeTestRule.onNodeWithText("2").assertExists()
        composeTestRule.onNodeWithText("3").assertExists()
        composeTestRule.onNodeWithText("4").assertExists()
        composeTestRule.onNodeWithText("5").assertExists()
        composeTestRule.onNodeWithText("6").assertExists()
        composeTestRule.onNodeWithText("7").assertExists()
        composeTestRule.onNodeWithText("8").assertExists()
        composeTestRule.onNodeWithText("9").assertExists()
        composeTestRule.onNodeWithText("0").assertExists()
    }

    @Test
    fun verifyMultiply() {
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("x").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("=").performClick()
        composeTestRule.onNodeWithTag("input_result").assertTextEquals("25.0")
    }

    @Test
    fun verifySubtract() {
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("-").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("=").performClick()
        composeTestRule.onNodeWithTag("input_result").assertTextEquals("70.0")
    }

    @Test
    fun verifyAddition() {
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("=").performClick()
        composeTestRule.onNodeWithTag("input_result").assertTextEquals("110.0")
    }

    @Test
    fun verifyDivide() {
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("/").performClick()
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("=").performClick()
        composeTestRule.onNodeWithTag("input_result").assertTextEquals("10.0")
    }

    @Test
    fun verifyDeleteButton() {
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("Del").performClick()
        composeTestRule.onNodeWithTag("input_result").assertTextEquals("90")
    }

    @Test
    fun verifyClearButton() {
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("0").performClick()
        composeTestRule.onNodeWithText("9").performClick()
        composeTestRule.onNodeWithText("AC").performClick()
        composeTestRule.onNodeWithTag("input_result").assertTextEquals("")
    }

}