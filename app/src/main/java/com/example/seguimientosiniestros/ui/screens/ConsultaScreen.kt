package com.example.seguimientosiniestros.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.seguimientosiniestros.ui.components.BotonPrincipal
import com.example.seguimientosiniestros.ui.components.PantallaBase
import com.example.seguimientosiniestros.ui.styles.FormaCampo
import com.example.seguimientosiniestros.ui.styles.coloresCampo
import com.example.seguimientosiniestros.validation.SiniestroValidator

@Composable
fun ConsultaScreen(
    onVolver: () -> Unit,
    onBuscar: (String) -> Unit
) {
    var identificador by rememberSaveable { mutableStateOf("") }
    var mostrarError by rememberSaveable { mutableStateOf(false) }
    val mensajeError = if (mostrarError) {
        SiniestroValidator.validarIdentificador(identificador)
    } else {
        null
    }

    PantallaBase(
        titulo = "Consultar siniestro",
        subtitulo = "Ingresa el identificador entregado para tu caso.",
        onVolver = onVolver
    ) {
        OutlinedTextField(
            value = identificador,
            onValueChange = { identificador = it },
            label = { Text(text = "Identificador") },
            supportingText = {
                Text(text = mensajeError ?: "Ejemplo: SIN-2026-001")
            },
            isError = mensajeError != null,
            singleLine = true,
            shape = FormaCampo,
            colors = coloresCampo(),
            modifier = Modifier.fillMaxWidth()
        )

        BotonPrincipal(
            texto = "Buscar siniestro",
            onClick = {
                mostrarError = true

                if (SiniestroValidator.validarIdentificador(identificador) == null) {
                    onBuscar(identificador.trim().uppercase())
                }
            }
        )
    }
}
