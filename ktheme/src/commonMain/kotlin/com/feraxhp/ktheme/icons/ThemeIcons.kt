package com.feraxhp.ktheme.icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.feraxhp.ktheme.icons.theme.Cpu
import com.feraxhp.ktheme.icons.theme.Github
import com.feraxhp.ktheme.icons.theme.Moon
import com.feraxhp.ktheme.icons.theme.Palette
import com.feraxhp.ktheme.icons.theme.Sun
import kotlin.collections.List as ____KtList

public object ThemeIcons

private var all: ____KtList<ImageVector>? = null

public val ThemeIcons.getAll: ____KtList<ImageVector>
  get() {
    if (all != null) {
      return all!!
    }
    all= listOf(Cpu, Github, Moon, Sun, Palette)
    return all!!
  }
