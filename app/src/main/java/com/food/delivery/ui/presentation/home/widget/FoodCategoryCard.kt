package com.food.delivery.ui.presentation.home.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.food.delivery.R
import com.food.delivery.ui.theme.OrangePrimary
import com.food.delivery.ui.theme.SoftOrange

@Preview
@Composable
fun FoodCategoryCard() {
    Box(
        Modifier
            .width(141.dp)
            .height(53.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(SoftOrange)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_burger),
            contentDescription = "image food",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
        Text(
            text = "Burgers",
            fontSize = 15.sp,
            color = OrangePrimary,
            modifier = Modifier
                .padding(start = 5.dp)
                .align(Alignment.CenterStart)
        )
    }
}