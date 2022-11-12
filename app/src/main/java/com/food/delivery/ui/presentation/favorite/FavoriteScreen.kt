package com.food.delivery.ui.presentation.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.food.delivery.R

@Composable
@Preview
fun FavoriteScreen() {
    Box(
        Modifier
            .background(MaterialTheme.colors.secondary)
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier =
            Modifier
                .fillMaxWidth()
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
    }
}