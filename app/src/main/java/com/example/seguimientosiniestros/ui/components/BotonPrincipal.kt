package com.example.seguimientosiniestros.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.seguimientosiniestros.ui.styles.FormaBoton
import com.example.seguimientosiniestros.ui.styles.coloresBotonPrincipal
import com.example.seguimientosiniestros.ui.styles.estiloBotonPrincipal

@Composable
fun BotonPrincipal(
    texto: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = FormaBoton,
        colors = coloresBotonPrincipal(),
        modifier = modifier.estiloBotonPrincipal()
    ) {
        Text(text = texto)
    }
}
