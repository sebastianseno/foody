package com.food.delivery.ui.presentation.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.food.delivery.R
import com.food.delivery.ui.presentation.home.widget.FoodCategoryCard
import com.food.delivery.ui.presentation.home.widget.HomeHeaderWidget
import com.food.delivery.ui.presentation.home.widget.SearchAndFilterWidget
import com.food.delivery.ui.presentation.home.widget.TrendingFoodCard
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
        Row(
            modifier = Modifier
                .padding(top = 30.dp)
                .horizontalScroll(
                    ScrollState(4)
                )

        ) {
           FoodCategoryCard()
           FoodCategoryCard()
           FoodCategoryCard()
           FoodCategoryCard()
        }
        Text(
            text = "Trending Now",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 35.dp)
        )
        Row(
            modifier = Modifier
                .padding(top = 12.dp)
                .horizontalScroll(
                    ScrollState(4)
                )

        ) {
            TrendingFoodCard()
            TrendingFoodCard()
            TrendingFoodCard()
            TrendingFoodCard()
            TrendingFoodCard()
            TrendingFoodCard()
        }
    }
}