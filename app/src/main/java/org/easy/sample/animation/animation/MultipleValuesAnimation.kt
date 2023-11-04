package org.easy.sample.animation.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.updateTransition
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MultipleValuesAnimationRoute() {
    var toggle by remember {
        mutableStateOf(false)
    }
    val transition = updateTransition(targetState = toggle, label = "multiple")
    val boardRadius by transition.animateInt(label = "radius") {
        if (it) 100 else 0
    }
    val color by transition.animateColor(label = "color") {
        if (it) Color.Red else Color.Green
    }
    val size by transition.animateDp(label = "height") {
        if (it) 200.dp else 300.dp
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                toggle = !toggle
            }) {
            Text(text = "Toggle")
        }
        Box(
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(boardRadius))
                .background(color)
        )
    }
}