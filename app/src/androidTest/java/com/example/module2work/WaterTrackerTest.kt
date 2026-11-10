package com.example.module2work

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.module2work.ui.theme.Module2WorkTheme
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testWaterTrackerButtonsAndDays() {
        // Устанавливаем контент строго внутри лямбды setContent
        composeTestRule.setContent {
            Module2WorkTheme { // Если тема называется иначе, поменяй здесь
                WaterTracker()
            }
        }

        // 1. Проверяем кнопку добавления жидкости
        composeTestRule.onNodeWithText("+250 мл").assertExists()
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertExists()

        // 2. Проверяем кнопку "Завершить день"
        composeTestRule.onNodeWithText("Завершить день").assertExists()
        composeTestRule.onNodeWithText("Завершить день").performClick()

        // 3. Проверяем вывод текста со значением количества дней
        composeTestRule.onNodeWithText("Дней подряд с нормой (>=1500 мл): 0").assertExists()
    }
}