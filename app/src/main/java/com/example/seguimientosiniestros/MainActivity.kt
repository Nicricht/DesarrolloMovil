package com.example.seguimientosiniestros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.seguimientosiniestros.navigation.SeguimientoSiniestrosApp
import com.example.seguimientosiniestros.ui.theme.SeguimientoSiniestrosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SeguimientoSiniestrosTheme {
                SeguimientoSiniestrosApp()
            }
        }
    }
}
