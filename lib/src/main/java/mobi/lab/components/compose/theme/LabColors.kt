package mobi.lab.components.compose.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * App Theme custom Color Palette.
 */
@Immutable
public data class LabColors(
    // Primary
    public val primary: Color,
    public val primaryFocused: Color,
    public val primaryPressed: Color,
    public val primaryDisabled: Color,

    public val onPrimary: Color,
    public val onPrimaryDisabled: Color,

    public val primarySurface: Color,
    public val primarySurfaceFocused: Color,
    public val primarySurfacePressed: Color,
    public val primarySurfaceDisabled: Color,

    public val onPrimarySurface: Color,
    public val onPrimarySurfaceDisabled: Color,

    // Secondary
    public val secondary: Color,
    public val secondaryFocused: Color,
    public val secondaryPressed: Color,
    public val secondaryDisabled: Color,

    public val onSecondary: Color,
    public val onSecondaryDisabled: Color,

    public val secondarySurface: Color,
    public val secondarySurfacePressed: Color,
    public val secondarySurfaceFocused: Color,
    public val secondarySurfaceDisabled: Color,

    public val onSecondarySurface: Color,
    public val onSecondarySurfaceDisabled: Color,

    // Error
    public val error: Color,
    public val errorFocused: Color,
    public val errorPressed: Color,
    public val errorDisabled: Color,

    public val onError: Color,
    public val onErrorDisabled: Color,

    public val errorSurface: Color,
    public val errorSurfacePressed: Color,
    public val errorSurfaceFocused: Color,
    public val errorSurfaceDisabled: Color,

    public val onErrorSurface: Color,
    public val onErrorSurfaceDisabled: Color,

    // Success
    public val success: Color,
    public val successFocused: Color,
    public val successPressed: Color,
    public val successDisabled: Color,

    public val onSuccess: Color,
    public val onSuccessDisabled: Color,

    public val successSurface: Color,
    public val successSurfaceFocused: Color,
    public val successSurfacePressed: Color,
    public val successSurfaceDisabled: Color,

    public val onSuccessSurface: Color,
    public val onSuccessSurfaceDisabled: Color,

    // Caution
    public val caution: Color,
    public val cautionFocused: Color,
    public val cautionPressed: Color,
    public val cautionDisabled: Color,

    public val onCaution: Color,
    public val onCautionDisabled: Color,

    public val cautionSurface: Color,
    public val cautionSurfaceFocused: Color,
    public val cautionSurfacePressed: Color,
    public val cautionSurfaceDisabled: Color,

    public val onCautionSurface: Color,
    public val onCautionSurfaceDisabled: Color,

    // Neutral
    public val background: Color,
    public val onBackground: Color,
    public val onBackgroundDisabled: Color,

    public val surface: Color,
    public val surfaceFocused: Color,
    public val surfacePressed: Color,
    public val surfaceDisabled: Color,

    public val onSurface: Color,
    public val onSurfaceDisabled: Color,

    public val outline: Color,
    public val outlineDisabled: Color,

    public val divider: Color,
    public val dividerDisabled: Color,

    // Neutral variant
    public val surfaceVariant: Color,
    public val surfaceVariantFocused: Color,
    public val surfaceVariantPressed: Color,
    public val surfaceVariantDisabled: Color,

    public val onSurfaceVariant: Color,
    public val onSurfaceVariantDisabled: Color,

    public val outlineVariant: Color,
    public val outlineVariantDisabled: Color,

    public val dividerVariant: Color,
    public val dividerVariantDisabled: Color,
)
