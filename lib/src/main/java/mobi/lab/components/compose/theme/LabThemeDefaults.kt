package mobi.lab.components.compose.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.DeviceFontFamilyName
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import mobi.lab.components.compose.util.withFontFamily

public object LabThemeDefaults {

    @Composable
    public fun colors(): LabColors {
        TODO()
    }

    @Composable
    public fun constants(): LabConstants {
        return LabConstants(
            disabledAlpha = 0.4f,
            maxContentWidth = 500.dp,
        )
    }

    @Composable
    public fun shapes(cornerSize: Dp = 4.dp): LabShapes {
        return LabShapes(
            button = RoundedCornerShape(cornerSize),
            textField = RoundedCornerShape(cornerSize)
        )
    }

    /**
     * Constructor to create a [LabTypography]. For information on the types of style defined in
     *
     * @param fontFamily the default [FontFamily] to be used for [TextStyle]s provided in
     * this constructor. This default will be used if the [FontFamily] on the [TextStyle] is `null`.
     */
    @Composable
    public fun typography(
        fontFamily: FontFamily = defaultFontFamily(),
        displayLarge: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 56.sp,
            lineHeight = 64.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.em,
        ),
        displayMedium: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 45.sp,
            lineHeight = 52.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.em,
        ),
        displaySmall: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 36.sp,
            lineHeight = 44.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.em,
        ),
        headlineLarge: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.em,
        ),
        headlineMedium: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 28.sp,
            lineHeight = 36.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.em,
        ),
        headlineSmall: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.em,
        ),
        titleLarge: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.em,
        ),
        titleMedium: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.0094.em,
        ),
        titleSmall: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.W700,
            letterSpacing = 0.0071.em,
        ),
        bodyLarge: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.W500,
            letterSpacing = 0.0156.em,
        ),
        bodyLargeEmphasis: TextStyle = bodyLarge.copy(fontWeight = FontWeight.W700),
        bodyMedium: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.W500,
            letterSpacing = 0.0179.em,
        ),
        bodyMediumEmphasis: TextStyle = bodyMedium.copy(fontWeight = FontWeight.W700),
        bodySmall: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.W500,
            letterSpacing = 0.0333.em,
        ),
        bodySmallEmphasis: TextStyle = bodySmall.copy(fontWeight = FontWeight.W700),
        labelLarge: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.W500,
            letterSpacing = 0.0071.em,
        ),
        labelMedium: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.W500,
            letterSpacing = 0.0208.em,
        ),
        labelSmall: TextStyle = TextStyle(
            color = Color.Unspecified,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.W500,
            letterSpacing = 0.0455.em,
        ),
    ): LabTypography {
        return LabTypography(
            displayLarge = displayLarge.withFontFamily(fontFamily),
            displayMedium = displayMedium.withFontFamily(fontFamily),
            displaySmall = displaySmall.withFontFamily(fontFamily),
            headlineLarge = headlineLarge.withFontFamily(fontFamily),
            headlineMedium = headlineMedium.withFontFamily(fontFamily),
            headlineSmall = headlineSmall.withFontFamily(fontFamily),
            titleLarge = titleLarge.withFontFamily(fontFamily),
            titleMedium = titleMedium.withFontFamily(fontFamily),
            titleSmall = titleSmall.withFontFamily(fontFamily),
            bodyLarge = bodyLarge.withFontFamily(fontFamily),
            bodyLargeEmphasis = bodyLargeEmphasis.withFontFamily(fontFamily),
            bodyMedium = bodyMedium.withFontFamily(fontFamily),
            bodyMediumEmphasis = bodyMediumEmphasis.withFontFamily(fontFamily),
            bodySmall = bodySmall.withFontFamily(fontFamily),
            bodySmallEmphasis = bodySmallEmphasis.withFontFamily(fontFamily),
            labelLarge = labelLarge.withFontFamily(fontFamily),
            labelMedium = labelMedium.withFontFamily(fontFamily),
            labelSmall = labelSmall.withFontFamily(fontFamily),
        )
    }

    private fun defaultFontFamily(): FontFamily {
        return FontFamily(Font(DeviceFontFamilyName("sans-serif")))
    }
}
