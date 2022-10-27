package com.food.delivery.ui.presentation.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.food.delivery.R
import com.food.delivery.ui.presentation.home.widget.HomeHeaderWidget
import com.food.delivery.ui.presentation.home.widget.SearchAndFilterWidget
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = MaterialTheme.colors.background
    )
    Column(
        Modifier
            .padding(all = 35.dp)
            .verticalScroll(ScrollState(0))
    ) {
        HomeHeaderWidget()
        Spacer(modifier = Modifier.height(48.dp))
        SearchAndFilterWidget()
        Image(
            painter = painterResource(id = R.drawable.img_sample_promo_header),
            contentDescription = "header",
            modifier = Modifier.padding(top = 40.dp)
        )
    }
}