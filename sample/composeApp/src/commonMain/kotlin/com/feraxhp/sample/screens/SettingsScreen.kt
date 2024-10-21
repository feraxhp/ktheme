package com.feraxhp.sample.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.currentOrThrow
import com.feraxhp.ktheme.LocalThemeSettings
import com.feraxhp.ktheme.components.Density
import com.feraxhp.ktheme.components.theme.SeedColorPicker
import com.feraxhp.ktheme.components.theme.ThemeSelector
import com.feraxhp.sample.screens.components.TopBar
import com.mikepenz.markdown.m3.Markdown


class SettingsScreen : Screen {
    override val key: ScreenKey = "SettingsScreen"

    @Composable
    override fun Content() {
        val dts = LocalThemeSettings.currentOrThrow

        Scaffold(
            topBar = {},
            content = { localValues ->

                Column {

                    TopBar(Modifier.padding(top = localValues.calculateTopPadding()))

                    Row(
                        Modifier
                            .padding(top = 24.dp)
                            .widthIn(Dp.Unspecified, 450.dp)
                            .align(Alignment.CenterHorizontally)
                        ,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ThemeSelector(
                            Modifier
                                .weight(2f)
                                .padding(horizontal = 8.dp)
                            ,
                            Density.Small
                        )

                        SeedColorPicker()
                    }

                    LazyColumn (
                        modifier = Modifier.padding(16.dp).fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        val markdown = """
# Ktheme

*ktheme* is a Compose Multiplatform library written to provide _material design 3 (MD3)_ based theme, with essential components to configure it.

## Functionality
- DynamicTheme support for Android (with Amoled).
- Material Design Color Scheme support for other platforms (You must provide a color seed).
- The theme settings persist over sessions (clientSide).
- Pre-assembled components for configuration.

## Kotlin Multiplatform Support Maps

- Android ✅ 
- Desktop ✅ 
- iOSX64 ✅ 
- iOSArm64 ✅ 
- iosSimulatorArm64 ✅ 
- macosX64/macosArm64 ✅ 
- js/WasmJs ✅ 

## Configuration

1. Paste this code to your _.toml_ file
```toml
[versions]

ktheme = "0.0.3"

[libraries]

ktheme = { module = "com.feraxhp.ktheme:ktheme-compose", version.ref = "ktheme" }
```
2. Then paste this other code into your _build.gradle.kts_ in `kotlin > sourceSets > commonMain.dependencies`
```kotlin
implementation(libs.ktheme)
```
3. Sync Project with Gradle
4. Now you can add DynamicTheme { } anywhere in your project, here is an example on your _App.kt_
```kotlin
import com.feraxhp.ktheme.DynamicTheme

@Composable
internal fun App() = DynamicTheme { // base color default is: 0X4C662B, to change it call baseColor: Int 
  // Your KMP App content
}
```
5. Update settings
```kotlin
val dts = LocalThemeSettings.currentOrThrow // Provider

// Access Settings

val seedColor by dts.seedColor.collectAsState()
val secondary by dts.secondary.collectAsState()
val tertiary by dts.tertiary.collectAsState()
val error by dts.error.collectAsState()
val theme by dts.theme.collectAsState()
val useDynamicColor by dts.useDynamicColor.collectAsState()
val useAmoled by dts.useAmoled.collectAsState()
val style by dts.style.collectAsState()
val contrastLevel by dts.contrastLevel.collectAsState()
val extendedFidelity by dts.extendedFidelity.collectAsState()
val hasAnimation by dts.hasAnimation.collectAsState()

// LocalThemeSettings: Provides set-functions to change every theme Setting.
```


## Provider?

ktheme provides access to all the settings of the Dynamic Theme by accessing this 2 Composition Providers:
- **LocalThemeIsDark**: Boolean 
  Use it to know if the current theme is light or dark, you can change the theme here without storing it.
- **LocalThemeSettings**: DynamicThemeSettings
  This provider give you access to the instance of the class in charge of store and modify the theme settings
  - All changes make here are stored in the local memory.
  - To change any setting, you must call the setter for that setting.
  - You can also track the changes to this settings calling the colectAsState() function any one
  - **Settings**:
    - **seedColor || primaryColor**: Color 
      - Controls the current base color for the generated theme
      - Default is Color(0X4C662B)
    - **secondaryColor**: Color
      - Controls the current base color for the generated theme
      - Default null
    - **errorColor**: Color
      - Controls the current base color for the generated theme
      - Default null
    - **theme**: Boolean?
      - Controls which theme is active or if it is following the system theme.
      - Default is null
      - Values: 
        - null -> Follow System Appearance
        - true -> Dark
        - false -> light
    - **useDynamicColor**: Boolean
      - Controls if the android app must use the system dynamic color, or use the seed color
    - **useAmoled**: Boolean
      - Controls if the theme must be amoled or not
      - Default is false
    - **style**: com.feraxhp.ktheme.PaletteStyles
      - Controls the style of the generated theme
      - Default: TonalSpot
    - **contrastLevel**: Double
      - Controls the contrast of the generated theme
      - Default: Compose Contrast Default
    - **extendedFidelity**: Boolean
      - See [Material Design Docs](https://m3.material.io) for more information
    - **hasAnimation**: Boolean
      - Controls the transition between theme changes
      - This is triggered for any theme change in execution time.

To see a sample of the implementation you can access :sample:composeApp commonMain

## Components 

Since Version 0.0.3

- ThemeSelector: Is a segmented button with the options (system, dark, light)
- SegmentedButton: a implementation of [SegmentedButton](https://m3.material.io/components/segmented-buttons/overview)


---

This library is based on [MaterialKolor](https://github.com/jordond/MaterialKolor)

                        """.trimIndent()
                        item { Markdown(markdown) }
                    }
                }
            }
        )
    }
}
