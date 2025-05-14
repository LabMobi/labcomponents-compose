@file:Suppress("MemberVisibilityCanBePrivate")

package mobi.lab.components.compose.widget.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.widget.progress.LabIndeterminateCircularIndicator

@Suppress("LongParameterList")
@Immutable
public object LabButtonDefaults {

    public val iconSize: Dp = 24.dp
    public val smallIconSize: Dp = 16.dp

    // Content padding differs based if there is an icon or not and if it is a medium or small button
    public val contentPaddingNoIcons: PaddingValues = PaddingValues(
        horizontal = 24.dp,
        vertical = 12.dp,
    )

    public val contentPaddingWithStartIcon: PaddingValues = PaddingValues(
        start = 16.dp,
        end = 24.dp,
        top = 12.dp,
        bottom = 12.dp,
    )

    public val contentPaddingWithEndIcon: PaddingValues = PaddingValues(
        start = 24.dp,
        end = 16.dp,
        top = 12.dp,
        bottom = 12.dp,
    )

    public val contentPaddingWithBothIcons: PaddingValues = PaddingValues(
        start = 12.dp,
        end = 16.dp,
        top = 12.dp,
        bottom = 12.dp,
    )

    public val smallContentPaddingNoIcons: PaddingValues = PaddingValues(
        horizontal = 16.dp,
        vertical = 8.dp,
    )

    public val smallContentPaddingWithStartIcon: PaddingValues = PaddingValues(
        start = 12.dp,
        end = 16.dp,
        top = 8.dp,
        bottom = 8.dp,
    )

    public val smallContentPaddingWithEndIcon: PaddingValues = PaddingValues(
        start = 16.dp,
        end = 12.dp,
        top = 8.dp,
        bottom = 8.dp,
    )

    public val smallContentPaddingWithBothIcons: PaddingValues = PaddingValues(
        start = 12.dp,
        end = 12.dp,
        top = 8.dp,
        bottom = 8.dp,
    )

    @Composable
    public fun contentPaddings(hasIconStart: Boolean, hasIconEnd: Boolean): PaddingValues {
        return if (hasIconStart && hasIconEnd) {
            contentPaddingWithBothIcons
        } else if (hasIconStart) {
            contentPaddingWithStartIcon
        } else if (hasIconEnd) {
            contentPaddingWithEndIcon
        } else {
            contentPaddingNoIcons
        }
    }

    @Composable
    public fun smallContentPaddings(hasIconStart: Boolean, hasIconEnd: Boolean): PaddingValues {
        return if (hasIconStart && hasIconEnd) {
            smallContentPaddingWithBothIcons
        } else if (hasIconStart) {
            smallContentPaddingWithStartIcon
        } else if (hasIconEnd) {
            smallContentPaddingWithEndIcon
        } else {
            smallContentPaddingNoIcons
        }
    }

    public val iconButtonContentPadding: PaddingValues = PaddingValues(12.dp)

    public val smallIconButtonContentPadding: PaddingValues = PaddingValues(8.dp)

    public val textButtonContentPaddingNoIcons: PaddingValues = PaddingValues(
        all = 12.dp,
    )

    public val textButtonContentPaddingWithStartIcon: PaddingValues = PaddingValues(
        start = 12.dp,
        top = 12.dp,
        end = 16.dp,
        bottom = 12.dp
    )

    public val textButtonContentPaddingWithEndIcon: PaddingValues = PaddingValues(
        start = 16.dp,
        top = 12.dp,
        end = 12.dp,
        bottom = 12.dp
    )

    public val textButtonContentPaddingWithBothIcons: PaddingValues = PaddingValues(
        all = 12.dp,
    )

    public val smallTextButtonContentPaddingNoIcons: PaddingValues = PaddingValues(
        all = 8.dp,
    )

    public val smallTextButtonContentPaddingWithStartIcon: PaddingValues = PaddingValues(
        start = 8.dp,
        top = 8.dp,
        end = 12.dp,
        bottom = 8.dp
    )

    public val smallTextButtonContentPaddingWithEndIcon: PaddingValues = PaddingValues(
        start = 12.dp,
        top = 8.dp,
        end = 8.dp,
        bottom = 8.dp
    )

    public val smallTextButtonContentPaddingWithBothIcons: PaddingValues = PaddingValues(
        all = 8.dp,
    )

    @Composable
    public fun textButtonContentPaddings(hasIconStart: Boolean, hasIconEnd: Boolean): PaddingValues {
        return if (hasIconStart && hasIconEnd) {
            textButtonContentPaddingWithBothIcons
        } else if (hasIconStart) {
            textButtonContentPaddingWithStartIcon
        } else if (hasIconEnd) {
            textButtonContentPaddingWithEndIcon
        } else {
            textButtonContentPaddingNoIcons
        }
    }

    @Composable
    public fun smallTextButtonContentPaddings(hasIconStart: Boolean, hasIconEnd: Boolean): PaddingValues {
        return if (hasIconStart && hasIconEnd) {
            smallTextButtonContentPaddingWithBothIcons
        } else if (hasIconStart) {
            smallTextButtonContentPaddingWithStartIcon
        } else if (hasIconEnd) {
            smallTextButtonContentPaddingWithEndIcon
        } else {
            smallTextButtonContentPaddingNoIcons
        }
    }

    public val minWidth: Dp = 48.dp
    public val minHeight: Dp = 48.dp
    public val smallMinWidth: Dp = 36.dp
    public val smallMinHeight: Dp = 36.dp
    public val iconSpacing: Dp = 8.dp
    public val borderWidth: Dp = 1.dp
    public val elevation: Dp = 0.dp

    public val shape: Shape @Composable get() = LabTheme.shapes.button
    public val iconButtonShape: Shape @Composable get() = LabTheme.shapes.button
    public val textStyle: TextStyle @Composable get() = LabTheme.typography.labelLarge.copy(color = Color.Unspecified)

    // Text style for small buttons used to be different so we have a separate default here atm
    public val smallTextStyle: TextStyle @Composable get() = textStyle

    @Composable
    public fun buttonBorder(): LabButtonBorder {
        return LabButtonBorder.Disabled
    }

    @Composable
    public fun filledButtonBorder(): LabButtonBorder {
        return LabButtonBorder.Disabled
    }

    @Composable
    public fun tonedButtonBorder(): LabButtonBorder {
        return LabButtonBorder.Disabled
    }

    @Composable
    public fun outlinedButtonBorder(): LabButtonBorder {
        return LabButtonBorder.Enabled(
            color = LabTheme.colors.outlineVariant,
            focusedColor = LabTheme.colors.primary,
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
            pressedContainerColor = LabTheme.colors.primaryPressed,
            disabledContainerColor = LabTheme.colors.primarySurfaceDisabled,
        )
    }

    @Composable
    public fun tonedButtonColors(): LabButtonColors {
        return LabButtonColors(
            contentColor = LabTheme.colors.onSecondarySurface,
            focusedContentColor = LabTheme.colors.onSecondarySurface,
            pressedContentColor = LabTheme.colors.onSecondarySurface,
            disabledContentColor = LabTheme.colors.onSecondarySurfaceDisabled,
            containerColor = LabTheme.colors.secondarySurface,
            focusedContainerColor = LabTheme.colors.secondarySurfaceFocused,
            pressedContainerColor = LabTheme.colors.secondarySurfacePressed,
            disabledContainerColor = LabTheme.colors.secondarySurfaceDisabled,
        )
    }

    @Composable
    public fun outlinedButtonColors(): LabButtonColors {
        return LabButtonColors(
            contentColor = LabTheme.colors.primary,
            focusedContentColor = LabTheme.colors.primary,
            pressedContentColor = LabTheme.colors.primary,
            disabledContentColor = LabTheme.colors.onSurfaceDisabled,
            // No token here atm
            containerColor = Color.Transparent,
            focusedContainerColor = LabTheme.colors.primarySurfaceFocused,
            pressedContainerColor = LabTheme.colors.primarySurfacePressed,
            // No token here atm
            disabledContainerColor = Color.Transparent,
        )
    }

    @Composable
    public fun textButtonColors(): LabButtonColors {
        return LabButtonColors(
            contentColor = LabTheme.colors.primary,
            focusedContentColor = LabTheme.colors.primary,
            pressedContentColor = LabTheme.colors.primary,
            disabledContentColor = LabTheme.colors.onSurfaceDisabled,
            // No token here atm
            containerColor = Color.Transparent,
            focusedContainerColor = LabTheme.colors.primarySurfaceFocused,
            pressedContainerColor = LabTheme.colors.primarySurfacePressed,
            // No token here atm
            disabledContainerColor = Color.Transparent,
        )
    }

    @Composable
    public fun iconButtonColors(): LabButtonColors {
        return LabButtonColors(
            contentColor = LabTheme.colors.primary,
            focusedContentColor = LabTheme.colors.primary,
            pressedContentColor = LabTheme.colors.primary,
            disabledContentColor = LabTheme.colors.onPrimarySurfaceDisabled,
            // No token here atm
            containerColor = Color.Transparent,
            focusedContainerColor = LabTheme.colors.primarySurfaceFocused,
            pressedContainerColor = LabTheme.colors.primarySurfacePressed,
            // No token here atm
            disabledContainerColor = Color.Transparent,
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

    @Composable
    public fun DefaultButtonProgressIndicator(modifier: Modifier) {
        LabIndeterminateCircularIndicator(
            modifier = modifier,
            color = LocalContentColor.current,
        )
    }
}
