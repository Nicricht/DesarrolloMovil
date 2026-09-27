package cl.duoc.siniestrosbpo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HistorialScreen(onVolver: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Historial")
        Text(
            text = "Las gestiones del siniestro aparecerán aquí.",
            modifier = Modifier.padding(top = 16.dp)
        )

        Button(
            onClick = onVolver,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("Volver")
        }
    }
}
