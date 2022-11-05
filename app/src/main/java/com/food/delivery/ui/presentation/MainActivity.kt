package com.food.delivery.ui.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
import com.food.delivery.rememberAppState
import com.food.delivery.ui.theme.FoodDeliveryTheme
import com.food.delivery.ui.widget.BottomNavSection
import com.food.delivery.ui.widget.CustomBottomNav
import com.food.delivery.ui.widget.addHomeGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberAppState()
            FoodDeliveryTheme {
                Scaffold(
                    backgroundColor = MaterialTheme.colors.background,
                    bottomBar = {
                        if (appState.shouldShowBottomBar) {
                            CustomBottomNav(
                                tabs = appState.bottomBarTabs,
                                currentRoute = appState.currentRoute ?: BottomNavSection.HOME.route,
                                navigateToRoute = appState::navigateToBottomBarRoute
                            )
                        }
                    },
                    content = {
                        NavHost(
                            navController = appState.navController,
                            startDestination = BottomNavSection.HOME.route,
                        ) {
                            addHomeGraph(appState.navController)
                        }
                    }
                )
            }
        }
    }

}