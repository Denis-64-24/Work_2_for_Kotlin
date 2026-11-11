package com.example.module2work

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import com.example.module2work.ui.theme.Module2WorkTheme
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // Указываем MainActivity вместо ComponentActivity

    @Test
    fun testWaterTrackerButtonsAndDays() {

        composeTestRule.onNodeWithText("--- Задания 8-9: Трекер воды ---").performScrollTo()

        // 1. Проверяем кнопку добавления жидкости
        composeTestRule.onNodeWithText("+250 мл").assertExists()
        composeTestRule.onNodeWithText("+250 мл").performClick()
        //composeTestRule.onNodeWithText("250 мл").assertExists()

        // 2. Проверяем кнопку "Завершить день"
        composeTestRule.onNodeWithText("Завершить день").assertExists()
        composeTestRule.onNodeWithText("Завершить день").performClick()

        // 3. Проверяем вывод текста со значением количества дней
        composeTestRule.onNodeWithText("Дней подряд с нормой (>=1500 мл): 0").assertExists()
    }
}