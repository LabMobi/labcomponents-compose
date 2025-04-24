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
    iconSize: Dp = LabButtonDefaults.iconSize,
    onClick: () -> Unit,
    enabled: Boolean = true,
    showProgress: Boolean = false,
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
        iconSize = iconSize,
        enabled = enabled,
        showProgress = showProgress,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
    )
}

@Composable
public fun LabIconSmallButton(
    modifier: Modifier = Modifier,
    icon: ImageSource,
    iconSize: Dp = LabButtonDefaults.smallIconSize,
    onClick: () -> Unit,
    enabled: Boolean = true,
    showProgress: Boolean = false,
    shape: Shape = LabButtonDefaults.iconButtonShape,
    colors: LabButtonColors = LabButtonDefaults.iconButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.iconButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.smallIconButtonContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    LabSmallButton(
        onClick = onClick,
        modifier = modifier,
        iconStart = icon,
        iconSize = iconSize,
        enabled = enabled,
        showProgress = showProgress,
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
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightEnabled() {
    PreviewContainer {
        LabIconSmallButton(
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightProgressEnabled() {
    PreviewContainer {
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
            onClick = {},
            enabled = true,
            showProgress = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightProgressEnabled() {
    PreviewContainer {
        LabIconSmallButton(
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
            onClick = {},
            enabled = true,
            showProgress = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightFocused() {
    PreviewContainer {
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
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
        LabIconSmallButton(
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
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
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
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
        LabIconSmallButton(
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
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
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightDisabled() {
    PreviewContainer {
        LabIconSmallButton(
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightProgressDisabled() {
    PreviewContainer {
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
            onClick = {},
            enabled = false,
            showProgress = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightProgressDisabled() {
    PreviewContainer {
        LabIconSmallButton(
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
            onClick = {},
            enabled = false,
            showProgress = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkEnabled() {
    PreviewContainer(isDark = true) {
        LabIconButton(
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
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
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
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
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
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
            icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
            onClick = {},
            enabled = false,
        )
    }
}
