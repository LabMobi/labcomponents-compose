@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.switch

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwitchColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.theme.LabTheme

public object LabSwitchDefaults {
    @Composable
    public fun colors(): SwitchColors {
        return SwitchColors(
            checkedThumbColor = LabTheme.colors.surface,
            checkedTrackColor = LabTheme.colors.secondary,
            checkedBorderColor = LabTheme.colors.secondary,
            checkedIconColor = LabTheme.colors.onBackground,
            uncheckedThumbColor = LabTheme.colors.onBackground,
            uncheckedTrackColor = Color.Transparent,
            uncheckedBorderColor = LabTheme.colors.outlineVariant,
            uncheckedIconColor = LabTheme.colors.surface,
            disabledCheckedThumbColor = LabTheme.colors.surface,
            disabledCheckedTrackColor = LabTheme.colors.secondaryDisabled,
            // If this is not transparent then border and thumb colors are merged and border is darker
            disabledCheckedBorderColor = Color.Transparent,
            disabledCheckedIconColor = LabTheme.colors.onSurfaceDisabled,
            disabledUncheckedThumbColor = LabTheme.colors.onSurfaceDisabled,
            disabledUncheckedTrackColor = LabTheme.colors.surfaceDisabled,
            disabledUncheckedBorderColor = LabTheme.colors.outlineVariantDisabled,
            disabledUncheckedIconColor = LabTheme.colors.surfaceDisabled,
        )
    }

    public val thumbCheckedIconSize: Dp = 24.dp
    public val thumbUncheckedIconSize: Dp = 24.dp
}
