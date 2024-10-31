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
public fun LabOutlinedButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    onClick: () -> Unit,
    icon: ImageSource? = null,
    iconSpacing: Dp = LabButtonDefaults.iconSpacing,
    showProgress: Boolean = false,
    enabled: Boolean = true,
    shape: Shape = LabButtonDefaults.shape,
    colors: LabButtonColors = LabButtonDefaults.outlinedButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.outlinedButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.contentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    LabButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        icon = icon,
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
        LabOutlinedButton(
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
private fun PreviewLightPressed() {
    PreviewContainer {
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
private fun PreviewLightDisabled() {
    PreviewContainer {
        LabOutlinedButton(
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
private fun PreviewLightDisabledLoading() {
    PreviewContainer {
        LabOutlinedButton(
            text = "Disabled",
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
