package com.example.seguimientosiniestros

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class ConsultaFormValidationTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun formularioMuestraErroresVisualesDelIdentificador() {
        composeRule.onNodeWithText("Consultar siniestro")
            .assertIsDisplayed()
            .performClick()

        composeRule.onNodeWithText("Buscar siniestro")
            .assertIsDisplayed()
            .performClick()

        composeRule.onNodeWithText("El identificador es obligatorio.")
            .assertIsDisplayed()

        composeRule.onNodeWithText("Identificador")
            .performTextInput("123")

        composeRule.onNodeWithText("Usa el formato SIN-AAAA-000.")
            .assertIsDisplayed()
    }
}
