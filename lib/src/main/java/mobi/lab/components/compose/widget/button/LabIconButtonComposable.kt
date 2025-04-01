@file:Suppress("LongParameterList", "UnusedPrivateMember")

package mobi.lab.components.compose.widget.button

import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
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
public fun LabIconButton(
    modifier: Modifier = Modifier,
    icon: ImageSource,
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = LabButtonDefaults.iconButtonShape,
    colors: LabButtonColors = LabButtonDefaults.iconButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.iconButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.iconButtonContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    LabButton(
        onClick = onClick,
        modifier = modifier,
        iconStart = icon,
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
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.AddCircle),
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightFocused() {
    PreviewContainer {
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.AddCircle),
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
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.AddCircle),
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
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.AddCircle),
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkEnabled() {
    PreviewContainer(isDark = true) {
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.AddCircle),
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkFocused() {
    PreviewContainer(isDark = true) {
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.AddCircle),
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
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.AddCircle),
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
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.AddCircle),
            onClick = {},
            enabled = false
        )
    }
}
