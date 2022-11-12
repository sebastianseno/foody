package com.food.delivery.ui.presentation.fooddetail.screen

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.food.delivery.R
import com.food.delivery.ui.theme.White
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun FoodDetailScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = MaterialTheme.colors.secondary,
        darkIcons = true
    )
    Box(
        Modifier
            .background(MaterialTheme.colors.secondary)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        //Toolbar
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 20.dp)
        ) {
            TextButton(onClick = {

            }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "back"
                )
            }
            TextButton(onClick = {

            }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = "back"
                )
            }
        }

        Column (Modifier.fillMaxSize()){
            Spacer(
                modifier = Modifier.weight(1f)
            )
            ConstraintLayout(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(White)
                    .weight(2f)
            ) {

            }
        }
        Column (){
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(id = R.drawable.img_plate_food),
                contentDescription = "plate",
                modifier = Modifier
                    .width(277.dp)
                    .height(277.dp)
                    .padding(top = 10.dp)

            )
        }
      
    }
}