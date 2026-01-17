package com.example.sumativa_1.ui.screens

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.sumativa_1.ui.theme.*
import java.util.Locale
import androidx.compose.foundation.shape.RoundedCornerShape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(alSalir: () -> Unit) {
    val contexto = LocalContext.current
    var textoParaHablar by remember { mutableStateOf("") }

    val tts = remember {
        var textToSpeech: TextToSpeech? = null
        textToSpeech = TextToSpeech(contexto) { status ->
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech?.language = Locale("es", "CL")
            }
        }
        textToSpeech
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Asistente de Voz", color = MoradoOscuro) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = VerdeGris),
                actions = {
                    IconButton(onClick = alSalir) {
                        Icon(Icons.Default.ExitToApp, "Cerrar sesión", tint = MoradoOscuro)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MoradoOscuro)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Escribe para comunicarte:",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = textoParaHablar,
                onValueChange = { textoParaHablar = it },
                modifier = Modifier.fillMaxWidth().height(150.dp),
                placeholder = { Text("Hola, necesito ayuda...", color = GrisLavanda) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = MoradoMedio,
                    unfocusedContainerColor = MoradoMedio
                )
            )

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    tts?.speak(textoParaHablar, TextToSpeech.QUEUE_FLUSH, null, null)
                },
                modifier = Modifier.fillMaxWidth().height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = VerdeGris),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = null, tint = MoradoOscuro)
                Spacer(Modifier.width(8.dp))
                Text("REPRODUCIR VOZ", color = MoradoOscuro, style = MaterialTheme.typography.labelLarge)
            }

            Spacer(Modifier.height(16.dp))

            Button(
                onClick = {
                    tts?.speak("¡AYUDA! ¡Me estan matando!", TextToSpeech.QUEUE_FLUSH, null, null)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("AYUDA URGENTE", color = Color.White)
            }
        }
    }
}