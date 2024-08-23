# Ktheme

*ktheme* is a Compose Multiplatform library written to provide _material design 3 (MD3)_ based theme, with essential components to configure it.

## Functionality
- DynamicTheme support for Android (with Amoled).
- Material Design Color Scheme support for other platforms (You must provide a color seed).
- The theme settings persist over sessions (clientSide).
- Pre-assembled components for configuration.

## Configuration

1. Paste this code to your _.toml_ file
```toml
[versions]

ktheme = "0.0.2"

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

## Provider?

ktheme provides access to all the settings of the Dynamic Theme by accessing this 2 Composition Providers:
- LocalThemeIsDark: Boolean 
  Use it to know if the current theme is light or dark, you can change the theme here without storing it.
- LocalThemeSettings: DynamicThemeSettings
  This provider give you access to the instance of the class in charge of store and modify the theme settings
  - All changes make here are stored in the local memory.
  - To change any setting, you must call the setter for that setting.
  - You can also track the changes to this settings calling the colectAsState() function any one
  - Settings:
    - seedColor: Color 
      - Controls the current base color for the generated theme
      - Default is Color(0X4C662B)
    - theme: Boolean?
      - Controls which theme is active or if it is following the system theme.
      - Default is null
      - Values: 
        - null -> Follow System Appearance
        - true -> Dark
        - false -> light
    - useDynamicColor: Boolean
      - Controls if the android app must use the system dynamic color, or use the seed color
    - useAmoled: Boolean
      - Controls if the theme must be amoled or not
      - Default is false
    - style: com.feraxhp.ktheme.PaletteStyles
      - Controls the style of the generated theme
      - Default: TonalSpot
    - contrastLevel: Double
      - Controls the contrast of the generated theme
      - Default: Compose Contrast Default
    - extendedFidelity: Boolean
      - See [Material Design Docs](https://m3.material.io) for more information
    - hasAnimation: Boolean
      - Controls the transition between theme changes
      - This is triggered for any theme change in execution time.

To see a sample of the implementation you can access :sample:composeApp commonMain

## Components 

Since Version 0.0.3

- ThemeSelector: Is a segmented button with the options (system, dark, light)
- SegmentedButton: a implementation of [SegmentedButton](https://m3.material.io/components/segmented-buttons/overview)


---

This library is based on [MaterialKolor](https://github.com/jordond/MaterialKolor)
