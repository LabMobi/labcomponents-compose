@file:Suppress("LongParameterList", "UnusedPrivateMember")

package mobi.lab.components.compose.widget.button

import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.util.previewInteractionSourceOf
import mobi.lab.components.compose.widget.image.ImageSource

@Composable
public fun LabFilledButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    onClick: () -> Unit,
    iconStart: ImageSource? = null,
    iconEnd: ImageSource? = null,
    iconSize: Dp = LabButtonDefaults.iconSize,
    iconSpacing: Dp = LabButtonDefaults.iconSpacing,
    showProgress: Boolean = false,
    enabled: Boolean = true,
    shape: Shape = LabButtonDefaults.shape,
    colors: LabButtonColors = LabButtonDefaults.filledButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.filledButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.contentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    LabButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        iconStart = iconStart,
        iconEnd = iconEnd,
        iconSpacing = iconSpacing,
        showProgress = showProgress,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
    )
}

@Composable
public fun LabFilledSmallButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    onClick: () -> Unit,
    iconStart: ImageSource? = null,
    iconEnd: ImageSource? = null,
    iconSize: Dp = LabButtonDefaults.smallIconSize,
    iconSpacing: Dp = LabButtonDefaults.iconSpacing,
    showProgress: Boolean = false,
    enabled: Boolean = true,
    shape: Shape = LabButtonDefaults.shape,
    colors: LabButtonColors = LabButtonDefaults.filledButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.filledButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.smallContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    LabButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        iconStart = iconStart,
        iconEnd = iconEnd,
        iconSize = iconSize,
        iconSpacing = iconSpacing,
        showProgress = showProgress,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightEnabled() {
    PreviewContainer {
        LabFilledButton(
            text = "Enabled",
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightFocused() {
    PreviewContainer {
        LabFilledButton(
            text = "Focused",
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
            text = "Pressed",
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
            text = "Disabled",
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightEnabledLoading() {
    PreviewContainer {
        LabFilledButton(
            text = "Enabled",
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
            text = "Disabled",
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
            text = "Enabled",
            onClick = {},
            enabled = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightDisabledLoading() {
    PreviewContainer {
        LabFilledSmallButton(
            text = "Disabled",
            onClick = {},
            enabled = false,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkEnabled() {
    PreviewContainer(isDark = true) {
        LabFilledButton(
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
        LabFilledButton(
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
        LabFilledButton(
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
        LabFilledButton(
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
        LabFilledButton(
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
        LabFilledButton(
            text = "Disabled",
            onClick = {},
            enabled = false,
            showProgress = true
        )
    }
}
