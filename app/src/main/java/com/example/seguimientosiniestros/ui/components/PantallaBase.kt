package com.example.seguimientosiniestros.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.seguimientosiniestros.ui.theme.Dimens
import com.example.seguimientosiniestros.ui.theme.TextoSecundario

@Composable
fun PantallaBase(
    titulo: String,
    subtitulo: String? = null,
    onVolver: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = Dimens.pantallaHorizontal,
                vertical = Dimens.pantallaVertical
            ),
        verticalArrangement = Arrangement.spacedBy(Dimens.espacioMd)
    ) {
        if (onVolver != null) {
            TextButton(onClick = onVolver) {
                Text(text = "← Volver")
            }
        }

        Text(
            text = titulo,
            style = MaterialTheme.typography.headlineMedium
        )

        if (subtitulo != null) {
            Text(
                text = subtitulo,
                style = MaterialTheme.typography.bodyLarge,
                color = TextoSecundario
            )
        }

        content()
    }
}
