package com.feraxhp.sample.screens

import ThemeSelector
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.currentOrThrow
import com.feraxhp.ktheme.LocalThemeSettings
import com.feraxhp.sample.screens.components.TopBar


class SettingsScreen : Screen {
    override val key: ScreenKey = "SettingsScreen"

    @Composable
    override fun Content() {
        val dts = LocalThemeSettings.currentOrThrow

        Scaffold(
            topBar = {
            },
            content = { localValues ->

                Column {

                    TopBar(Modifier.padding(top = localValues.calculateTopPadding()))

                    ThemeSelector(
                        Modifier
                            .padding(top = 16.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    Column(
                        modifier = Modifier.padding(16.dp).fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {


                        Text(
                            text = "Hello!",
                            style = MaterialTheme.typography.titleLarge,

                            fontSize = 56.sp,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            text = "This web is under construction.\n Please check it back later.",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        )
    }
}