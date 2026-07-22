package com.homeai.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(onBackClick: () -> Unit = {}) {
    var serverUrl by remember { mutableStateOf("") }
    var mqttBroker by remember { mutableStateOf("") }
    var mqttPort by remember { mutableStateOf("1883") }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                "Server Configuration",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // Server URL
            OutlinedTextField(
                value = serverUrl,
                onValueChange = { serverUrl = it },
                label = { Text("Server URL") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                placeholder = { Text("http://192.168.1.100:8123") }
            )
            
            // MQTT Settings
            Text(
                "MQTT Configuration",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
            )
            
            OutlinedTextField(
                value = mqttBroker,
                onValueChange = { mqttBroker = it },
                label = { Text("MQTT Broker") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                placeholder = { Text("192.168.1.100") }
            )
            
            OutlinedTextField(
                value = mqttPort,
                onValueChange = { mqttPort = it },
                label = { Text("MQTT Port") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                placeholder = { Text("1883") }
            )
            
            // Save Button
            Button(
                onClick = { /* Save settings */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("Save Settings")
            }
            
            // Connection Status
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        "Connection Status",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Server: Connected",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        "MQTT: Disconnected",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        "WebSocket: Ready",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}
