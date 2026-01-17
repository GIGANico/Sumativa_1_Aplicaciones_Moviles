package com.example.sumativa_1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.sumativa_1.Usuario
import com.example.sumativa_1.listaUsuarios
import com.example.sumativa_1.ui.theme.*

@Composable
fun Registro(alVolver: () -> Unit) {
    var nombreComp by remember { mutableStateOf("") }
    var correoElec by remember { mutableStateOf("") }
    var usuario by remember { mutableStateOf("") }
    var passSecret by remember { mutableStateOf("") }
    var aceptoTerminos by remember { mutableStateOf(false) }

    val contexto = LocalContext.current
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize().background(MoradoOscuro), contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier.fillMaxWidth(0.9f).padding(vertical = 20.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MoradoMedio)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("CREAR CUENTA", color = Color.White, style = MaterialTheme.typography.headlineSmall)
                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = nombreComp,
                    onValueChange = { nombreComp = it },
                    label = { Text("Nombre Completo", color = CremaFondo) },
                    leadingIcon = { Icon(Icons.Default.Person, null, tint = CremaFondo) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                )

                Spacer(Modifier.height(8.dp))

                OutlinedTextField(
                    value = correoElec,
                    onValueChange = { correoElec = it },
                    label = { Text("Correo Electrónico", color = CremaFondo) },
                    leadingIcon = { Icon(Icons.Default.Email, null, tint = CremaFondo) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                )

                Spacer(Modifier.height(8.dp))

                OutlinedTextField(
                    value = usuario,
                    onValueChange = { usuario = it },
                    label = { Text("Nombre de Usuario (ID)", color = CremaFondo) },
                    leadingIcon = { Icon(Icons.Default.AccountCircle, null, tint = CremaFondo) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                )

                Spacer(Modifier.height(8.dp))

                OutlinedTextField(
                    value = passSecret,
                    onValueChange = { passSecret = it },
                    label = { Text("Contraseña", color = CremaFondo) },
                    leadingIcon = { Icon(Icons.Default.Lock, null, tint = CremaFondo) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
                )


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 12.dp)
                ) {
                    Text("Acepto términos y condiciones", color = CremaFondo, modifier = Modifier.weight(1f))
                    Switch(checked = aceptoTerminos, onCheckedChange = { aceptoTerminos = it })
                }

                Button(
                    onClick = {
                        if (nombreComp.isBlank() || correoElec.isBlank() || usuario.isBlank() || passSecret.isBlank()) {
                            Toast.makeText(contexto, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
                        } else if (!aceptoTerminos) {
                            Toast.makeText(contexto, "Debe aceptar los términos", Toast.LENGTH_SHORT).show()
                        } else {
                            listaUsuarios.add(Usuario(nombreComp, correoElec, usuario, passSecret))
                            Toast.makeText(contexto, "¡Cuenta creada con éxito!", Toast.LENGTH_SHORT).show()
                            alVolver()
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
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