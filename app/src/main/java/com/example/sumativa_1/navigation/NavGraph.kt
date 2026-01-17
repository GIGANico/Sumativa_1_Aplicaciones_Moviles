package com.example.sumativa_1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sumativa_1.ui.screens.*

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Registro : Screen("registro")
    object Recuperar : Screen("recuperar")
    object Principal : Screen("principal")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // Pantalla de Carga (Splash)
        composable(Screen.Splash.route) {
            Splash(
                onTimeout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // Pantalla de Login
        composable(Screen.Login.route) {
            Login(
                alEntrar = {
                    navController.navigate(Screen.Principal.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                alRegistrar = {
                    navController.navigate(Screen.Registro.route)
                },
                alRecuperar = {
                    navController.navigate(Screen.Recuperar.route)
                }
            )
        }

        // Pantalla de Registro
        composable(Screen.Registro.route) {
            Registro(
                alVolver = {
                    navController.popBackStack()
                }
            )
        }

        // Pantalla de Recuperación
        composable(Screen.Recuperar.route) {
            Recuperar(
                alVolver = {
                    navController.popBackStack()
                }
            )
        }

        // Pantalla Principal (Post-Login)
        composable(Screen.Principal.route) {
            PantallaPrincipal(
                alSalir = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Principal.route) { inclusive = true }
                    }
                }
            )
        }
    }
}