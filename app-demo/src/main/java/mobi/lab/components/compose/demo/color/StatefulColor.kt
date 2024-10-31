package mobi.lab.components.compose.demo.color

import androidx.compose.ui.graphics.Color

data class StatefulColor(
    val default: Color,
    val focused: Color = default,
    val pressed: Color = default,
    val disabled: Color = default
)
