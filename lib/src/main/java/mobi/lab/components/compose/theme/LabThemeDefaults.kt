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
import mobi.lab.components.compose.theme.tokens.PaletteTokens
import mobi.lab.components.compose.util.withAlpha
import mobi.lab.components.compose.util.withFontFamily

public object LabThemeDefaults {

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

    @Composable
    public fun lightColors(): LabColors {
        return LabColors(
            primary = PaletteTokens.primary50,
            primaryFocused = PaletteTokens.primary40,
            primaryPressed = PaletteTokens.primary40,
            primaryDisabled = neutral10Medium,
            onPrimary = PaletteTokens.neutral100,
            onPrimaryDisabled = neutral10Disabled,
            primarySurface = PaletteTokens.primary95,
            primarySurfaceFocused = PaletteTokens.primary95.withAlpha(EMPHASIS_VERY_HIGH),
            primarySurfacePressed = PaletteTokens.primary95.withAlpha(EMPHASIS_VERY_HIGH),
            primarySurfaceDisabled = neutral10Small,
            onPrimarySurface = PaletteTokens.primary10,
            onPrimarySurfaceDisabled = neutral10Disabled,
            secondary = PaletteTokens.secondary50,
            secondaryFocused = PaletteTokens.secondary40,
            secondaryPressed = PaletteTokens.secondary40,
            secondaryDisabled = neutral10Medium,
            onSecondary = PaletteTokens.neutral100,
            onSecondaryDisabled = neutral10Disabled,
            secondarySurface = PaletteTokens.secondary95,
            secondarySurfacePressed = PaletteTokens.secondary95.withAlpha(EMPHASIS_VERY_HIGH),
            secondarySurfaceFocused = PaletteTokens.secondary95.withAlpha(EMPHASIS_VERY_HIGH),
            secondarySurfaceDisabled = neutral10Small,
            onSecondarySurface = PaletteTokens.secondary10,
            onSecondarySurfaceDisabled = neutral10Disabled,
            error = PaletteTokens.error40,
            errorFocused = PaletteTokens.error30,
            errorPressed = PaletteTokens.error30,
            errorDisabled = neutral10Medium,
            onError = PaletteTokens.neutral100,
            onErrorDisabled = neutral10Disabled,
            errorSurface = PaletteTokens.error90,
            errorSurfacePressed = PaletteTokens.error90.withAlpha(EMPHASIS_VERY_HIGH),
            errorSurfaceFocused = PaletteTokens.error90.withAlpha(EMPHASIS_VERY_HIGH),
            errorSurfaceDisabled = neutral10Small,
            onErrorSurface = PaletteTokens.error10,
            onErrorSurfaceDisabled = neutral10Disabled,
            success = PaletteTokens.success40,
            successFocused = PaletteTokens.success30,
            successPressed = PaletteTokens.success30,
            successDisabled = neutral10Medium,
            onSuccess = PaletteTokens.neutral100,
            onSuccessDisabled = neutral10Disabled,
            successSurface = PaletteTokens.success90,
            successSurfaceFocused = PaletteTokens.success90.withAlpha(EMPHASIS_VERY_HIGH),
            successSurfacePressed = PaletteTokens.success90.withAlpha(EMPHASIS_VERY_HIGH),
            successSurfaceDisabled = neutral10Small,
            onSuccessSurface = PaletteTokens.success10,
            onSuccessSurfaceDisabled = neutral10Disabled,
            caution = PaletteTokens.caution40,
            cautionFocused = PaletteTokens.caution30,
            cautionPressed = PaletteTokens.caution30,
            cautionDisabled = neutral10Medium,
            onCaution = PaletteTokens.neutral100,
            onCautionDisabled = neutral10Disabled,
            cautionSurface = PaletteTokens.caution90,
            cautionSurfaceFocused = PaletteTokens.caution90.withAlpha(EMPHASIS_VERY_HIGH),
            cautionSurfacePressed = PaletteTokens.caution90.withAlpha(EMPHASIS_VERY_HIGH),
            cautionSurfaceDisabled = neutral10Small,
            onCautionSurface = PaletteTokens.caution10,
            onCautionSurfaceDisabled = neutral10Disabled,
            background = PaletteTokens.neutral100,
            onBackground = PaletteTokens.neutral10,
            onBackgroundDisabled = neutral10Disabled,
            surface = PaletteTokens.neutral99,
            surfaceFocused = neutral10Medium,
            surfacePressed = neutral10Medium,
            surfaceDisabled = PaletteTokens.neutral99,
            onSurface = PaletteTokens.neutral10,
            onSurfaceDisabled = neutral10Disabled,
            outline = PaletteTokens.neutral50,
            outlineDisabled = PaletteTokens.neutral50.withAlpha(EMPHASIS_DISABLED),
            divider = PaletteTokens.neutral80,
            dividerDisabled = PaletteTokens.neutral90,
            surfaceVariant = PaletteTokens.neutralVariant90,
            surfaceVariantFocused = PaletteTokens.neutralVariant30.withAlpha(EMPHASIS_MEDIUM),
            surfaceVariantPressed = PaletteTokens.neutralVariant30.withAlpha(EMPHASIS_MEDIUM),
            surfaceVariantDisabled = neutral10Small,
            onSurfaceVariant = PaletteTokens.neutralVariant30,
            onSurfaceVariantDisabled = neutral10Disabled,
            outlineVariant = PaletteTokens.neutralVariant50,
            outlineVariantDisabled = PaletteTokens.neutralVariant50.withAlpha(EMPHASIS_DISABLED),
            dividerVariant = PaletteTokens.neutralVariant80,
            dividerVariantDisabled = PaletteTokens.neutralVariant90
        )
    }

    @Composable
    public fun darkColors(): LabColors {
        return LabColors(
            primary = PaletteTokens.primary80,
            primaryFocused = PaletteTokens.primary90,
            primaryPressed = PaletteTokens.primary90,
            primaryDisabled = neutral90Medium,
            onPrimary = PaletteTokens.primary20,
            onPrimaryDisabled = neutral90Disabled,
            primarySurface = PaletteTokens.primary30,
            primarySurfaceFocused = PaletteTokens.primary30.withAlpha(EMPHASIS_VERY_HIGH),
            primarySurfacePressed = PaletteTokens.primary30.withAlpha(EMPHASIS_VERY_HIGH),
            primarySurfaceDisabled = PaletteTokens.primary30.withAlpha(EMPHASIS_SMALL),
            onPrimarySurface = PaletteTokens.primary90,
            onPrimarySurfaceDisabled = neutral10Disabled,
            secondary = PaletteTokens.secondary80,
            secondaryFocused = PaletteTokens.secondary90,
            secondaryPressed = PaletteTokens.secondary90,
            secondaryDisabled = neutral90Medium,
            onSecondary = PaletteTokens.secondary20,
            onSecondaryDisabled = neutral90Disabled,
            secondarySurface = PaletteTokens.secondary30,
            secondarySurfacePressed = PaletteTokens.secondary30.withAlpha(EMPHASIS_VERY_HIGH),
            secondarySurfaceFocused = PaletteTokens.secondary30.withAlpha(EMPHASIS_VERY_HIGH),
            secondarySurfaceDisabled = neutral90Small,
            onSecondarySurface = PaletteTokens.secondary90,
            onSecondarySurfaceDisabled = neutral90Disabled,
            error = PaletteTokens.error80,
            errorFocused = PaletteTokens.error90,
            errorPressed = PaletteTokens.error90,
            errorDisabled = neutral90Medium,
            onError = PaletteTokens.error20,
            onErrorDisabled = neutral90Disabled,
            errorSurface = PaletteTokens.error30,
            errorSurfacePressed = PaletteTokens.error30.withAlpha(EMPHASIS_VERY_HIGH),
            errorSurfaceFocused = PaletteTokens.error30.withAlpha(EMPHASIS_VERY_HIGH),
            errorSurfaceDisabled = neutral90Small,
            onErrorSurface = PaletteTokens.error90,
            onErrorSurfaceDisabled = neutral90Disabled,
            success = PaletteTokens.success80,
            successFocused = PaletteTokens.success90,
            successPressed = PaletteTokens.success90,
            successDisabled = neutral90Medium,
            onSuccess = PaletteTokens.success20,
            onSuccessDisabled = neutral90Disabled,
            successSurface = PaletteTokens.success30,
            successSurfaceFocused = PaletteTokens.success30.withAlpha(EMPHASIS_VERY_HIGH),
            successSurfacePressed = PaletteTokens.success30.withAlpha(EMPHASIS_VERY_HIGH),
            successSurfaceDisabled = neutral90Small,
            onSuccessSurface = PaletteTokens.success90,
            onSuccessSurfaceDisabled = neutral90Disabled,
            caution = PaletteTokens.caution80,
            cautionFocused = PaletteTokens.caution90,
            cautionPressed = PaletteTokens.caution90,
            cautionDisabled = neutral90Medium,
            onCaution = PaletteTokens.caution20,
            onCautionDisabled = neutral90Disabled,
            cautionSurface = PaletteTokens.caution30,
            cautionSurfaceFocused = PaletteTokens.caution30.withAlpha(EMPHASIS_VERY_HIGH),
            cautionSurfacePressed = PaletteTokens.caution30.withAlpha(EMPHASIS_VERY_HIGH),
            cautionSurfaceDisabled = neutral90Small,
            onCautionSurface = PaletteTokens.caution90,
            onCautionSurfaceDisabled = neutral90Disabled,
            background = PaletteTokens.neutral0,
            onBackground = PaletteTokens.neutral95,
            onBackgroundDisabled = PaletteTokens.neutral95.withAlpha(EMPHASIS_DISABLED),
            surface = PaletteTokens.neutral10,
            surfaceFocused = PaletteTokens.neutral95.withAlpha(EMPHASIS_MEDIUM),
            surfacePressed = PaletteTokens.neutral95.withAlpha(EMPHASIS_MEDIUM),
            surfaceDisabled = PaletteTokens.neutral10,
            onSurface = PaletteTokens.neutral95,
            onSurfaceDisabled = PaletteTokens.neutral95.withAlpha(EMPHASIS_DISABLED),
            outline = PaletteTokens.neutralVariant60,
            outlineDisabled = PaletteTokens.neutralVariant60.withAlpha(EMPHASIS_DISABLED),
            divider = PaletteTokens.neutral30,
            dividerDisabled = PaletteTokens.neutral20,
            surfaceVariant = PaletteTokens.neutralVariant30,
            surfaceVariantFocused = PaletteTokens.neutralVariant80.withAlpha(EMPHASIS_MEDIUM),
            surfaceVariantPressed = PaletteTokens.neutralVariant80.withAlpha(EMPHASIS_MEDIUM),
            surfaceVariantDisabled = PaletteTokens.neutralVariant30,
            onSurfaceVariant = PaletteTokens.neutralVariant80,
            onSurfaceVariantDisabled = PaletteTokens.neutral95.withAlpha(EMPHASIS_DISABLED),
            outlineVariant = PaletteTokens.neutralVariant60,
            outlineVariantDisabled = PaletteTokens.neutralVariant60.withAlpha(EMPHASIS_DISABLED),
            dividerVariant = PaletteTokens.neutralVariant30,
            dividerVariantDisabled = PaletteTokens.neutralVariant20
        )
    }

    private val neutral10Medium: Color
        @Composable
        get() = PaletteTokens.neutral10.withAlpha(EMPHASIS_MEDIUM)

    private val neutral10Small: Color
        @Composable
        get() = PaletteTokens.neutral10.withAlpha(EMPHASIS_SMALL)

    private val neutral10Disabled: Color
        @Composable
        get() = PaletteTokens.neutral10.withAlpha(EMPHASIS_DISABLED)

    private val neutral90Medium: Color
        @Composable
        get() = PaletteTokens.neutral90.withAlpha(EMPHASIS_MEDIUM)

    private val neutral90Small: Color
        @Composable
        get() = PaletteTokens.neutral90.withAlpha(EMPHASIS_SMALL)

    private val neutral90Disabled: Color
        @Composable
        get() = PaletteTokens.neutral90.withAlpha(EMPHASIS_DISABLED)

    private const val EMPHASIS_VERY_HIGH = 0.64f
    private const val EMPHASIS_MEDIUM = 0.12f
    private const val EMPHASIS_SMALL = 0.08f
    private const val EMPHASIS_DISABLED = 0.4f

    private fun defaultFontFamily(): FontFamily {
        return FontFamily(Font(DeviceFontFamilyName("sans-serif")))
    }
}
