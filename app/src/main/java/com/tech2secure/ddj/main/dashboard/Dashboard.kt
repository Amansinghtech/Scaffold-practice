package com.tech2secure.ddj.main.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.tech2secure.ddj.data.repositories.Product

@Composable
fun Dashboard(
    navController: NavController,
    dashboardViewModel: DashboardViewModel = hiltViewModel()
) {

    val dashboardUiState = dashboardViewModel.dashboardUiState.collectAsState().value

//    LaunchedEffect(key1 = Unit) {
//        dashboardViewModel.fetchData()
//    }

    when (dashboardUiState) {
        is DashboardUiState.Loading -> {
            Text(text = "Loading...")
        }

        is DashboardUiState.Success -> {
            DashboardContent(productsList = dashboardUiState.products)
        }

        is DashboardUiState.Error -> {
            Text(text = "Error: ${dashboardUiState.message}")
        }
    }

}

@Composable
private fun DashboardContent(productsList: List<Product>) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(productsList) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(16.dp)
            ) {
                AsyncImage(
                    model = it.image,
                    contentDescription = null,
                    modifier = Modifier.size(120.dp, 120.dp)
                )
                Text(text = "name: ${it.name}")
                Text(text = "price: ${it.price}")
                Text(text = "SKU: ${it.SKU}")
                Text(
                    text = "description: ${it.description}",
                    modifier = Modifier.width(120.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
