@file:Suppress("LongParameterList", "UnusedPrivateMember")

package mobi.lab.components.compose.widget.button

import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.util.previewInteractionSourceOf
import mobi.lab.components.compose.widget.button.LabButtonDefaults.DefaultButtonProgressIndicator
import mobi.lab.components.compose.widget.image.ImageSource

@Composable
public fun LabFilledButton(
    modifier: Modifier = Modifier,
    minWidth: Dp = LabButtonDefaults.minWidth,
    minHeight: Dp = LabButtonDefaults.minHeight,
    text: String? = null,
    onClick: () -> Unit,
    iconStart: ImageSource? = null,
    iconEnd: ImageSource? = null,
    iconSize: Dp = LabButtonDefaults.iconSize,
    iconSpacing: Dp = LabButtonDefaults.iconSpacing,
    showProgress: Boolean = false,
    enabled: Boolean = true,
    textStyle: TextStyle = LabButtonDefaults.textStyle,
    shape: Shape = LabButtonDefaults.shape,
    colors: LabButtonColors = LabButtonDefaults.filledButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.filledButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.contentPaddings(
        hasIconStart = iconStart != null,
        hasIconEnd = iconEnd != null
    ),
    indeterminateProgressIndicator: @Composable (modifier: Modifier) -> Unit = { mod ->
        DefaultButtonProgressIndicator(mod)
    },
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    LabButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        minWidth = minWidth,
        minHeight = minHeight,
        iconStart = iconStart,
        iconEnd = iconEnd,
        iconSize = iconSize,
        iconSpacing = iconSpacing,
        showProgress = showProgress,
        enabled = enabled,
        textStyle = textStyle,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        indeterminateProgressIndicator = indeterminateProgressIndicator,
        interactionSource = interactionSource,
    )
}

@Composable
public fun LabFilledSmallButton(
    modifier: Modifier = Modifier,
    minWidth: Dp = LabButtonDefaults.minWidth,
    minHeight: Dp = LabButtonDefaults.minHeight,
    text: String? = null,
    onClick: () -> Unit,
    iconStart: ImageSource? = null,
    iconEnd: ImageSource? = null,
    iconSize: Dp = LabButtonDefaults.smallIconSize,
    iconSpacing: Dp = LabButtonDefaults.iconSpacing,
    showProgress: Boolean = false,
    enabled: Boolean = true,
    textStyle: TextStyle = LabButtonDefaults.textStyle,
    shape: Shape = LabButtonDefaults.shape,
    colors: LabButtonColors = LabButtonDefaults.filledButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.filledButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.smallContentPaddings(
        hasIconStart = iconStart != null,
        hasIconEnd = iconEnd != null
    ),
    indeterminateProgressIndicator: @Composable (modifier: Modifier) -> Unit = { mod ->
        DefaultButtonProgressIndicator(mod)
    },
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    LabSmallButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        minWidth = minWidth,
        minHeight = minHeight,
        iconStart = iconStart,
        iconEnd = iconEnd,
        iconSize = iconSize,
        iconSpacing = iconSpacing,
        showProgress = showProgress,
        enabled = enabled,
        textStyle = textStyle,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        indeterminateProgressIndicator = indeterminateProgressIndicator,
        interactionSource = interactionSource,
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightEnabled() {
    PreviewContainer {
        LabFilledButton(
            text = "M Enabled",
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightStartIconEnabled() {
    PreviewContainer {
        LabFilledButton(
            text = "M Enabled",
            onClick = {},
            enabled = true,
            iconStart = ImageSource.vector(Icons.Filled.FavoriteBorder)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightSEndIconEnabled() {
    PreviewContainer {
        LabFilledButton(
            text = "M Enabled",
            onClick = {},
            enabled = true,
            iconEnd = ImageSource.vector(Icons.Filled.FavoriteBorder)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightFocused() {
    PreviewContainer {
        LabFilledButton(
            text = "M Focused",
            onClick = {},
            enabled = true,
            interactionSource = previewInteractionSourceOf(FocusInteraction.Focus())
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightPressed() {
    PreviewContainer {
        LabFilledButton(
            text = "M Pressed",
            onClick = {},
            enabled = true,
            interactionSource = previewInteractionSourceOf(PressInteraction.Press(Offset.Zero))
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightDisabled() {
    PreviewContainer {
        LabFilledButton(
            text = "M Disabled",
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightDifferentFont() {
    PreviewContainer {
        LabFilledButton(
            text = "M Font different",
            onClick = {},
            textStyle = LabTheme.typography.labelSmall.copy(color = Color.Unspecified)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightDifferentSize() {
    PreviewContainer {
        LabFilledButton(
            text = "M Size different",
            onClick = {},
            minWidth = 60.dp,
            minHeight = 60.dp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightEnabledLoading() {
    PreviewContainer {
        LabFilledButton(
            text = "M Loading Enabled",
            onClick = {},
            enabled = true,
            showProgress = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightDisabledLoading() {
    PreviewContainer {
        LabFilledButton(
            text = "M Loading Disabled",
            onClick = {},
            enabled = false,
            showProgress = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightEnabledLoading() {
    PreviewContainer {
        LabFilledSmallButton(
            text = "S Enabled",
            onClick = {},
            enabled = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightSmallStartIconEnabled() {
    PreviewContainer {
        LabFilledSmallButton(
            text = "S Enabled",
            onClick = {},
            enabled = true,
            iconStart = ImageSource.vector(Icons.Filled.FavoriteBorder)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightSmallEndIconEnabled() {
    PreviewContainer {
        LabFilledSmallButton(
            text = "S Enabled",
            onClick = {},
            enabled = true,
            iconEnd = ImageSource.vector(Icons.Filled.FavoriteBorder)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightDisabled() {
    PreviewContainer {
        LabFilledSmallButton(
            text = "S Disabled",
            onClick = {},
            enabled = false,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightDifferentFont() {
    PreviewContainer {
        LabFilledSmallButton(
            text = "S Font different",
            onClick = {},
            textStyle = LabTheme.typography.labelSmall.copy(color = Color.Unspecified)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightDifferentSize() {
    PreviewContainer {
        LabFilledSmallButton(
            text = "S Size different",
            onClick = {},
            minWidth = 28.dp,
            minHeight = 28.dp,
            textStyle = LabTheme.typography.labelSmall.copy(color = Color.Unspecified)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkEnabled() {
    PreviewContainer(isDark = true) {
        LabFilledButton(
            text = "M Enabled",
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkFocused() {
    PreviewContainer(isDark = true) {
        LabFilledButton(
            text = "M Focused",
            onClick = {},
            enabled = true,
            interactionSource = previewInteractionSourceOf(FocusInteraction.Focus())
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkPressed() {
    PreviewContainer(isDark = true) {
        LabFilledButton(
            text = "M Pressed",
            onClick = {},
            enabled = true,
            interactionSource = previewInteractionSourceOf(PressInteraction.Press(Offset.Zero))
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkDisabled() {
    PreviewContainer(isDark = true) {
        LabFilledButton(
            text = "M Disabled",
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkEnabledLoading() {
    PreviewContainer(isDark = true) {
        LabFilledButton(
            text = "M Loading Enabled",
            onClick = {},
            enabled = true,
            showProgress = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkDisabledLoading() {
    PreviewContainer(isDark = true) {
        LabFilledButton(
            text = "M Loading Disabled",
            onClick = {},
            enabled = false,
            showProgress = true
        )
    }
}
