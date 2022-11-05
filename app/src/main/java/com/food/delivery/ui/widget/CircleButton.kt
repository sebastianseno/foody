package com.food.delivery.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.food.delivery.R

@Composable
@Preview
fun CircularButton(
    modifier: Modifier = Modifier,
    icon : Painter = painterResource(id = R.drawable.ic_favorite)
) {
    Button(
        onClick = { /*TODO*/ },
        modifier= modifier
            .size(50.dp)
            .padding(5.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor  =  MaterialTheme.colors.secondary)
    ) {
        Image(icon, contentDescription = "content description")
    }
}