package com.feraxhp.ktheme.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.selects.select
import org.jetbrains.compose.ui.tooling.preview.Preview

data class Segment(
    val text: String,
    val icon: ImageVector? = null,
    val enabled: Boolean = true,
    val onClick: () -> Unit = {}
)


@Composable
fun SegmentedButton(
    modifier: Modifier = Modifier,
    segments: List<Segment> = listOf(
        Segment("Selected"),
        Segment("enable"),
        Segment("Disable", enabled = false),
        Segment("enable")
    ),
    density: Density = Density.Default,
    showCheck: Boolean = true,
    selectedValue: Int = 0,
) {

//    assert(segments.size <= 5)
    Box(
        modifier = modifier,
        content = {

            val shape = RoundedCornerShape(50)
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .clip(shape)
                    .background(
                        color = Color.Transparent,
                    ),
                content = {
                    segments.onEachIndexed { index, segment ->
                        if (index > 1 && index <= (segments.size - 2)) {
                            Spacer(
                                modifier = Modifier
                                    .height(density.value.dp)
                                    .width(1.dp)
                                    .background(MaterialTheme.colorScheme.outline)
                            )
                        }
                        Segment(
                            modifier = Modifier.weight(1f),
                            text = segment.text,
                            icon = segment.icon,
                            enabled = segment.enabled,
                            showCheck = showCheck,
                            isFirst = if (index == 0 || (index + 1) >= segments.size) index == 0 else null,
                            isSelected = index == selectedValue,
                            density = density,
                            onClick = segment.onClick
                        )
                    }
                }
            )
        }
    )

}

@Composable
internal fun Segment(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector?,
    enabled: Boolean,
    isSelected: Boolean,
    showCheck: Boolean = true,
    density: Density = Density.Default,
    isFirst: Boolean? = null,
    onClick: () -> Unit = {}
) {
    val state = remember { MutableInteractionSource() }

    val hovered by state.collectIsHoveredAsState()

    val borderColor = when {
        !enabled -> MaterialTheme.colorScheme.onSurface.copy(alpha = .12f)
        else -> MaterialTheme.colorScheme.outline
    }

    val containerColor = when {
        isSelected -> MaterialTheme.colorScheme.secondaryContainer
        hovered -> MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        else -> Color.Transparent
    }

    val textColor = when {
        !enabled -> MaterialTheme.colorScheme.onSurface.copy(alpha = .38f)
        else -> MaterialTheme.colorScheme.onSurface
    }
    val iconColor = when {
        !enabled -> MaterialTheme.colorScheme.onSurface.copy(alpha = .38f)
        else -> MaterialTheme.colorScheme.onSurface
    }

    val space = remember {
        when (isFirst) {
            true -> Modifier.padding(start = 12.dp)
            false -> Modifier.padding(end = 12.dp)
            null -> Modifier
        }
    }

    val shape = remember {
        when (isFirst) {
            true -> RoundedCornerShape(
                topStartPercent = 50,
                bottomStartPercent = 50
            )

            false -> RoundedCornerShape(
                topEndPercent = 50,
                bottomEndPercent = 50
            )

            null -> RoundedCornerShape(0)
        }
    }


    val border = remember {
        when (isFirst) {
            null -> Modifier.drawBehind {
                drawLine(
                    color = borderColor,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 2.dp.toPx()
                )
                drawLine(
                    color = borderColor,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 2.dp.toPx()
                )
            }

            else -> Modifier.border(
                width = 1.dp,
                color = borderColor,
                shape = shape
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable(
                enabled = enabled,
                interactionSource = state,
                indication = null,
                onClick = onClick
            )
            .background(containerColor)
            .height(density.value.dp)
            .then(border)
            .padding(horizontal = 8.dp)
            .then(space)
            .then(modifier)
    ) {
        AnimatedVisibility(isSelected || icon != null) {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(18.dp)
                ,
                imageVector = if (isSelected && showCheck) Icons.Default.Done else icon ?: Icons.Default.Done,
                tint = iconColor,
                contentDescription = null

            )
        }
        if(text != "") {
            Text(
                color = textColor,
                text = text
            )
        }
    }
}

enum class Density(val value: Int){
    Default(40),
    Medium(36),
    Small(32),
    ExtraSmall(28)
}

@Preview
@Composable
fun prueba() {
    SegmentedButton()
}