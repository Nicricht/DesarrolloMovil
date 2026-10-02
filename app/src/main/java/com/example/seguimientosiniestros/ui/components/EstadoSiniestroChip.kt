package com.example.seguimientosiniestros.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.seguimientosiniestros.domain.model.EstadoSiniestro
import com.example.seguimientosiniestros.ui.theme.AmarilloEstado
import com.example.seguimientosiniestros.ui.theme.AmarilloEstadoFondo
import com.example.seguimientosiniestros.ui.theme.AzulEstado
import com.example.seguimientosiniestros.ui.theme.AzulEstadoFondo
import com.example.seguimientosiniestros.ui.theme.GrisEstado
import com.example.seguimientosiniestros.ui.theme.GrisEstadoFondo
import com.example.seguimientosiniestros.ui.theme.VerdeEstado
import com.example.seguimientosiniestros.ui.theme.VerdeEstadoFondo

@Composable
fun EstadoSiniestroChip(
    estado: EstadoSiniestro,
    modifier: Modifier = Modifier
) {
    val (texto, fondo, contenido) = when (estado) {
        EstadoSiniestro.RECIBIDO -> Triple("Recibido", AzulEstadoFondo, AzulEstado)
        EstadoSiniestro.EN_EVALUACION -> Triple("En evaluación", AmarilloEstadoFondo, AmarilloEstado)
        EstadoSiniestro.EN_LIQUIDACION -> Triple("En liquidación", VerdeEstadoFondo, VerdeEstado)
        EstadoSiniestro.CERRADO -> Triple("Cerrado", GrisEstadoFondo, GrisEstado)
    }

    Text(
        text = texto,
        color = contenido,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
            .background(fondo, RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 7.dp)
    )
}
