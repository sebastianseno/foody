package com.food.delivery.ui.presentation.home.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.food.delivery.R
import com.food.delivery.ui.theme.Black
import com.food.delivery.ui.theme.FoodDeliveryTheme
import com.food.delivery.ui.theme.Gray

@Composable
fun TrendingFoodCard(
    onClick: () -> Unit = {}
) {
    Box(modifier = Modifier
        .padding(end = 12.dp)

    ) {
        Box(modifier = Modifier.height(260.dp)) {
            ConstraintLayout(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
                    .padding(15.dp)
                    .clickable {
                        onClick()

                    }
                ,
            ) {
                val (space, title, duration, rating, price, checkout) = createRefs()
                Spacer(modifier = Modifier
                    .height(50.dp)
                    .constrainAs(space) {
                        top.linkTo(parent.top)
                    }
                )
                Text(
                    text = "Cream Chicken",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .constrainAs(title) {
                            start.linkTo(parent.start)
                            top.linkTo(space.bottom)
                        }
                )
                Text(
                    text = "15min • ",
                    color = Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .constrainAs(duration) {
                            top.linkTo(title.bottom)
                            start.linkTo(title.start)
                        }
                )
                Rating(
                    modifier = Modifier
                        .constrainAs(rating) {
                            top.linkTo(title.bottom)
                            start.linkTo(duration.end)
                    },
                    rating = "5.0"
                )
                Text(
                    text = "$14.99",
                    color = Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .constrainAs(price) {
                            top.linkTo(duration.bottom)
                            start.linkTo(title.start)
                        }
                )
                Box(
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .blur(0.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(color = MaterialTheme.colors.primary)
                        .padding(all = 0.dp)
                        .constrainAs(checkout) {
                            top.linkTo(price.top)
                            bottom.linkTo(price.bottom)
                            end.linkTo(parent.end)
                        }
                        .clickable {

                        },
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_cart),
                        contentDescription = "notification",
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.img_plate_food),
            contentDescription = "plate",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .width(144.dp)
                .height(144.dp)
                .clickable {
                    onClick()
                }
        )
    }
}

@Composable
@Preview
private fun TrendingFoodCardPreview() {
    FoodDeliveryTheme {
        TrendingFoodCard()
    }
}