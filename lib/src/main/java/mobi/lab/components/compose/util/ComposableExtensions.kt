package mobi.lab.components.compose.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

@Composable
public fun Color.withAlpha(alpha: Float): Color {
    return copy(alpha = alpha)
}

public fun TextStyle.withFontFamily(default: FontFamily): TextStyle {
    return if (fontFamily != null) this else copy(fontFamily = default)
}
