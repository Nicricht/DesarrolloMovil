package cl.duoc.siniestrosbpo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InicioScreen(
    onConsultar: () -> Unit,
    onNotificaciones: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Seguimiento de Siniestros",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Consulta el estado de tus siniestros de forma simple.",
            modifier = Modifier.padding(top = 12.dp, bottom = 24.dp)
        )

        Button(onClick = onConsultar) {
            Text("Consultar siniestro")
        }

        Button(
            onClick = onNotificaciones,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            Text("Notificaciones")
        }
    }
}
