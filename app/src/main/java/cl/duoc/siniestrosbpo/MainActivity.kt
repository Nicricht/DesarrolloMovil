package cl.duoc.siniestrosbpo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cl.duoc.siniestrosbpo.ui.theme.SiniestrosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SiniestrosTheme {
                InicioScreen()
            }
        }
    }
}

@Composable
private fun InicioScreen() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
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

            Button(onClick = { }) {
                Text("Consultar siniestro")
            }
        }
    }
}
