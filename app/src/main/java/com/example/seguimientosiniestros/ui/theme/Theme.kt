package com.example.seguimientosiniestros.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = AzulPrimario,
    onPrimary = Superficie,
    primaryContainer = AzulPrimarioClaro,
    onPrimaryContainer = AzulPrimarioOscuro,
    background = FondoApp,
    onBackground = TextoPrincipal,
    surface = Superficie,
    onSurface = TextoPrincipal,
    outline = BordeSuave
)

private val DarkColorScheme = darkColorScheme(
    primary = AzulPrimarioClaro,
    onPrimary = AzulPrimarioOscuro
)

@Composable
fun SeguimientoSiniestrosTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}
