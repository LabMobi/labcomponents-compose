@file:Suppress("LongParameterList", "UnusedPrivateMember")
@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.button

import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.theme.noRippleConfiguration
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.util.previewInteractionSourceOf
import mobi.lab.components.compose.util.withAlpha
import mobi.lab.components.compose.widget.image.IconFromSource
import mobi.lab.components.compose.widget.image.ImageSource

@Composable
public fun LabButton(
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
    colors: LabButtonColors = LabButtonDefaults.buttonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.buttonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.contentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    LabButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource
    ) {
        Box {
            val contentAlpha = remember(showProgress) { if (showProgress) 0.0f else 1.0f }
            Row(
                modifier = Modifier.alpha(contentAlpha),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (iconStart != null) {
                    IconFromSource(
                        source = iconStart,
                        color = LocalContentColor.current,
                        contentDescription = ""
                    )
                    if (!text.isNullOrEmpty()) {
                        Spacer(modifier = Modifier.width(iconSpacing))
                    }
                }
                // Need to set the color here as TextStyle color overrides Button colors
                if (text != null) {
                    Text(
                        text = text,
                        style = LocalTextStyle.current,
                        color = LocalContentColor.current,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (iconEnd != null) {
                    if (!text.isNullOrEmpty()) {
                        Spacer(modifier = Modifier.width(iconSpacing))
                    }
                    IconFromSource(
                        source = iconEnd,
                        color = LocalContentColor.current,
                        contentDescription = ""
                    )
                }
            }
            if (showProgress) {
                val height = remember(contentPadding) {
                    LabButtonDefaults.minHeight - contentPadding.calculateBottomPadding() - contentPadding.calculateTopPadding()
                }
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(height),
                    color = LocalContentColor.current,
                    strokeWidth = LabButtonDefaults.progressStrokeWidth,
                    trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
                )
            }
        }
    }
}

@Composable
public fun LabSmallButton(
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
    colors: LabButtonColors = LabButtonDefaults.buttonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.buttonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.smallContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    LabButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource
    ) {
        Box {
            val contentAlpha = remember(showProgress) { if (showProgress) 0.0f else 1.0f }
            Row(
                modifier = Modifier.alpha(contentAlpha),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (iconStart != null) {
                    IconFromSource(
                        source = iconStart,
                        color = LocalContentColor.current,
                        contentDescription = ""
                    )
                    if (!text.isNullOrEmpty()) {
                        Spacer(modifier = Modifier.width(iconSpacing))
                    }
                }
                // Need to set the color here as TextStyle color overrides Button colors
                if (text != null) {
                    Text(
                        text = text,
                        style = LocalTextStyle.current,
                        color = LocalContentColor.current,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (iconEnd != null) {
                    if (!text.isNullOrEmpty()) {
                        Spacer(modifier = Modifier.width(iconSpacing))
                    }
                    IconFromSource(
                        source = iconEnd,
                        color = LocalContentColor.current,
                        contentDescription = ""
                    )
                }
            }
            if (showProgress) {
                val height = remember(contentPadding) {
                    LabButtonDefaults.minHeight - contentPadding.calculateBottomPadding() - contentPadding.calculateTopPadding()
                }
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(height),
                    color = LocalContentColor.current,
                    strokeWidth = LabButtonDefaults.progressStrokeWidth,
                    trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
                )
            }
        }
    }
}

@Composable
public fun LabButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = LabButtonDefaults.shape,
    colors: LabButtonColors = LabButtonDefaults.buttonColors(),
    elevation: Dp = LabButtonDefaults.elevation,
    border: LabButtonBorder = LabButtonDefaults.buttonBorder(),
    contentPadding: PaddingValues = LabButtonDefaults.contentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    CompositionLocalProvider(LocalRippleConfiguration provides noRippleConfiguration()) {
        val containerColor = colors.containerColor(enabled, interactionSource)
        val contentColor = colors.contentColor(enabled, interactionSource)
        val borderStroke = border.borderStroke(enabled, interactionSource)
        Surface(
            onClick = onClick,
            modifier = modifier.semantics { role = Role.Button },
            enabled = enabled,
            shape = shape,
            color = containerColor.value,
            contentColor = contentColor.value,
            shadowElevation = elevation,
            border = borderStroke?.value,
            interactionSource = interactionSource
        ) {
            val mergedStyle = LocalTextStyle.current.merge(LabButtonDefaults.textStyle)
            CompositionLocalProvider(
                LocalContentColor provides contentColor.value,
                LocalTextStyle provides mergedStyle,
            ) {
                Row(
                    Modifier
                        .defaultMinSize(
                            minWidth = LabButtonDefaults.minWidth,
                            minHeight = LabButtonDefaults.minHeight
                        )
                        .padding(contentPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightEnabled() {
    PreviewContainer {
        LabButton(
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
        LabButton(
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
        LabButton(
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
        LabButton(
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
        LabButton(
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
        LabButton(
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
        LabButton(
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
        LabButton(
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
        LabButton(
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
        LabButton(
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
        LabButton(
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
        LabButton(
            text = "Disabled",
            onClick = {},
            enabled = false,
            showProgress = true
        )
    }
}
