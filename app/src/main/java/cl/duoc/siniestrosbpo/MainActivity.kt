package cl.duoc.siniestrosbpo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cl.duoc.siniestrosbpo.navigation.AppNavigation
import cl.duoc.siniestrosbpo.ui.theme.SiniestrosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SiniestrosTheme {
                AppNavigation()
            }
        }
    }
}
