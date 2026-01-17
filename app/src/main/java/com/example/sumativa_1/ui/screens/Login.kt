package com.example.sumativa_1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.sumativa_1.R
import com.example.sumativa_1.listaUsuarios
import com.example.sumativa_1.ui.theme.*

@Composable
fun Login(alEntrar: () -> Unit, alRegistrar: () -> Unit, alRecuperar: () -> Unit) {
    var u by remember { mutableStateOf("") }
    var p by remember { mutableStateOf("") }
    var recordar by remember { mutableStateOf(false) }
    val ctx = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize().background(MoradoOscuro),
        contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier.fillMaxWidth(0.85f),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MoradoMedio)
        ) {
            Column(modifier = Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Card(modifier = Modifier.size(80.dp), shape = CircleShape) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_app),
                        contentDescription = "Logotipo de la aplicación de accesibilidad sensorial"
                    )
                }
                Spacer(Modifier.height(20.dp))

                OutlinedTextField(
                    value = u,
                    onValueChange = { u = it },
                    label = { Text("Usuario", color = CremaFondo) },
                    leadingIcon = { Icon(Icons.Default.Person, "Icono de usuario", tint = CremaFondo) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        unfocusedBorderColor = GrisLavanda,
                        focusedLabelColor = Color.White
                    )
                )

                Spacer(Modifier.height(8.dp))

                OutlinedTextField(
                    value = p,
                    onValueChange = { p = it },
                    label = { Text("Clave", color = CremaFondo) },
                    leadingIcon = { Icon(Icons.Default.Lock, "Icono de seguridad", tint = CremaFondo) },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        unfocusedBorderColor = GrisLavanda,
                        focusedLabelColor = Color.White
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Checkbox(
                        checked = recordar,
                        onCheckedChange = { recordar = it },
                        colors = CheckboxDefaults.colors(uncheckedColor = CremaFondo)
                    )
                    Text("Recordar mi usuario", color = CremaFondo)
                }

                Button(
                    onClick = {
                        if (listaUsuarios.any { it.nombreUsuario == u && it.clave == p }) alEntrar()
                        else Toast.makeText(ctx, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = VerdeGris)
                ) {
                    Text("ENTRAR", color = MoradoOscuro)
                }

                TextButton(onClick = alRegistrar) {
                    Text("Crear cuenta nueva",
                        color = CremaFondo)
                }
                TextButton(onClick = alRecuperar) {
                    Text("¿Olvidó su contraseña?",
                        color = GrisLavanda)
                }
            }
        }
    }
}