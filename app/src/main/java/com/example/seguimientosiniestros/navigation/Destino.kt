package com.example.seguimientosiniestros.navigation

object Destino {
    const val INICIO = "inicio"
    const val CONSULTA = "consulta"
    const val DETALLE = "detalle/{siniestroId}"
    const val SEGUIMIENTO = "seguimiento/{siniestroId}"
    const val HISTORIAL = "historial/{siniestroId}"
    const val EVIDENCIAS = "evidencias/{siniestroId}"
    const val NOTIFICACIONES = "notificaciones"

    fun detalle(siniestroId: String) = "detalle/$siniestroId"
    fun seguimiento(siniestroId: String) = "seguimiento/$siniestroId"
    fun historial(siniestroId: String) = "historial/$siniestroId"
    fun evidencias(siniestroId: String) = "evidencias/$siniestroId"
}
