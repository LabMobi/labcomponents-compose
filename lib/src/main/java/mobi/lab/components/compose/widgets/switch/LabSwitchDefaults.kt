@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widgets.switch

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwitchColors
import androidx.compose.runtime.Composable
import mobi.lab.components.compose.theme.LabTheme

public object LabSwitchDefaults {
    @Composable
    public fun colors(): SwitchColors {
        return SwitchColors(
            checkedThumbColor = LabTheme.colors.onPrimary,
            checkedTrackColor = LabTheme.colors.primary,
            checkedBorderColor = LabTheme.colors.primary,
            checkedIconColor = LabTheme.colors.primary,
            uncheckedThumbColor = LabTheme.colors.outline,
            uncheckedTrackColor = LabTheme.colors.primarySurface,
            uncheckedBorderColor = LabTheme.colors.outline,
            uncheckedIconColor = LabTheme.colors.outline,
            disabledCheckedThumbColor = LabTheme.colors.onPrimaryDisabled,
            disabledCheckedTrackColor = LabTheme.colors.primaryDisabled,
            disabledCheckedBorderColor = LabTheme.colors.primaryDisabled,
            disabledCheckedIconColor = LabTheme.colors.primaryDisabled,
            disabledUncheckedThumbColor = LabTheme.colors.outlineDisabled,
            disabledUncheckedTrackColor = LabTheme.colors.primarySurfaceDisabled,
            disabledUncheckedBorderColor = LabTheme.colors.outlineDisabled,
            disabledUncheckedIconColor = LabTheme.colors.outlineDisabled,
        )
    }
}
