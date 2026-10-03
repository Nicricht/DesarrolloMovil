package com.example.seguimientosiniestros.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.seguimientosiniestros.data.repository.RepositoryProvider
import com.example.seguimientosiniestros.ui.screens.ConsultaScreen
import com.example.seguimientosiniestros.ui.screens.DetalleScreen
import com.example.seguimientosiniestros.ui.screens.EvidenciasScreen
import com.example.seguimientosiniestros.ui.screens.HistorialScreen
import com.example.seguimientosiniestros.ui.screens.InicioScreen
import com.example.seguimientosiniestros.ui.screens.NotificacionesScreen
import com.example.seguimientosiniestros.ui.screens.SeguimientoScreen
import com.example.seguimientosiniestros.ui.viewmodel.MainViewModel
import com.example.seguimientosiniestros.ui.viewmodel.MainViewModelFactory

@Composable
fun SeguimientoSiniestrosApp() {
    val navController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val repository = remember(context) {
        RepositoryProvider.provideSiniestroRepository(context)
    }
    val mainViewModel: MainViewModel = viewModel(
        factory = MainViewModelFactory(repository)
    )
    val uiState by mainViewModel.uiState.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Destino.INICIO,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Destino.INICIO) {
                InicioScreen(
                    onConsultar = { navController.navigate(Destino.CONSULTA) },
                    onNotificaciones = { navController.navigate(Destino.NOTIFICACIONES) }
                )
            }

            composable(Destino.CONSULTA) {
                ConsultaScreen(
                    onVolver = { navController.popBackStack() },
                    onBuscar = { siniestroId ->
                        navController.navigate(Destino.detalle(siniestroId))
                    }
                )
            }

            composable(
                route = Destino.DETALLE,
                arguments = listOf(navArgument("siniestroId") { type = NavType.StringType })
            ) { backStackEntry ->
                val siniestroId = backStackEntry.arguments?.getString("siniestroId").orEmpty()

                DetalleScreen(
                    siniestroId = siniestroId,
                    uiState = uiState,
                    onCargar = { mainViewModel.consultarSiniestro(siniestroId) },
                    onVolver = { navController.popBackStack() },
                    onSeguimiento = {
                        navController.navigate(Destino.seguimiento(siniestroId))
                    },
                    onHistorial = {
                        navController.navigate(Destino.historial(siniestroId))
                    },
                    onEvidencias = {
                        navController.navigate(Destino.evidencias(siniestroId))
                    }
                )
            }

            composable(
                route = Destino.SEGUIMIENTO,
                arguments = listOf(navArgument("siniestroId") { type = NavType.StringType })
            ) { backStackEntry ->
                val siniestroId = backStackEntry.arguments?.getString("siniestroId").orEmpty()

                SeguimientoScreen(
                    siniestroId = siniestroId,
                    uiState = uiState,
                    onCargar = { mainViewModel.consultarSiniestro(siniestroId) },
                    onVolver = { navController.popBackStack() }
                )
            }

            composable(
                route = Destino.HISTORIAL,
                arguments = listOf(navArgument("siniestroId") { type = NavType.StringType })
            ) { backStackEntry ->
                val siniestroId = backStackEntry.arguments?.getString("siniestroId").orEmpty()

                HistorialScreen(
                    siniestroId = siniestroId,
                    uiState = uiState,
                    onCargar = { mainViewModel.consultarSiniestro(siniestroId) },
                    onVolver = { navController.popBackStack() }
                )
            }

            composable(
                route = Destino.EVIDENCIAS,
                arguments = listOf(navArgument("siniestroId") { type = NavType.StringType })
            ) { backStackEntry ->
                EvidenciasScreen(
                    siniestroId = backStackEntry.arguments?.getString("siniestroId").orEmpty(),
                    onVolver = { navController.popBackStack() }
                )
            }

            composable(Destino.NOTIFICACIONES) {
                NotificacionesScreen(
                    onVolver = { navController.popBackStack() }
                )
            }
        }
    }
}
