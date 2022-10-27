package com.food.delivery.ui.presentation.home.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.food.delivery.R
import com.food.delivery.ui.theme.GraySoft

@Preview
@Composable
fun SearchAndFilterWidget() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var text by rememberSaveable { mutableStateOf("") }
        val trailingIconView = @Composable {
            IconButton(
                onClick = {
                    text = ""
                },
            ) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "",
                    tint = Color.Black
                )
            }
        }
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            placeholder = { Text(text = "Search") },
            modifier = Modifier
                .weight(1f)
                .padding(end = 13.dp),
            shape = RoundedCornerShape(15.dp),
            trailingIcon = trailingIconView,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                placeholderColor = GraySoft,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .blur(0.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(color = MaterialTheme.colors.primary)
                .padding(all = 0.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_filters_white),
                contentDescription = "notification",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}