package com.example.deliveryunah

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.deliveryunah.ui.theme.DeliveryunahTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa Firebase
        FirebaseApp.initializeApp(this)

        setContent {
            DeliveryunahTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color(0xFF002D62)), // Azul oscuro
                        onContinue = {
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                        },
                        onLogin = {
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onContinue: () -> Unit,
    onLogin: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Mostrar el logo (asegúrate de que este archivo esté en 'res/drawable')
        Image(
            painter = painterResource(id = R.drawable.puma_unah),
            contentDescription = "Logo Puma",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "¡PumaEats!",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFFFFD700) // Amarillo oro
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Botón para continuar
        Button(onClick = onContinue, modifier = Modifier.padding(vertical = 10.dp)) {
            Text(text = "Continuar")
        }

        // Botón para iniciar sesión
        Button(onClick = onLogin, modifier = Modifier.padding(vertical = 10.dp)) {
            Text(text = "Iniciar sesión")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DeliveryunahTheme {
        MainScreen(
            onContinue = {},
            onLogin = {}
        )
    }
}
