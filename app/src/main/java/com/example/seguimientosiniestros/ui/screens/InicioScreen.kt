package com.example.seguimientosiniestros.ui.screens

import androidx.compose.runtime.Composable
import com.example.seguimientosiniestros.ui.components.BotonPrincipal
import com.example.seguimientosiniestros.ui.components.PantallaBase
import com.example.seguimientosiniestros.ui.components.TarjetaInformativa

@Composable
fun InicioScreen(
    onConsultar: () -> Unit,
    onNotificaciones: () -> Unit
) {
    PantallaBase(
        titulo = "Seguimiento de Siniestros",
        subtitulo = "Consulta el estado de tu siniestro de forma simple y clara."
    ) {
        TarjetaInformativa(
            titulo = "¿Qué puedes hacer?",
            descripcion = "Consultar un siniestro, revisar su seguimiento e historial y acceder a sus evidencias."
        )

        BotonPrincipal(
            texto = "Consultar siniestro",
            onClick = onConsultar
        )

        BotonPrincipal(
            texto = "Ver notificaciones",
            onClick = onNotificaciones
        )
    }
}
