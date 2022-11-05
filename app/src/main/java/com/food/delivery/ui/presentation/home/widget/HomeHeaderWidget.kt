package com.food.delivery.ui.presentation.home.widget

import android.content.res.Configuration
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.food.delivery.R
import com.food.delivery.shared.modifier.DrawableWrapper

@Preview(name = "Light Mode", showSystemUi = false, showBackground = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED, showBackground = true)
@Composable
fun HomeHeaderWidget() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            DrawableWrapper(
                drawableEnd = R.drawable.ic_chevron_down, drawablePadding = 8.dp
            ) {
                Text(
                    text = "Your Location",
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.onPrimary
                )
            }
            Text(
                text = "Indonesia", fontSize = 18.sp
            )
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .width(0.dp)
        )
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .blur(0.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(color = MaterialTheme.colors.secondary)
                .padding(all = 0.dp)
                .clickable {

                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_bell),
                contentDescription = "notification",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}