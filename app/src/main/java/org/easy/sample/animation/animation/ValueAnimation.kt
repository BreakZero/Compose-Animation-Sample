package org.easy.sample.animation.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ValueAnimationRoute() {
    var isRound by remember {
        mutableStateOf(false)
    }
    var duration by remember {
        mutableIntStateOf(0)
    }
    val boardRadius by animateIntAsState(
        targetValue = if (isRound) 100 else 0, label = "round",
        animationSpec = tween(durationMillis = duration)
    )
    val color by animateColorAsState(
        targetValue = if (isRound) Color.Green else Color.Red,
        label = "color",
        animationSpec = tween(durationMillis = duration)
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {

        Slider(
            modifier = Modifier.fillMaxWidth(),
            valueRange = 0f..1000f,
            value = duration.toFloat(), onValueChange = {
                duration = it.toInt()
            })
        Text(text = "Duration Millis = $duration")
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                isRound = !isRound
            }) {
            Text(text = "Toggle")
        }
        Text(text = "For Radius")
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(boardRadius))
                .background(Color.Red)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "For Color")
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(color)
        )
    }
}