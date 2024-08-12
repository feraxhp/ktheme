package com.feraxhp.sample

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.currentOrThrow
import com.feraxhp.ktheme.DynamicTheme
import com.feraxhp.ktheme.LocalThemeIsDark
import com.feraxhp.ktheme.LocalThemeSettings
import ktheme.sample.composeapp.generated.resources.Res
import ktheme.sample.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun App() = DynamicTheme {

    val dts = LocalThemeSettings.currentOrThrow

    val isDynamic = dts.useDynamicColor
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
                    .padding(top = paddingValues.calculateTopPadding())
            ,
            contentAlignment = Alignment.Center,
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .align(Alignment.TopEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                var isDark by LocalThemeIsDark.current
                val uriHandler = LocalUriHandler.current
                TextButton(
                    modifier = Modifier.wrapContentWidth(),
                    onClick = { uriHandler.openUri("https://github.com/feraxhp") },
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
                    onClick = { isDark = !isDark },
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

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally

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
}
