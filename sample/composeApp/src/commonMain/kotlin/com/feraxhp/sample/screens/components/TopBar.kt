package com.feraxhp.sample.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.currentOrThrow
import com.feraxhp.ktheme.LocalThemeIsDark
import com.feraxhp.ktheme.LocalThemeSettings
import com.feraxhp.sample.Github
import ktheme.sample.composeapp.generated.resources.Res
import ktheme.sample.composeapp.generated.resources.ic_dark_mode
import ktheme.sample.composeapp.generated.resources.ic_light_mode
import ktheme.sample.composeapp.generated.resources.open_github
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource


@Composable
fun TopBar(modifier: Modifier = Modifier) = Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.End,
    modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = 8.dp,
            vertical = 4.dp
        )
        .then(modifier)
) {
    var isDark by LocalThemeIsDark.current
    val uriHandler = LocalUriHandler.current
    val dts = LocalThemeSettings.currentOrThrow

    TextButton(
        modifier = Modifier.wrapContentWidth(),
        onClick = { uriHandler.openUri("https://github.com/feraxhp/ktheme") },
    ) {
        Icon(
            modifier = Modifier.size(28.dp)
                .padding(end = 8.dp),
            imageVector = Github,
            contentDescription = null
        )
        Text(stringResource(Res.string.open_github))
    }

    IconButton(
        modifier = Modifier,
        onClick = {
            dts.setTheme(null) {
                isDark = !isDark
            }
        },
        content = {
            Icon(
                vectorResource(
                    if (isDark) Res.drawable.ic_light_mode
                    else Res.drawable.ic_dark_mode
                ),
                contentDescription = null
            )
        }
    )
}
