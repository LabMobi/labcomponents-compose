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
import mobi.lab.components.compose.widget.button.LabButtonDefaults.DefaultButtonProgressIndicator
import mobi.lab.components.compose.widget.image.ImageSource

@Composable
public fun LabTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconStart: ImageSource? = null,
    iconEnd: ImageSource? = null,
    iconSize: Dp = LabButtonDefaults.iconSize,
    iconSpacing: Dp = LabButtonDefaults.iconSpacing,
    showProgress: Boolean = false,
    enabled: Boolean = true,
    shape: Shape = LabButtonDefaults.shape,
    colors: LabButtonColors = LabButtonDefaults.textButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.textButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.textButtonContentPaddings(
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
        indeterminateProgressIndicator = indeterminateProgressIndicator,
        interactionSource = interactionSource,
    )
}

@Composable
public fun LabTextSmallButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconStart: ImageSource? = null,
    iconEnd: ImageSource? = null,
    iconSize: Dp = LabButtonDefaults.smallIconSize,
    iconSpacing: Dp = LabButtonDefaults.iconSpacing,
    showProgress: Boolean = false,
    enabled: Boolean = true,
    shape: Shape = LabButtonDefaults.shape,
    colors: LabButtonColors = LabButtonDefaults.textButtonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.textButtonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.smallTextButtonContentPaddings(
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
        indeterminateProgressIndicator = indeterminateProgressIndicator,
        interactionSource = interactionSource,
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightEnabled() {
    PreviewContainer {
        LabTextButton(
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
        LabTextSmallButton(
            text = "S Enabled",
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightFocused() {
    PreviewContainer {
        LabTextButton(
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
        LabTextSmallButton(
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
        LabTextButton(
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
        LabTextSmallButton(
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
        LabTextButton(
            text = "M Disabled",
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSmallLightDisabled() {
    PreviewContainer {
        LabTextSmallButton(
            text = "S Disabled",
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightEnabledLoading() {
    PreviewContainer {
        LabTextButton(
            text = "",
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
        LabTextSmallButton(
            text = "",
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
        LabTextButton(
            text = "",
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
        LabTextSmallButton(
            text = "",
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
        LabTextButton(
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
        LabTextButton(
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
        LabTextButton(
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
        LabTextButton(
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
        LabTextButton(
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
        LabTextButton(
            text = "Disabled",
            onClick = {},
            enabled = false,
            showProgress = true
        )
    }
}
