package mobi.lab.components.compose.widget.textfield

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.withAlpha

@Immutable
public object LabTextFieldDefaults {

    public val shape: Shape
        @Composable
        get() = LabTheme.shapes.textField

    // Remove the specific color to let the TextField color its contents itself
    public val textStyleLarge: TextStyle
        @Composable
        get() = LabTheme.typography.bodyLarge.copy(color = Color.Unspecified)

    // Remove the specific color to let the TextField color its contents itself
    public val textStyleSmall: TextStyle
        @Composable
        get() = LabTheme.typography.labelMedium.copy(color = Color.Unspecified)

    public val minHeight: Dp = 56.dp
    public val minHeightIsErrorExtra: Dp = 20.dp
    public const val ANIMATION_DURATION_MS: Int = 150

    public val unfocusedIndicatorThickness: Dp = 1.dp
    public val focusedIndicatorThickness: Dp = 2.dp

    public val iconSpacing: Dp = 8.dp
    public val iconSize: Dp = 24.dp

    @Composable
    public fun colors(
        primaryColor: Color = LabTheme.colors.primary,
        surfaceColor: Color = LabTheme.colors.surface,
        onSurfaceColor: Color = LabTheme.colors.onSurface,
        onSurfaceVariantColor: Color = LabTheme.colors.onSurfaceVariant,
        outlineVariantColor: Color = LabTheme.colors.outlineVariant,
        errorColor: Color = LabTheme.colors.error,
        disabledAlpha: Float = LabTheme.constants.disabledAlpha,
    ): TextFieldColors {
        return TextFieldDefaults.colors().copy(
            focusedTextColor = onSurfaceColor,
            unfocusedTextColor = onSurfaceColor,
            disabledTextColor = onSurfaceVariantColor.withAlpha(disabledAlpha),
            errorTextColor = errorColor,
            focusedContainerColor = surfaceColor,
            unfocusedContainerColor = surfaceColor,
            disabledContainerColor = surfaceColor,
            errorContainerColor = surfaceColor,
            cursorColor = primaryColor,
            errorCursorColor = errorColor,
            textSelectionColors = TextSelectionColors(
                handleColor = primaryColor,
                backgroundColor = primaryColor,
            ),
            focusedIndicatorColor = primaryColor,
            unfocusedIndicatorColor = outlineVariantColor,
            disabledIndicatorColor = outlineVariantColor.withAlpha(disabledAlpha),
            errorIndicatorColor = errorColor,
            focusedLeadingIconColor = onSurfaceVariantColor,
            unfocusedLeadingIconColor = onSurfaceVariantColor,
            disabledLeadingIconColor = onSurfaceVariantColor.withAlpha(disabledAlpha),
            errorLeadingIconColor = errorColor,
            focusedTrailingIconColor = onSurfaceVariantColor,
            unfocusedTrailingIconColor = onSurfaceVariantColor,
            disabledTrailingIconColor = onSurfaceVariantColor.withAlpha(disabledAlpha),
            errorTrailingIconColor = errorColor,
            focusedLabelColor = primaryColor,
            unfocusedLabelColor = onSurfaceVariantColor,
            disabledLabelColor = onSurfaceVariantColor.withAlpha(disabledAlpha),
            errorLabelColor = errorColor,
            focusedPlaceholderColor = onSurfaceVariantColor,
            unfocusedPlaceholderColor = onSurfaceVariantColor,
            disabledPlaceholderColor = onSurfaceVariantColor.withAlpha(disabledAlpha),
            errorPlaceholderColor = onSurfaceVariantColor,
            focusedSupportingTextColor = onSurfaceVariantColor,
            unfocusedSupportingTextColor = onSurfaceVariantColor,
            disabledSupportingTextColor = onSurfaceVariantColor.withAlpha(disabledAlpha),
            errorSupportingTextColor = errorColor,
            focusedPrefixColor = onSurfaceVariantColor,
            unfocusedPrefixColor = onSurfaceVariantColor,
            disabledPrefixColor = onSurfaceVariantColor.withAlpha(disabledAlpha),
            errorPrefixColor = onSurfaceVariantColor,
            focusedSuffixColor = onSurfaceVariantColor,
            unfocusedSuffixColor = onSurfaceVariantColor,
            disabledSuffixColor = onSurfaceVariantColor.withAlpha(disabledAlpha),
            errorSuffixColor = onSurfaceVariantColor
        )
    }
}
