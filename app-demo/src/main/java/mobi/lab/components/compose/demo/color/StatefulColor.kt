package mobi.lab.components.compose.demo.color

import androidx.compose.ui.graphics.Color

data class StatefulColor(
    val color: Color,
    val focused: Color = color,
    val pressed: Color = color,
    val disabled: Color = color
)
