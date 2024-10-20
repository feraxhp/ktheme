package com.feraxhp.ktheme.components.colorPicker


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.feraxhp.ktheme.LocalThemeSettings
import com.feraxhp.ktheme.icons.ThemeIcons
import com.feraxhp.ktheme.icons.theme.Palette
import com.github.skydoves.colorpicker.compose.*


@Composable
fun ColorPicker(
    modifier: Modifier = Modifier,
    initialColor: Color = Color.Red,
    onColorChange: (Color) -> Unit
) {
    var openColorPicker by remember { mutableStateOf(false) }
    val controller = rememberColorPickerController()

    IconButton(
        modifier = modifier
            .sizeIn(minWidth = 24.dp, minHeight = 24.dp)
        ,
        onClick = {
            openColorPicker = true;
        },
        content = {
            Icon(
                imageVector = ThemeIcons.Palette,
                contentDescription = null,
                modifier = Modifier
                    .sizeIn(minWidth = 24.dp, minHeight = 24.dp)
            )
        }
    )

    ColorPickerPopUp(
        onDismissRequest = { openColorPicker = false },
        openDialog = openColorPicker,
        controller = controller,
        onColorChange = onColorChange,
        initialColor = initialColor
    )
}

@Composable
fun ColorPickerPopUp(
    modifier:  Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    initialColor: Color,
    onColorChange: (Color) -> Unit,
    openDialog: Boolean,
    controller: ColorPickerController
) {
    AnimatedVisibility(
        openDialog,
        enter = slideInVertically(),
        exit = slideOutVertically()
    ) {
        Dialog(
            onDismissRequest = onDismissRequest,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                val close = Modifier.fillMaxWidth().weight(1f).clickable(
                    interactionSource = null,
                    indication = null,
                    onClick = onDismissRequest
                ) //.background(Color.Magenta)
                Spacer(close)
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .heightIn(min = 200.dp, max = 400.dp)
                        .widthIn(min = 120.dp, max = 320.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        var initialColor by remember { mutableStateOf(initialColor) }

                        HsvColorPicker(
                            modifier = Modifier
                                .weight(1f)
                            ,
                            controller = controller,
                            initialColor = initialColor,
                            onColorChanged = { color: ColorEnvelope ->
                                onColorChange(color.color)
                            }
                        )
                        Spacer(Modifier.height(16.dp))
                        Row(
                            Modifier.height(80.dp)
                        ) {
                            EditColor(
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(MaterialTheme.shapes.small),
                                controller = controller,
                                onColorChange = {
                                    initialColor = it
                                }
                            )
                            Spacer(Modifier.width(8.dp))
                            Column {
                                AlphaSlider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(36.dp),
                                    controller = controller,
                                )
                                Spacer(Modifier.height(8.dp))
                                BrightnessSlider(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(36.dp),
                                    controller = controller,
                                )
                            }
                        }
                    }
                }
                Spacer(close)
            }
        }
    }
}
