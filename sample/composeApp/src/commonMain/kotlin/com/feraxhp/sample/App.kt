package com.feraxhp.sample

import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import com.feraxhp.ktheme.DynamicTheme
import com.feraxhp.sample.screens.SettingsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun App() = DynamicTheme {
    Navigator(
        screen = SettingsScreen()
    )
}

@Preview
@Composable
fun GreetingPreview() {
    App()
}