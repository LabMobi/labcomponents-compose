package mobi.lab.components.compose.widget.progress

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import mobi.lab.components.compose.theme.LabTheme

public object LabIndeterminateCircularIndicatorDefaults {

    @Composable
    public fun defaultIndeterminateProgressColor(): Color {
        return LabTheme.colors.onSurface
    }
}
