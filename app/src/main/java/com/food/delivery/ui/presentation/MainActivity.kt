package com.food.delivery.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.food.delivery.MainDestinations
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
                    bottomBar = {
                        CustomBottomNav(
                            tabs = appState.bottomBarTabs,
                            currentRoute = appState.currentRoute ?: appState.bottomBarTabs[0].route,
                            navigateToRoute = appState::navigateToBottomBarRoute
                        )
                    }
                ) {
                    NavHost(
                        navController = appState.navController,
                        startDestination = BottomNavSection.HOME.route,
                        modifier = Modifier.padding(it)
                    ) {
                        addHomeGraph()
                    }
                }
            }
        }
    }

}