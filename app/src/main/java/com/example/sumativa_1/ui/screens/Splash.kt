package com.example.sumativa_1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sumativa_1.R
import com.example.sumativa_1.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun Splash(onTimeout: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(4000)
        onTimeout()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )

        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_app),
                contentDescription = "Logotipo de la herramienta de accesibilidad sensorial",
                modifier = Modifier.size(150.dp)
            )

            Spacer(Modifier.height(24.dp))

            Surface(
                color = MoradoOscuro.copy(alpha = 0.8f),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "HERRAMIENTA DE",
                        color = CremaFondo,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        letterSpacing = 4.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "ACCESIBILIDAD SENSORIAL",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        lineHeight = 30.sp
                    )
                }
            }

            Spacer(Modifier.height(40.dp))

            Text(
                text = "Cargando Experiencia...",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(Modifier.height(16.dp))

            CircularProgressIndicator(
                color = VerdeGris,
                strokeWidth = 4.dp
            )
        }
    }
}