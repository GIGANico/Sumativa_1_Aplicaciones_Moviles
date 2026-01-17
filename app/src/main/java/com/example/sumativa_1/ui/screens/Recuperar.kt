package com.example.sumativa_1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.sumativa_1.ui.theme.*

@Composable
fun Recuperar(alVolver: () -> Unit) {
    var correo by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Box(modifier = Modifier.fillMaxSize().background(MoradoOscuro), contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier.fillMaxWidth(0.85f),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MoradoMedio)
        ) {
            Column(modifier = Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("RECUPERAR CLAVE", color = Color.White, style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(15.dp))

                Text(
                    "Ingrese su correo para enviar instrucciones de recuperación.",
                    color = CremaFondo,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(Modifier.height(20.dp))

                OutlinedTextField(
                    value = correo,
                    onValueChange = { correo = it },
                    label = { Text("Correo Electrónico", color = CremaFondo) },
                    leadingIcon = { Icon(Icons.Default.Email, "Icono de sobre", tint = CremaFondo) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        unfocusedBorderColor = GrisLavanda
                    )
                )

                Button(
                    onClick = {
                        Toast.makeText(contexto, "Correo enviado a $correo", Toast.LENGTH_LONG).show()
                        alVolver()
                    },
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = VerdeGris)
                ) {
                    Text("ENVIAR", color = MoradoOscuro)
                }

                TextButton(onClick = alVolver) {
                    Text("Volver al Login", color = GrisLavanda)
                }
            }
        }
    }
}