package mobi.lab.components.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * A theme that takes different parts of the Design system as arguments.
 * This opens up the possibility of customizing values based on flavours.
 *
 * @Composable
 * fun SomeTheme(
 *     content: @Composable() -> Unit
 * ) {
 *     // Any customization here
 *     LabTheme(content)
 * }
 */
@Composable
public fun LabTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    colors: LabColors = if (isDark) LabThemeDefaults.darkColors() else LabThemeDefaults.lightColors(),
    typography: LabTypography = LabThemeDefaults.typography(),
    dimensions: LabDimensions = LabThemeDefaults.dimensions(),
    constants: LabConstants = LabThemeDefaults.constants(),
    shapes: LabShapes = LabThemeDefaults.shapes(),
    materialColorScheme: ColorScheme = debugColors(),
    materialTypography: Typography = debugTypography(),
    content: @Composable () -> Unit,
) {
    // Make our values available
    ProvideLabValues(colors, typography, dimensions, constants, shapes) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            typography = materialTypography,
            content = {
                // Provide a default TextStyle for all the following content.
                // This is inside MaterialTheme to override the default style.
                // Remove the color from here as we want LocalContentColor to set the content color
                CompositionLocalProvider(
                    LocalTextStyle provides typography.bodyLarge.copy(color = Color.Unspecified),
                    LocalContentColor provides colors.onSurface
                ) {
                    content()
                }
            }
        )
    }
}

public object LabTheme {
    public val colors: LabColors
        @Composable
        @ReadOnlyComposable
        get() = LocalLabColors.current

    public val typography: LabTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalLabTypography.current

    public val dimensions: LabDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalLabDimensions.current

    public val constants: LabConstants
        @Composable
        @ReadOnlyComposable
        get() = LocalLabConstants.current

    public val shapes: LabShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalLabShapes.current
}

@Composable
internal fun ProvideLabValues(
    colors: LabColors,
    typography: LabTypography,
    dimensions: LabDimensions,
    constants: LabConstants,
    shapes: LabShapes,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalLabColors provides colors,
        LocalLabTypography provides typography,
        LocalLabDimensions provides dimensions,
        LocalLabConstants provides constants,
        LocalLabShapes provides shapes,
        content = content
    )
}

public val LocalLabColors: ProvidableCompositionLocal<LabColors> = staticCompositionLocalOf {
    error("No LabColors provided")
}

public val LocalLabTypography: ProvidableCompositionLocal<LabTypography> = staticCompositionLocalOf {
    error("No LabTypography provided")
}

public val LocalLabDimensions: ProvidableCompositionLocal<LabDimensions> = staticCompositionLocalOf {
    error("No LabDimensions provided")
}

public val LocalLabConstants: ProvidableCompositionLocal<LabConstants> = staticCompositionLocalOf {
    error("No LabConstants provided")
}

public val LocalLabShapes: ProvidableCompositionLocal<LabShapes> = staticCompositionLocalOf {
    error("No LabShapes provided")
}

/**
 * A Material [ColorScheme] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colorScheme] in preference to [LabTheme.colors].
 */
internal fun debugColors(debugColor: Color = Color.Cyan) = ColorScheme(
    primary = debugColor,
    onPrimary = debugColor,
    primaryContainer = debugColor,
    onPrimaryContainer = debugColor,
    inversePrimary = debugColor,
    secondary = debugColor,
    onSecondary = debugColor,
    secondaryContainer = debugColor,
    onSecondaryContainer = debugColor,
    tertiary = debugColor,
    onTertiary = debugColor,
    tertiaryContainer = debugColor,
    onTertiaryContainer = debugColor,
    background = debugColor,
    onBackground = debugColor,
    surface = debugColor,
    onSurface = debugColor,
    surfaceVariant = debugColor,
    onSurfaceVariant = debugColor,
    surfaceTint = debugColor,
    inverseSurface = debugColor,
    inverseOnSurface = debugColor,
    error = debugColor,
    onError = debugColor,
    errorContainer = debugColor,
    onErrorContainer = debugColor,
    outline = debugColor,
    outlineVariant = debugColor,
    scrim = debugColor,
    surfaceBright = debugColor,
    surfaceDim = debugColor,
    surfaceContainer = debugColor,
    surfaceContainerHigh = debugColor,
    surfaceContainerHighest = debugColor,
    surfaceContainerLow = debugColor,
    surfaceContainerLowest = debugColor,
)

/**
 * A Material [Typography] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.typography] in preference to [LabTheme.typography].
 */
internal fun debugTypography(debugColor: Color = Color.Magenta): Typography {
    val typography = Typography()
    return typography.copy(
        displayLarge = typography.displayLarge.copy(color = debugColor),
        displayMedium = typography.displayMedium.copy(color = debugColor),
        displaySmall = typography.displaySmall.copy(color = debugColor),
        headlineLarge = typography.headlineLarge.copy(color = debugColor),
        headlineMedium = typography.headlineMedium.copy(color = debugColor),
        headlineSmall = typography.headlineSmall.copy(color = debugColor),
        titleLarge = typography.titleLarge.copy(color = debugColor),
        titleMedium = typography.titleMedium.copy(color = debugColor),
        titleSmall = typography.titleSmall.copy(color = debugColor),
        bodyLarge = typography.bodyLarge.copy(color = debugColor),
        bodyMedium = typography.bodyMedium.copy(color = debugColor),
        bodySmall = typography.bodySmall.copy(color = debugColor),
        labelLarge = typography.labelLarge.copy(color = debugColor),
        labelMedium = typography.labelMedium.copy(color = debugColor),
        labelSmall = typography.labelSmall.copy(color = debugColor),
    )
}
