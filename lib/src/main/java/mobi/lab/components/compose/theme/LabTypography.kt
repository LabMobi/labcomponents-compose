package mobi.lab.components.compose.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
public data class LabTypography(
    public val displayLarge: TextStyle,
    public val displayMedium: TextStyle,
    public val displaySmall: TextStyle,
    public val headlineLarge: TextStyle,
    public val headlineMedium: TextStyle,
    public val headlineSmall: TextStyle,
    public val titleLarge: TextStyle,
    public val titleMedium: TextStyle,
    public val titleSmall: TextStyle,
    public val bodyLarge: TextStyle,
    public val bodyLargeEmphasis: TextStyle,
    public val bodyMedium: TextStyle,
    public val bodyMediumEmphasis: TextStyle,
    public val bodySmall: TextStyle,
    public val bodySmallEmphasis: TextStyle,
    public val labelLarge: TextStyle,
    public val labelMedium: TextStyle,
    public val labelSmall: TextStyle,
)
