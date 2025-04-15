package mobi.lab.components.compose.widget.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.theme.LabTheme

@Suppress("LongParameterList")
@Immutable
public object LabButtonDefaults {

    public val iconSize: Dp = 24.dp

    public val smallIconSize: Dp = 16.dp

    public val contentPadding: PaddingValues = PaddingValues(
        horizontal = 24.dp,
        vertical = 12.dp,
    )

    public val smallContentPadding: PaddingValues = PaddingValues(
        horizontal = 16.dp,
        vertical = 8.dp,
    )

    public val iconButtonContentPadding: PaddingValues = PaddingValues(8.dp)

    public val smallIconButtonContentPadding: PaddingValues = PaddingValues(8.dp)

    public val textButtonContentPadding: PaddingValues = PaddingValues(
        start = 12.dp,
        top = 12.dp,
        end = 12.dp,
        bottom = 12.dp
    )

    public val smallTextButtonContentPadding: PaddingValues = PaddingValues(
        start = 8.dp,
        top = 8.dp,
        end = 8.dp,
        bottom = 8.dp
    )

    public val progressStrokeWidth: Dp = 3.dp
    public val minWidth: Dp = 58.dp
    public val minHeight: Dp = 48.dp
    public val iconSpacing: Dp = 8.dp
    public val borderWidth: Dp = 1.dp
    public val elevation: Dp = 0.dp

    public val shape: Shape @Composable get() = LabTheme.shapes.button
    public val iconButtonShape: Shape @Composable get() = LabTheme.shapes.roundButton
    public val textStyle: TextStyle @Composable get() = LabTheme.typography.bodyLargeEmphasis.copy(color = Color.Unspecified)

    @Composable
    public fun buttonBorder(): LabButtonBorder {
        return LabButtonBorder.Disabled
    }

    @Composable
    public fun filledButtonBorder(): LabButtonBorder {
        return LabButtonBorder.Disabled
    }

    @Composable
    public fun outlinedButtonBorder(): LabButtonBorder {
        return LabButtonBorder.Enabled(
            color = LabTheme.colors.outlineVariant,
            focusedColor = LabTheme.colors.secondaryFocused,
            pressedColor = LabTheme.colors.outlineVariant,
            disabledColor = LabTheme.colors.outlineVariantDisabled,
            width = borderWidth
        )
    }

    @Composable
    public fun textButtonBorder(): LabButtonBorder {
        return LabButtonBorder.Disabled
    }

    @Composable
    public fun iconButtonBorder(): LabButtonBorder {
        return LabButtonBorder.Disabled
    }

    @Composable
    public fun buttonColors(): LabButtonColors {
        return filledButtonColors()
    }

    @Composable
    public fun filledButtonColors(): LabButtonColors {
        return LabButtonColors(
            contentColor = LabTheme.colors.onPrimary,
            focusedContentColor = LabTheme.colors.onPrimary,
            pressedContentColor = LabTheme.colors.onPrimary,
            disabledContentColor = LabTheme.colors.onPrimaryDisabled,
            containerColor = LabTheme.colors.primary,
            focusedContainerColor = LabTheme.colors.primaryFocused,
            pressedContainerColor = LabTheme.colors.primaryFocused,
            disabledContainerColor = LabTheme.colors.primarySurfaceDisabled,
        )
    }

    @Composable
    public fun outlinedButtonColors(): LabButtonColors {
        return LabButtonColors(
            contentColor = LabTheme.colors.onSurface,
            focusedContentColor = LabTheme.colors.onSurface,
            pressedContentColor = LabTheme.colors.onSurface,
            disabledContentColor = LabTheme.colors.onSurfaceDisabled,
            containerColor = LabTheme.colors.surface,
            focusedContainerColor = LabTheme.colors.surface,
            pressedContainerColor = LabTheme.colors.surfaceFocused,
            disabledContainerColor = LabTheme.colors.surfaceDisabled,
        )
    }

    @Composable
    public fun textButtonColors(): LabButtonColors {
        return LabButtonColors(
            contentColor = LabTheme.colors.onSurface,
            focusedContentColor = LabTheme.colors.onSurface,
            pressedContentColor = LabTheme.colors.onSurface,
            disabledContentColor = LabTheme.colors.onSurfaceDisabled,
            containerColor = LabTheme.colors.surface,
            focusedContainerColor = LabTheme.colors.surfaceFocused,
            pressedContainerColor = LabTheme.colors.surfaceFocused,
            disabledContainerColor = LabTheme.colors.surfaceDisabled,
        )
    }

    @Composable
    public fun iconButtonColors(): LabButtonColors {
        return LabButtonColors(
            contentColor = LabTheme.colors.onSurface,
            focusedContentColor = LabTheme.colors.onSurface,
            pressedContentColor = LabTheme.colors.onSurface,
            disabledContentColor = LabTheme.colors.onSurfaceDisabled,
            containerColor = LabTheme.colors.surface,
            focusedContainerColor = LabTheme.colors.secondarySurfaceFocused,
            pressedContainerColor = LabTheme.colors.secondarySurfacePressed,
            disabledContainerColor = LabTheme.colors.secondarySurfaceDisabled,
        )
    }

    @Composable
    public fun floatingActionButtonColors(): LabButtonColors {
        return LabButtonColors(
            contentColor = LabTheme.colors.onSecondary,
            focusedContentColor = LabTheme.colors.onSecondary,
            pressedContentColor = LabTheme.colors.onSecondary,
            disabledContentColor = LabTheme.colors.onSecondaryDisabled,
            containerColor = LabTheme.colors.secondary,
            focusedContainerColor = LabTheme.colors.secondaryFocused,
            pressedContainerColor = LabTheme.colors.secondaryFocused,
            disabledContainerColor = LabTheme.colors.secondaryDisabled,
        )
    }
}
