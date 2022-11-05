package com.food.delivery.ui.presentation.home.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.food.delivery.R
import com.food.delivery.ui.theme.Gray
import com.food.delivery.ui.widget.CircularButton

@Composable
@Preview("Card")
fun RestaurantCard() {
    ConstraintLayout(
        Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
            .width(289.dp)
            .padding(bottom = 17.dp)
    ) {
        val (image, favorite, name, duration, rating, chip) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.img_restaurant),
            contentDescription = "rating",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                }
        )
        CircularButton(
            modifier = Modifier
                .padding(end = 5.dp, top = 5.dp)
                .constrainAs(favorite) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
            icon = painterResource(id = R.drawable.ic_heart)
        )
        Text(
            text = "Cream Chicken",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 14.dp, start = 19.dp)
                .constrainAs(name) {
                    start.linkTo(parent.start)
                    top.linkTo(image.bottom)
                }
        )
        Text(
            text = "15min • ",
            color = Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(top = 10.dp, start = 19.dp)
                .constrainAs(duration) {
                    top.linkTo(name.bottom)
                    start.linkTo(name.start)
                }
        )
        Rating(
            modifier = Modifier
                .padding(top = 10.dp)
                .constrainAs(rating) {
                    top.linkTo(name.bottom)
                    start.linkTo(duration.end)
                },
            rating = "5.0"
        )
        ChipGroup(
            modifier = Modifier
                .padding(top = 13.dp, start = 19.dp)
                .constrainAs(chip) {
                    top.linkTo(duration.bottom)
                    start.linkTo(parent.start)

                },
            data = listOf("Burger", "Pizza", "Keju")
        )
    }
}

@Preview("Rating")
@Composable
fun Rating(
    modifier: Modifier = Modifier,
    rating: String = "4.2"
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "rating",
        )
        Text(
            text = rating,
            color = Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 6.dp)
        )
    }
}

@Preview("Chip")
@Composable
fun Chip(
    name: String = "Burger",
    isSelected: Boolean = false,
    textColor: Color = Color.White,
) {
    Surface(
        elevation = 1.dp,
        shape = RoundedCornerShape(8.dp),
        color = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primary
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.body2,
                color = textColor,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChipGroup(
    modifier: Modifier = Modifier,
    data: List<String> = listOf(),
) {
    Column(modifier = modifier.padding(0.dp)) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(data) {
                Chip(
                    name = it,
                )
            }
        }
    }
}