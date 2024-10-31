@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widgets.switch

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.util.PreviewContainer

@Composable
public fun LabSwitch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    thumbContent: (@Composable () -> Unit)? = null,
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

@Preview(showBackground = true)
@Composable
private fun CheckedEnabledPreview() {
    PreviewContainer(Modifier.height(200.dp)) {
        LabSwitch(checked = true, enabled = true, onCheckedChange = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun UncheckedEnabledPreview() {
    PreviewContainer(Modifier.height(200.dp)) {
        LabSwitch(checked = false, enabled = true, onCheckedChange = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun CheckedDisabledPreview() {
    PreviewContainer(Modifier.height(200.dp)) {
        LabSwitch(checked = true, enabled = false, onCheckedChange = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun UncheckedDisabledPreview() {
    PreviewContainer(Modifier.height(200.dp)) {
        LabSwitch(checked = false, enabled = false, onCheckedChange = {})
    }
}
