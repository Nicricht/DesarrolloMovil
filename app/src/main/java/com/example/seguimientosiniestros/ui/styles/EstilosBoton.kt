package com.example.seguimientosiniestros.ui.styles

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.seguimientosiniestros.ui.theme.Dimens

val FormaBoton = RoundedCornerShape(Dimens.radioBoton)

fun Modifier.estiloBotonPrincipal(): Modifier =
    fillMaxWidth().height(Dimens.altoBoton)

@Composable
fun coloresBotonPrincipal() = ButtonDefaults.buttonColors(
    containerColor = MaterialTheme.colorScheme.primary,
    contentColor = MaterialTheme.colorScheme.onPrimary
)
