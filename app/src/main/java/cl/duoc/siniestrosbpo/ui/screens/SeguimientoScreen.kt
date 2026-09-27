package cl.duoc.siniestrosbpo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.duoc.siniestrosbpo.domain.model.EstadoSiniestro

@Composable
fun SeguimientoScreen(
    estadoActual: EstadoSiniestro?,
    onVolver: () -> Unit
) {
    val etapas = listOf(
        EstadoSiniestro.RECIBIDO to "Recibido",
        EstadoSiniestro.EN_EVALUACION to "En evaluación",
        EstadoSiniestro.EN_LIQUIDACION to "En liquidación",
        EstadoSiniestro.CERRADO to "Cerrado"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Seguimiento",
            style = MaterialTheme.typography.headlineMedium
        )

        if (estadoActual == null) {
            Text(
                text = "Consulta un siniestro antes de revisar su seguimiento.",
                modifier = Modifier.padding(top = 16.dp)
            )
        } else {
            etapas.forEach { (estado, texto) ->
                val indicador = when {
                    estado.ordinal < estadoActual.ordinal -> "✓"
                    estado == estadoActual -> "●"
                    else -> "○"
                }

                Text(
                    text = "$indicador $texto",
                    modifier = Modifier.padding(top = 12.dp)
                )
            }

            Text(
                text = "Estado actual: ${etapas.first { it.first == estadoActual }.second}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 20.dp)
            )
        }

        Button(
            onClick = onVolver,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("Volver")
        }
    }
}
