package com.food.delivery.ui.widget

import android.util.Log
import androidx.annotation.FloatRange
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.food.delivery.shared.extensions.placeTextAndIcon
import com.food.delivery.ui.presentation.cart.CartScreen
import com.food.delivery.ui.presentation.favorite.FavoriteScreen
import com.food.delivery.ui.presentation.home.screen.HomeScreen

fun NavGraphBuilder.addHomeGraph() {
    composable(BottomNavSection.HOME.route) { from ->
        HomeScreen()
    }
    composable(BottomNavSection.FAVORITE.route) { from ->
        FavoriteScreen()
    }
    composable(BottomNavSection.CART.route) { from ->
        CartScreen()
    }
    composable(BottomNavSection.PROFILE.route) { from ->
        CartScreen()
    }
}

enum class BottomNavSection(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    HOME("Home", Icons.Outlined.Home, "home/home"),
    FAVORITE("Favorite", Icons.Outlined.Favorite, "home/favorite"),
    CART("Cart", Icons.Outlined.ShoppingCart, "home/cart"),
    PROFILE("Profile", Icons.Outlined.Person, "home/profile"),
}

@Composable
fun CustomBottomNav(
    tabs: Array<BottomNavSection>,
    currentRoute: String = "home/home",
    navigateToRoute: (String) -> Unit
) {
    val routes = remember { tabs.map { it.route } }
    val currentSection = tabs.first { it.route == currentRoute }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
            .height(80.dp)
            .shadow(8.dp)
            .background(color = Color.White),
    ) {
        val springSpec = SpringSpec<Float>(
            // Determined experimentally
            stiffness = 800f,
            dampingRatio = 0.8f,
        )
        BottomNavLayout(
            selectedIndex = currentSection.ordinal,
            itemCount = routes.size,
            animationSpec = springSpec,
            indicator = { BottomNavIndicator() },
            modifier = Modifier.navigationBarsPadding()
        ) {
            tabs.forEach { section ->
                val selected = section == currentSection
                val tint by animateColorAsState(
                    if (selected) {
                        MaterialTheme.colors.primary
                    } else {
                        MaterialTheme.colors.onPrimary
                    }
                )

                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = section.icon,
                            tint = tint,
                            contentDescription = section.title
                        )
                    },
                    text = {
                        Text(
                            text = section.title,
                            color = tint,
                            style = MaterialTheme.typography.button,
                            maxLines = 1
                        )
                    },
                    selected = selected,
                    onSelected = {
                        navigateToRoute(section.route)
                    },
                    animSpec = springSpec,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .clip(RoundedCornerShape(percent = 50))
                )
            }
        }
    }
}

@Composable
fun BottomNavLayout(
    selectedIndex: Int,
    itemCount: Int,
    animationSpec: AnimationSpec<Float>,
    indicator: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val selectionFraction = remember(itemCount) {
        List(itemCount) {
            Animatable(if (it == selectedIndex) 1f else 0f)
        }
    }
    selectionFraction.forEachIndexed { index, animatable ->
        val target = if (index == selectedIndex) 1f else 0f
        LaunchedEffect(target, animationSpec) {
            animatable.animateTo(target, animationSpec)
        }
    }
    val indicatorIndex = remember {
        Animatable(0f)
    }
    val targetIndicatorIndex = selectedIndex.toFloat()
    LaunchedEffect(targetIndicatorIndex) {
        indicatorIndex.animateTo(targetIndicatorIndex, animationSpec)
    }

    Layout(
        modifier = modifier.height(56.dp),
        content = {
            content()
            Box(modifier = Modifier.layoutId("indicator"), content = indicator)
        }
    ) { measures, constraints ->
        check(itemCount == (measures.size - 1))

        val unselectedWidth = constraints.maxWidth / (itemCount + 1)
        val selectedWidth = 2 * unselectedWidth
        val indicatorMeasurable = measures.first { it.layoutId == "indicator" }
        val itemPlaceAble = measures
            .filterNot { it == indicatorMeasurable }
            .mapIndexed { index, measurable ->
                val width = lerp(
                    start = unselectedWidth,
                    stop = selectedWidth,
                    fraction = selectionFraction[index].value
                )
                measurable.measure(
                    constraints.copy(
                        minWidth = width,
                        maxWidth = width
                    )
                )
            }
        val indicatorPlaceable = indicatorMeasurable.measure(
            constraints.copy(
                minWidth = selectedWidth,
                maxWidth = selectedWidth
            )
        )
        layout(
            width = constraints.maxWidth,
            height = itemPlaceAble.maxByOrNull { it.height }?.height ?: 0
        ) {
            val indicatorLeft = indicatorIndex.value * unselectedWidth
            indicatorPlaceable.placeRelative(x = indicatorLeft.toInt(), y = 0)
            var x = 0
            itemPlaceAble.forEach { placeable ->
                placeable.placeRelative(x = x, y = 0)
                x += placeable.width
            }
        }
    }
}

@Composable
fun BottomNavigationItem(
    icon: @Composable BoxScope.() -> Unit,
    text: @Composable BoxScope.() -> Unit,
    selected: Boolean,
    onSelected: () -> Unit,
    animSpec: AnimationSpec<Float>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .selectable(selected = selected, onClick = onSelected),
        contentAlignment = Alignment.Center,
    ) {
        val animationProgress by animateFloatAsState(if (selected) 1f else 0f, animSpec)
        BottomNavigationItemLayout(
            icon = icon,
            text = text,
            animationProgress = animationProgress
        )
    }
}

@Composable
private fun BottomNavIndicator() {
    Spacer(
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 20.dp, end = 20.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(100.dp))
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colors.secondary)
    )
}

@Composable
fun BottomNavigationItemLayout(
    icon: @Composable BoxScope.() -> Unit,
    text: @Composable BoxScope.() -> Unit,
    @FloatRange(from = 0.0, to = 1.0) animationProgress: Float
) {
    Layout(
        content = {
            Box(
                modifier = Modifier
                    .layoutId("icon")
                    .padding(horizontal = 2.dp),
                content = icon
            )
            val scale = lerp(0.6f, 1f, animationProgress)
            Box(
                modifier = Modifier
                    .layoutId("text")
                    .padding(horizontal = 2.dp)
                    .graphicsLayer {
                        alpha = animationProgress
                        scaleX = scale
                        scaleY = scale
                        transformOrigin = TransformOrigin(0f, 0.5f)
                    },
                content = text
            )
        }
    ) { measurables, constraints ->
        val iconPlaceable = measurables.first { it.layoutId == "icon" }.measure(constraints)
        val textPlaceable = measurables.first { it.layoutId == "text" }.measure(constraints)
        placeTextAndIcon(
            textPlaceable,
            iconPlaceable,
            constraints.maxWidth,
            constraints.maxHeight,
            animationProgress
        )
    }
}

@Preview
@Composable
private fun BottomNavPreview() {
    CustomBottomNav(
        tabs = BottomNavSection.values(),
        currentRoute = BottomNavSection.HOME.route,
        navigateToRoute = { }
    )
}
