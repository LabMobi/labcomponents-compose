package mobi.lab.components.compose.util

import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import mobi.lab.components.compose.theme.LabTheme

@Composable
public fun Color.withAlpha(alpha: Float): Color {
    return copy(alpha = alpha)
}

public fun TextStyle.withFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}

@Composable
public fun Modifier.limitMaxContentWidth(maxContentWidth: Dp = LabTheme.dimensions.maxContentWidth): Modifier = composed {
    this.widthIn(max = maxContentWidth)
}
