package com.tech2secure.ddj.main.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun Dashboard(
    navController: NavController,
    dashboardViewModel: DashboardViewModel = hiltViewModel()
) {

    val user = dashboardViewModel.getUser()
    dashboardViewModel.myName = "hitika"
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Dashboard")
        Text(text = "Name: ${user.name}")
        Text(text = "Age: ${user.age}")
        Text(text = "My Name: ${dashboardViewModel.myName}")
        Button(onClick = {
            navController.navigate("settings")
        }) {
            Text(text = "Settings")
        }

        NewUserName()
    }
}

@Composable
fun NewUserName(dashboardViewModel: DashboardViewModel = hiltViewModel()) {
    Text(text = "My Name: ${dashboardViewModel.myName}")
}
