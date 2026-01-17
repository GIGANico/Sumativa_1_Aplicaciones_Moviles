package com.example.sumativa_1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sumativa_1.R
import com.example.sumativa_1.ui.theme.*

@Composable
fun Spash(onStartClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(MoradoOscuro), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(modifier = Modifier.size(140.dp), shape = CircleShape, elevation = CardDefaults.cardElevation(10.dp)) {
                Image(painter = painterResource(id = R.drawable.logo_app), contentDescription = null, contentScale = ContentScale.Crop)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text("VozInclusiva", color = CremaFondo, style = MaterialTheme.typography.headlineLarge)
            Button(onClick = onStartClick, modifier = Modifier.padding(top = 40.dp).fillMaxWidth(0.6f), colors = ButtonDefaults.buttonColors(containerColor = VerdeGris)) {
                Text("COMENZAR", color = MoradoOscuro)
            }
        }
    }
}