package mobi.lab.components.compose.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.theme.LabThemeDefaults

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    LabTheme(
        typography = LabThemeDefaults.typography(fontFamily = defaultFontFamily()),
        content = content,
    )
}

@Composable
private fun defaultFontFamily(): FontFamily {
    return FontFamily(
        Font(R.font.font_regular, FontWeight.W400),
        Font(R.font.font_medium, FontWeight.W500),
        Font(R.font.font_semibold, FontWeight.W600),
    )
}
