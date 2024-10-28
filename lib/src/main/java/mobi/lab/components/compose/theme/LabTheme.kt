package mobi.lab.components.compose.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * A theme that takes different parts of the Design system as arguments.
 * This opens up the possibility of customizing values based on flavours.
 *
 * Currently each item defaults to XML based values. This is needed until we remove all usages
 * of XML-based layouts. Until then, it makes sense to define values in XML and read them here to
 * keep a single source of truth for Compose and XML layouts.
 *
 * @Composable
 * fun SomeTheme(
 *     darkTheme = false,
 *     content: @Composable() -> Unit
 * ) {
 *     // Any customization here
 *     AppThemeComposable(content)
 * }
 */
@Composable
public fun LabTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: LabColors = LabColors.Companion.fromResources(darkTheme),
    typography: LabTypography = LabTypography.Companion.defaults(),
    constants: LabConstants = LabConstants.Companion.fromResources(),
    shapes: LabShapes = LabShapes.Companion.fromResources(dimensions),
    content: @Composable () -> Unit,
) {
    // Make our values available
    ProvideLabValues(colors, typography, constants, shapes) {
        MaterialTheme(
            colorScheme = debugColors(),
            typography = debugTypography(),
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
    public val isDark: Boolean
        @Composable
        @ReadOnlyComposable
        get() = colors.isDark

    public val colors: LabColors
        @Composable
        @ReadOnlyComposable
        get() = LocalLabColors.current

    public val typography: LabTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalLabTypography.current

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
    constants: LabConstants,
    shapes: LabShapes,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalLabColors provides colors,
        LocalLabTypography provides typography,
        LocalLabConstants provides constants,
        LocalLabShapes provides shapes,
        content = content
    )
}

private val LocalLabColors = staticCompositionLocalOf<LabColors> {
    error("No LabColors provided")
}

private val LocalLabTypography = staticCompositionLocalOf<LabTypography> {
    error("No LabTypography provided")
}

private val LocalLabConstants = staticCompositionLocalOf<LabConstants> {
    error("No LabConstants provided")
}

private val LocalLabShapes = staticCompositionLocalOf<LabShapes> {
    error("No LabShapes provided")
}

/**
 * A Material [Colors] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colors] in preference to [LabTheme.colors].
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
