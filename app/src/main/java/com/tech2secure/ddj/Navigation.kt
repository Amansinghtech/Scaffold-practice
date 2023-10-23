package com.tech2secure.ddj

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tech2secure.ddj.main.Chats
import com.tech2secure.ddj.main.Dashboard
import com.tech2secure.ddj.main.ProfilePage
import com.tech2secure.ddj.main.SettingsPage
import com.tech2secure.ddj.main.Shorts

object Routes {
    const val DASHBOARD_PAGE = "dashboard"
    const val PROFILE_PAGE = "profile"
    const val SHORTS = "shorts"
    const val CHAT = "chat"
    const val SETTINGS = "settings"
}

data class BottomNavItem(val title: String, val icon: Int, val route: String)

val scaffoldEnabledRoutes = listOf(
    Routes.DASHBOARD_PAGE,
    Routes.PROFILE_PAGE,
    Routes.SHORTS,
    Routes.CHAT,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    Scaffold(
        topBar = {

            if (currentRoute in scaffoldEnabledRoutes) {
                TopAppBar(
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                    ),
                    title = {
                        Text("Top app bar")
                    },
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                )
            }


        },
        bottomBar = {
            if (currentRoute in scaffoldEnabledRoutes) {
                var selectedItem by remember { mutableIntStateOf(0) }
                val items = listOf(
                    BottomNavItem(
                        title = "Dashboard",
                        icon = R.drawable.ic_dashboard,
                        route = Routes.DASHBOARD_PAGE
                    ),
                    BottomNavItem(
                        title = "Chat",
                        icon = R.drawable.ic_chats,
                        route = Routes.CHAT
                    ),
                    BottomNavItem(
                        title = "Shorts",
                        icon = R.drawable.ic_shorts,
                        route = Routes.SHORTS
                    ),
                    BottomNavItem(
                        title = "Profile",
                        icon = R.drawable.ic_profile,
                        route = Routes.PROFILE_PAGE
                    ),
                )
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp)
                                )
                            },
                            label = { Text(item.title) },
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
                                navController.navigate(item.route)
                            }
                        )
                    }
                }
            }

        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            NavHost(
                navController = navController,
                startDestination = Routes.DASHBOARD_PAGE,
                enterTransition = { ->
                    slideInHorizontally(
                        initialOffsetX = { 300 },
                        animationSpec = tween(
                            300,
                            easing = FastOutSlowInEasing
                        )
                    ) + fadeIn(
                        animationSpec = tween(
                            300,
                            easing = FastOutSlowInEasing
                        )
                    )
                },
                exitTransition = {
                    slideOutHorizontally(
                        targetOffsetX = { 0 },
                        animationSpec = tween(
                            300,
                            easing = FastOutSlowInEasing
                        )
                    ) + fadeOut(
                        animationSpec = tween(
                            300,
                            easing = FastOutSlowInEasing
                        )
                    )
                },
            ) {
                composable(Routes.DASHBOARD_PAGE) {
                    Dashboard(navController = navController)
                }
                composable(Routes.PROFILE_PAGE) {
                    ProfilePage()
                }
                composable(Routes.SHORTS) {
                    Shorts()
                }
                composable(Routes.CHAT) {
                    Chats()
                }
                composable(Routes.SETTINGS) {
                    SettingsPage()
                }
            }
        }
    }

}