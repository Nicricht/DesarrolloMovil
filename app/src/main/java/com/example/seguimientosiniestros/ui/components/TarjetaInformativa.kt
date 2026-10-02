package com.example.seguimientosiniestros.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.seguimientosiniestros.ui.styles.FormaTarjeta
import com.example.seguimientosiniestros.ui.styles.coloresTarjeta
import com.example.seguimientosiniestros.ui.styles.elevacionTarjeta
import com.example.seguimientosiniestros.ui.theme.Dimens
import com.example.seguimientosiniestros.ui.theme.TextoSecundario

@Composable
fun TarjetaInformativa(
    titulo: String,
    descripcion: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = FormaTarjeta,
        colors = coloresTarjeta(),
        elevation = elevacionTarjeta()
    ) {
        Column(
            modifier = Modifier.padding(Dimens.espacioMd),
            verticalArrangement = Arrangement.spacedBy(Dimens.espacioXs)
        ) {
            Text(
                text = titulo,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = descripcion,
                style = MaterialTheme.typography.bodyMedium,
                color = TextoSecundario
            )
        }
    }
}
