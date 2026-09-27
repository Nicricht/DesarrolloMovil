package cl.duoc.siniestrosbpo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.duoc.siniestrosbpo.ui.screens.ConsultaScreen
import cl.duoc.siniestrosbpo.ui.screens.DetalleScreen
import cl.duoc.siniestrosbpo.ui.screens.EvidenciasScreen
import cl.duoc.siniestrosbpo.ui.screens.HistorialScreen
import cl.duoc.siniestrosbpo.ui.screens.InicioScreen
import cl.duoc.siniestrosbpo.ui.screens.NotificacionesScreen
import cl.duoc.siniestrosbpo.ui.screens.SeguimientoScreen
import cl.duoc.siniestrosbpo.ui.viewmodel.MainViewModel

@Composable
fun AppNavigation(
    mainViewModel: MainViewModel = viewModel()
) {
    val navController = rememberNavController()
    val uiState = mainViewModel.uiState

    NavHost(
        navController = navController,
        startDestination = AppRoutes.INICIO
    ) {
        composable(AppRoutes.INICIO) {
            InicioScreen(
                onConsultar = { navController.navigate(AppRoutes.CONSULTA) },
                onNotificaciones = { navController.navigate(AppRoutes.NOTIFICACIONES) }
            )
        }

        composable(AppRoutes.CONSULTA) {
            ConsultaScreen(
                idSiniestro = uiState.idSiniestro,
                mensajeError = uiState.mensajeError,
                onIdChange = mainViewModel::actualizarIdSiniestro,
                onBuscar = {
                    if (mainViewModel.buscarSiniestro()) {
                        navController.navigate(AppRoutes.DETALLE)
                    }
                },
                onVolver = { navController.popBackStack() }
            )
        }

        composable(AppRoutes.DETALLE) {
            DetalleScreen(
                siniestro = uiState.siniestroEncontrado,
                onSeguimiento = { navController.navigate(AppRoutes.SEGUIMIENTO) },
                onHistorial = { navController.navigate(AppRoutes.HISTORIAL) },
                onEvidencias = { navController.navigate(AppRoutes.EVIDENCIAS) },
                onVolver = { navController.popBackStack() }
            )
        }

        composable(AppRoutes.SEGUIMIENTO) {
            SeguimientoScreen(
                estadoActual = uiState.siniestroEncontrado?.estado,
                onVolver = { navController.popBackStack() }
            )
        }

        composable(AppRoutes.HISTORIAL) {
            HistorialScreen(
                historial = uiState.historial,
                onVolver = { navController.popBackStack() }
            )
        }

        composable(AppRoutes.EVIDENCIAS) {
            EvidenciasScreen(
                onVolver = { navController.popBackStack() }
            )
        }

        composable(AppRoutes.NOTIFICACIONES) {
            NotificacionesScreen(
                onVolver = { navController.popBackStack() }
            )
        }
    }
}
