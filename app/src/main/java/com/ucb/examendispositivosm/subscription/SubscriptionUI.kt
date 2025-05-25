package com.ucb.examendispositivosm.subscription

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ucb.examendispositivosm.navigation.Screen

@Composable
fun SubscriptionUI(
    viewModel: SubscriptionViewModel = hiltViewModel(),
    navController: NavController
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) { viewModel.loadPlans() }

    val index by viewModel.currentIndex.collectAsState()
    val plans by viewModel.plans.collectAsState()

    if (plans.isNotEmpty()) {
        val currentPlan = plans[index]

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = currentPlan.name,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = currentPlan.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Precio: ${currentPlan.price}",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Duración del plan: ${currentPlan.duration}",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { viewModel.previousPlan() },
                    enabled = index > 0
                ) {
                    Text("Anterior")
                }

                Button(
                    onClick = { viewModel.nextPlan() },
                    enabled = index < plans.size - 1
                ) {
                    Text("Siguiente")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    val url = "https://wa.me/${"+59164847410".replace("+", "")}?text=${"Hola, UCB mobile, preciso su ayuda".replace(" ", "%20")}"
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(url)
                    }
                    try {
                        context.startActivity(intent)
                    } catch (e: Exception) {
                        Toast.makeText(context, "No se puede abrir WhatsApp", Toast.LENGTH_LONG).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Abrir WhatsApp")
            }


            Button(
                onClick = { navController.navigate(Screen.MapScreen.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ir a Maps")
            }
        }
    }
}