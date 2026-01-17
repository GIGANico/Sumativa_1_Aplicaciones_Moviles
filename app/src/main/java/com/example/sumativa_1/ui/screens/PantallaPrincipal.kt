package com.example.sumativa_1.ui.screens

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.sumativa_1.ui.theme.*
import java.util.Locale

@Composable
fun PantallaPrincipal() {
    val ctx = LocalContext.current
    val frases = listOf("Hola", "¿Cómo estás?", "Necesito ayuda", "Tengo hambre", "Gracias")
    val tts = remember {
        var t: TextToSpeech? = null
        t = TextToSpeech(ctx) { if (it == TextToSpeech.SUCCESS) t?.language = Locale("es", "ES") }
        t
    }

    Surface(modifier = Modifier.fillMaxSize(), color = MoradoOscuro) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(Icons.Default.RecordVoiceOver, null, tint = CremaFondo, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(frases) { f ->
                    Card(onClick = { tts?.speak(f, TextToSpeech.QUEUE_FLUSH, null, null) }, modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp), colors = CardDefaults.cardColors(containerColor = CremaFondo, contentColor = MoradoOscuro)) {
                        Text(f, modifier = Modifier.padding(20.dp), style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
        }
    }
}