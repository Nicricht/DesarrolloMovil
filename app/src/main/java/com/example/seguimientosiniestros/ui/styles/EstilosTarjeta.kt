package com.example.seguimientosiniestros.ui.styles

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.seguimientosiniestros.ui.theme.Dimens

val FormaTarjeta = RoundedCornerShape(Dimens.radioTarjeta)

@Composable
fun coloresTarjeta() = CardDefaults.cardColors(
    containerColor = MaterialTheme.colorScheme.surface
)

@Composable
fun elevacionTarjeta() = CardDefaults.cardElevation(
    defaultElevation = Dimens.espacioXs
)
