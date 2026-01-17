package com.example.sumativa_1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.sumativa_1.Usuario
import com.example.sumativa_1.listaUsuarios
import com.example.sumativa_1.ui.theme.*

@Composable
fun Registro(alVolver: () -> Unit) {
    var nuevoUsuario by remember { mutableStateOf("") }
    var nuevaClave by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MoradoOscuro),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(0.85f),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MoradoMedio),
            elevation = CardDefaults.cardElevation(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "CREAR CUENTA",
                    color = CremaFondo,
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(Modifier.height(20.dp))

                OutlinedTextField(
                    value = nuevoUsuario,
                    onValueChange = { nuevoUsuario = it },
                    label = { Text("Nombre de Usuario") },
                    leadingIcon = { Icon(Icons.Default.Person, null, tint = CremaFondo) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                )

                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    value = nuevaClave,
                    onValueChange = { nuevaClave = it },
                    label = { Text("Contraseña") },
                    leadingIcon = { Icon(Icons.Default.Lock, null, tint = CremaFondo) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                )

                Button(
                    onClick = {
                        if (nuevoUsuario.isNotEmpty() && nuevaClave.isNotEmpty()) {
                            listaUsuarios.add(Usuario(nuevoUsuario, nuevaClave))
                            Toast.makeText(contexto, "¡Usuario registrado con éxito!", Toast.LENGTH_SHORT).show()
                            alVolver()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = VerdeGris)
                ) {
                    Text("REGISTRARME", color = MoradoOscuro)
                }

                TextButton(onClick = alVolver) {
                    Text("Ya tengo cuenta, volver", color = GrisLavanda)
                }
            }
        }
    }
}