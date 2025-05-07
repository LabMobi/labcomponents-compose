@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.switch

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwitchColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import mobi.lab.components.compose.theme.LabTheme

public object LabSwitchDefaults {
    @Composable
    public fun colors(): SwitchColors {
        return SwitchColors(
            // TODO MW-111: Focused color? Pressed color?
            checkedThumbColor = LabTheme.colors.surface,
            checkedTrackColor = LabTheme.colors.secondary,
            checkedBorderColor = LabTheme.colors.secondary,
            checkedIconColor = LabTheme.colors.onBackground,
            // TODO: MW-111: InverseSurface color?
            uncheckedThumbColor = LabTheme.colors.onBackground,
            // TODO MW-111: Discuss with Elmo / Liisi
            uncheckedTrackColor = Color.Transparent,
            uncheckedBorderColor = LabTheme.colors.outlineVariant,
            uncheckedIconColor = LabTheme.colors.surface,
            disabledCheckedThumbColor = LabTheme.colors.surface,
            disabledCheckedTrackColor = LabTheme.colors.secondaryDisabled,
            // TODO MW-111: Discuss with Elmo / Liisi
            // If this is not transparent then border and thumb colors are merged and border is darker
            disabledCheckedBorderColor = Color.Transparent,
            // TODO MW-111: inverseOnSurface?
            disabledCheckedIconColor = LabTheme.colors.onSurfaceDisabled,
            disabledUncheckedThumbColor = LabTheme.colors.onSurfaceDisabled,
            disabledUncheckedTrackColor = LabTheme.colors.surfaceDisabled,
            disabledUncheckedBorderColor = LabTheme.colors.outlineVariantDisabled,
            disabledUncheckedIconColor = LabTheme.colors.surfaceDisabled,
        )
    }
}
