package com.example.sumativa_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.compose.rememberNavController
import com.example.sumativa_1.navigation.NavGraph
import com.example.sumativa_1.ui.theme.Sumativa_1Theme

data class Usuario(
    val nombreCompleto: String,
    val correo: String,
    val nombreUsuario: String,
    val clave: String
)

// Requerimiento: Array de 5 usuarios registrados (Sumativa 1)
val listaUsuarios = mutableStateListOf(
    Usuario("admin admin", "admin@admin", "admin", "1234"),
    Usuario("profe profe", "profe@profe", "profe", "duoc2026"),
    Usuario("alumno alumno", "alumno@alumno", "alumno", "1234"),
    Usuario("invitado invitado", "invitado@invitado", "invitado", "inv123"),
    Usuario("test test", "test@test", "test", "test")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sumativa_1Theme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}