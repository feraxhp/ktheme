package com.feraxhp.ktheme.components.colorPicker

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.github.skydoves.colorpicker.compose.AlphaTile
import com.github.skydoves.colorpicker.compose.ColorPickerController
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import com.materialkolor.ktx.toHex
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun EditColor(
    modifier:  Modifier = Modifier,
    onColorChange: (Color) -> Unit = {},
    controller: ColorPickerController
){
    var isError by remember { mutableStateOf(false) }
    var value by remember{ mutableStateOf(controller.selectedColor.value.toHex()) }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        AlphaTile(
            modifier = Modifier.fillMaxSize(),
            controller = controller
        )
        /*TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Red)
            ,
            value = value,
            onValueChange = {
                value = it
                val color = validateError(it)
                isError = color == null

                if (color != null) onColorChange(color)
            },
            placeholder = { Text("#00000000") },
            colors = get_colors(TextFieldDefaults.colors()),
            isError = isError,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                keyboardType = KeyboardType.Ascii,
            )
        )*/
    }
}

/*
@OptIn(ExperimentalStdlibApi::class)
fun validateError(color: String): Color? {
    return try{
        val colorInt = color.hexToInt(HexFormat.Default)
        Color(colorInt)
    } catch (e: IllegalArgumentException) { null }
}

@Composable
fun get_colors(default: TextFieldColors): TextFieldColors {
    return TextFieldColors(
        focusedTextColor = default.focusedTextColor,
        unfocusedTextColor = default.unfocusedTextColor,
        disabledTextColor = default.disabledTextColor,
        errorTextColor = default.errorTextColor,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        errorContainerColor = Color.Transparent,
        cursorColor = default.cursorColor,
        errorCursorColor = default.errorCursorColor,
        textSelectionColors = default.textSelectionColors,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        errorIndicatorColor = Color.Transparent,
        focusedLeadingIconColor = Color.Transparent,
        unfocusedLeadingIconColor = Color.Transparent,
        disabledLeadingIconColor = Color.Transparent,
        errorLeadingIconColor = Color.Transparent,
        focusedTrailingIconColor = Color.Transparent,
        unfocusedTrailingIconColor = Color.Transparent,
        disabledTrailingIconColor = Color.Transparent,
        errorTrailingIconColor = Color.Transparent,
        focusedLabelColor = default.focusedLabelColor,
        unfocusedLabelColor = default.unfocusedLabelColor,
        disabledLabelColor = default.disabledLabelColor,
        errorLabelColor = default.errorLabelColor,
        focusedPlaceholderColor = default.focusedPlaceholderColor,
        unfocusedPlaceholderColor = default.unfocusedPlaceholderColor,
        disabledPlaceholderColor = default.disabledPlaceholderColor,
        errorPlaceholderColor = default.errorPlaceholderColor,
        focusedSupportingTextColor = default.focusedSupportingTextColor,
        unfocusedSupportingTextColor = default.unfocusedSupportingTextColor,
        disabledSupportingTextColor = default.disabledSupportingTextColor,
        errorSupportingTextColor = default.errorSupportingTextColor,
        focusedPrefixColor = default.focusedPrefixColor,
        unfocusedPrefixColor = default.unfocusedPrefixColor,
        disabledPrefixColor = default.disabledPrefixColor,
        errorPrefixColor = default.errorPrefixColor,
        focusedSuffixColor = default.focusedSuffixColor,
        unfocusedSuffixColor = default.unfocusedSuffixColor,
        disabledSuffixColor = default.disabledSuffixColor,
        errorSuffixColor = default.errorSuffixColor
    )
}*/
