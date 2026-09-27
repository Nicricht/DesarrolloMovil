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
import cl.duoc.siniestrosbpo.domain.model.Siniestro

@Composable
fun DetalleScreen(
    siniestro: Siniestro?,
    onSeguimiento: () -> Unit,
    onHistorial: () -> Unit,
    onEvidencias: () -> Unit,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Detalle del siniestro",
            style = MaterialTheme.typography.headlineMedium
        )

        if (siniestro == null) {
            Text(
                text = "No hay un siniestro seleccionado.",
                modifier = Modifier.padding(top = 16.dp)
            )
        } else {
            Text(
                text = siniestro.id,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text("Tipo: ${siniestro.tipo}", modifier = Modifier.padding(top = 8.dp))
            Text("Estado: ${siniestro.estado.textoVisible()}")
            Text("Fecha de ocurrencia: ${siniestro.fechaOcurrencia}")
            Text("Fecha de reporte: ${siniestro.fechaReporte}")
            Text("Equipo asignado: ${siniestro.equipoAsignado ?: "Sin asignar"}")
            siniestro.ultimaActualizacion?.let {
                Text("Última actualización: $it")
            }

            Button(
                onClick = onSeguimiento,
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text("Ver seguimiento")
            }

            Button(
                onClick = onHistorial,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Ver historial")
            }

            Button(
                onClick = onEvidencias,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Ver evidencias")
            }
        }

        Button(
            onClick = onVolver,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Volver")
        }
    }
}

private fun EstadoSiniestro.textoVisible(): String {
    return when (this) {
        EstadoSiniestro.RECIBIDO -> "Recibido"
        EstadoSiniestro.EN_EVALUACION -> "En evaluación"
        EstadoSiniestro.EN_LIQUIDACION -> "En liquidación"
        EstadoSiniestro.CERRADO -> "Cerrado"
    }
}
