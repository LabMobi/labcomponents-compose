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
public fun LabOutlinedButton(
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
    colors: LabButtonColors = LabButtonDefaults.outlinedButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.outlinedButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.contentPaddings(
        hasIconStart = iconStart != null,
        hasIconEnd = iconEnd != null,
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
public fun LabOutlinedSmallButton(
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
    textStyle: TextStyle = LabButtonDefaults.smallTextStyle,
    shape: Shape = LabButtonDefaults.shape,
    colors: LabButtonColors = LabButtonDefaults.outlinedButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.outlinedButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.smallContentPaddings(
        hasIconStart = iconStart != null,
        hasIconEnd = iconEnd != null,
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
        LabOutlinedButton(
            text = "M Enabled",
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightEnabled() {
    PreviewContainer {
        LabOutlinedSmallButton(
            text = "S Enabled",
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewIconStartLightEnabled() {
    PreviewContainer {
        LabOutlinedButton(
            text = "M Enabled",
            onClick = {},
            enabled = true,
            iconStart = ImageSource.vector(Icons.Filled.FavoriteBorder),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallIconStartLightEnabled() {
    PreviewContainer {
        LabOutlinedSmallButton(
            text = "S Enabled",
            onClick = {},
            enabled = true,
            iconStart = ImageSource.vector(Icons.Filled.FavoriteBorder),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewIconEndLightEnabled() {
    PreviewContainer {
        LabOutlinedButton(
            text = "M Enabled",
            onClick = {},
            enabled = true,
            iconEnd = ImageSource.vector(Icons.Filled.FavoriteBorder),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallIconEndLightEnabled() {
    PreviewContainer {
        LabOutlinedSmallButton(
            text = "S Enabled",
            onClick = {},
            enabled = true,
            iconEnd = ImageSource.vector(Icons.Filled.FavoriteBorder),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewIconBothLightEnabled() {
    PreviewContainer {
        LabOutlinedButton(
            text = "M Enabled",
            onClick = {},
            enabled = true,
            iconStart = ImageSource.vector(Icons.Filled.FavoriteBorder),
            iconEnd = ImageSource.vector(Icons.Filled.FavoriteBorder),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallIconBothLightEnabled() {
    PreviewContainer {
        LabOutlinedSmallButton(
            text = "S Enabled",
            onClick = {},
            enabled = true,
            iconStart = ImageSource.vector(Icons.Filled.FavoriteBorder),
            iconEnd = ImageSource.vector(Icons.Filled.FavoriteBorder),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightFocused() {
    PreviewContainer {
        LabOutlinedButton(
            text = "M Focused",
            onClick = {},
            enabled = true,
            interactionSource = previewInteractionSourceOf(FocusInteraction.Focus())
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightFocused() {
    PreviewContainer {
        LabOutlinedSmallButton(
            text = "S Focused",
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
        LabOutlinedButton(
            text = "M Pressed",
            onClick = {},
            enabled = true,
            interactionSource = previewInteractionSourceOf(PressInteraction.Press(Offset.Zero))
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightPressed() {
    PreviewContainer {
        LabOutlinedSmallButton(
            text = "S Pressed",
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
        LabOutlinedButton(
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
        LabOutlinedButton(
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
        LabOutlinedButton(
            text = "M Size different",
            onClick = {},
            minWidth = 60.dp,
            minHeight = 60.dp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightDisabled() {
    PreviewContainer {
        LabOutlinedSmallButton(
            text = "S Disabled",
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightDifferentFont() {
    PreviewContainer {
        LabOutlinedSmallButton(
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
        LabOutlinedSmallButton(
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
private fun PreviewLightEnabledLoading() {
    PreviewContainer {
        LabOutlinedButton(
            text = "M",
            onClick = {},
            enabled = true,
            showProgress = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightEnabledLoading() {
    PreviewContainer {
        LabOutlinedSmallButton(
            text = "S",
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
        LabOutlinedButton(
            text = "M Disabled",
            onClick = {},
            enabled = false,
            showProgress = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightDisabledLoading() {
    PreviewContainer {
        LabOutlinedSmallButton(
            text = "S Disabled",
            onClick = {},
            enabled = false,
            showProgress = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkEnabled() {
    PreviewContainer(isDark = true) {
        LabOutlinedButton(
            text = "Enabled",
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkFocused() {
    PreviewContainer(isDark = true) {
        LabOutlinedButton(
            text = "Focused",
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
        LabOutlinedButton(
            text = "Pressed",
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
        LabOutlinedButton(
            text = "Disabled",
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkEnabledLoading() {
    PreviewContainer(isDark = true) {
        LabOutlinedButton(
            text = "Enabled",
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
        LabOutlinedButton(
            text = "Disabled",
            onClick = {},
            enabled = false,
            showProgress = true
        )
    }
}
