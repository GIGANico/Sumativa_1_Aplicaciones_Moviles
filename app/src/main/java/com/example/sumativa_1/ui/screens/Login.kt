package com.example.sumativa_1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
    val ctx = LocalContext.current

    Box(modifier = Modifier.fillMaxSize().background(MoradoOscuro),
        contentAlignment = Alignment.Center) {
        Card(modifier = Modifier.fillMaxWidth(0.85f),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MoradoMedio)) {
            Column(modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Card(modifier = Modifier.size(80.dp), shape = CircleShape) {
                    Image(painter = painterResource(id = R.drawable.logo_app),
                        contentDescription = null)
                }
                Spacer(Modifier.height(20.dp))
                OutlinedTextField(
                    value = u,
                    onValueChange = { u = it },
                    label = { Text("Usuario") },
                    leadingIcon = {
                        Icon(Icons.Default.Person, null, tint = CremaFondo)
                                  },
                    modifier = Modifier.fillMaxWidth())
                OutlinedTextField(
                    value = p,
                    onValueChange = { p = it },
                    label = { Text("Clave") },
                    leadingIcon = {
                        Icon(Icons.Default.Lock, null, tint = CremaFondo)
                                  },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth())
                Button(onClick = {
                    if (listaUsuarios.any { it.nombre == u && it.clave == p })
                        alEntrar()
                    else
                        Toast.makeText(ctx, "Error", Toast.LENGTH_SHORT).show() },
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = VerdeGris))
                { Text("ENTRAR", color = MoradoOscuro) }
                TextButton(onClick = alRegistrar) {
                    Text("Crear cuenta", color = CremaFondo)
                }
                TextButton(onClick = alRecuperar) {
                    Text("¿Olvidó su contraseña?", color = GrisLavanda)
                }
            }
        }
    }
}