@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.switch

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import mobi.lab.components.compose.R
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.widget.image.IconFromSource
import mobi.lab.components.compose.widget.image.ImageSource

/**
 * WARNING: LabSwitch is not yet fully specified in the design system and this experimental in nature.
 * It will change in the future.
 */
@Composable
public fun LabSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    thumbCheckedIcon: ImageSource? = ImageSource.fromRes(R.drawable.ic_switch_checked),
    thumbCheckedIconSize: Dp = LabSwitchDefaults.thumbCheckedIconSize,
    thumbUncheckedIcon: ImageSource? = ImageSource.fromRes(R.drawable.ic_switch_unchecked),
    thumbUncheckedIconSize: Dp = LabSwitchDefaults.thumbUncheckedIconSize,
    enabled: Boolean = true,
    colors: SwitchColors = LabSwitchDefaults.colors(),
    interactionSource: MutableInteractionSource? = null,
) {
    LabSwitch(
        modifier = modifier,
        checked = checked,
        onCheckedChange = onCheckedChange,
        thumbContent = createThumbContent(
            checked = checked,
            enabled = enabled,
            thumbCheckedIcon = thumbCheckedIcon,
            thumbUncheckedIcon = thumbUncheckedIcon,
            colors = colors,
            thumbCheckedIconSize = thumbCheckedIconSize,
            thumbUncheckedIconSize = thumbUncheckedIconSize,
        ),
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource
    )
}

/**
 * WARNING: LabSwitch is not yet fully specified in the design system and this experimental in nature.
 * It will change in the future.
 */
@Composable
public fun LabSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    thumbContent: (@Composable () -> Unit)?,
    enabled: Boolean = true,
    colors: SwitchColors = LabSwitchDefaults.colors(),
    interactionSource: MutableInteractionSource? = null,
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        thumbContent = thumbContent,
        enabled = enabled,
        colors = colors,
        interactionSource = interactionSource
    )
}

public fun createThumbContent(
    checked: Boolean,
    enabled: Boolean,
    thumbCheckedIcon: ImageSource?,
    thumbCheckedIconSize: Dp = LabSwitchDefaults.thumbCheckedIconSize,
    thumbUncheckedIcon: ImageSource?,
    thumbUncheckedIconSize: Dp = LabSwitchDefaults.thumbUncheckedIconSize,
    colors: SwitchColors,
): @Composable (() -> Unit)? {
    // Do we have an image for this state?
    var thumbIcon: ImageSource? = null
    var thumbIconSize: Dp = thumbCheckedIconSize
    if (checked && thumbCheckedIcon != null) {
        thumbIcon = thumbCheckedIcon
        thumbIconSize = thumbCheckedIconSize
    } else if (!checked && thumbUncheckedIcon != null) {
        thumbIcon = thumbUncheckedIcon
        thumbIconSize = thumbUncheckedIconSize
    }

    return if (thumbIcon != null) {
        // Set the image with proper state colors
        createThumbIcon(
            icon = thumbIcon,
            iconSize = thumbIconSize,
            color = getIconColorForState(checked, enabled, colors),
        )
    } else {
        // No image, return null
        null
    }
}

@Suppress("KotlinConstantConditions")
private fun getIconColorForState(
    checked: Boolean,
    enabled: Boolean,
    colors: SwitchColors
) = if (checked && enabled) {
    colors.checkedIconColor
} else if (checked && !enabled) {
    colors.disabledCheckedIconColor
} else if (!checked && enabled) {
    colors.uncheckedIconColor
} else {
    colors.disabledUncheckedIconColor
}

public fun createThumbIcon(icon: ImageSource, iconSize: Dp, color: Color): @Composable () -> Unit {
    return {
        IconFromSource(
            modifier = Modifier.size(iconSize),
            source = icon,
            color = color,
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CheckedEnabledPreview() {
    PreviewContainer {
        LabSwitch(checked = true, onCheckedChange = {}, enabled = true)
    }
}

@Preview(showBackground = true)
@Composable
private fun UncheckedEnabledPreview() {
    PreviewContainer {
        LabSwitch(checked = false, onCheckedChange = {}, enabled = true)
    }
}

@Preview(showBackground = true)
@Composable
private fun CheckedDisabledPreview() {
    PreviewContainer {
        LabSwitch(checked = true, onCheckedChange = {}, enabled = false)
    }
}

@Preview(showBackground = true)
@Composable
private fun UncheckedDisabledPreview() {
    PreviewContainer {
        LabSwitch(checked = false, onCheckedChange = {}, enabled = false)
    }
}
