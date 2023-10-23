package com.tech2secure.ddj.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Dashboard(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Dashboard")
        Button(onClick = {
            navController.navigate("settings")
        }) {
            Text(text = "Settings")
        }
    }
}