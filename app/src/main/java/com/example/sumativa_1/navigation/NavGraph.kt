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
        startDestination = Screen.Splash.route)
    {
        composable(Screen.Splash.route) {
            Spash(
                onStartClick = {
                    navController.navigate(Screen.Login.route){
                        popUpTo(Screen.Splash.route){
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(Screen.Login.route) {
            Login(
                alEntrar = {
                    navController.navigate(Screen.Principal.route)
                           },
                alRegistrar = {
                    navController.navigate(Screen.Registro.route)
                              },
                alRecuperar = {
                    navController.navigate(Screen.Recuperar.route)
                }
            )
        }
        composable(Screen.Registro.route) {
            Registro(
                alVolver = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Recuperar.route) {
            Recuperar(
                alVolver = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Principal.route) {
            PantallaPrincipal()
        }
    }
}
