package com.example.seguimientosiniestros

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNode
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class SpringBootEndToEndTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun consultaSiniestroRealDesdeSpringBootHastaCompose() {
        composeRule.onNodeWithText("Consultar siniestro")
            .assertIsDisplayed()
            .performClick()

        composeRule.onNodeWithText("Identificador")
            .assertIsDisplayed()
            .performTextInput("SIN-2026-001")

        composeRule.onNodeWithText("Buscar siniestro")
            .assertIsDisplayed()
            .performClick()

        composeRule.waitUntil(timeoutMillis = 20_000) {
            composeRule.onAllNodes(
                hasText("Accidente vehicular")
            ).fetchSemanticsNodes().isNotEmpty()
        }

        composeRule.onNodeWithText("Accidente vehicular")
            .assertIsDisplayed()

        composeRule.onNodeWithText("En evaluación")
            .assertIsDisplayed()

        composeRule.onNodeWithText("Ver historial")
            .assertIsDisplayed()
            .performClick()

        composeRule.waitUntil(timeoutMillis = 20_000) {
            composeRule.onAllNodes(
                hasText("Caso asignado a equipo liquidador", substring = true)
            ).fetchSemanticsNodes().isNotEmpty()
        }

        composeRule.onNode(
            hasText("Caso asignado a equipo liquidador", substring = true)
        ).assertIsDisplayed()
    }
}
