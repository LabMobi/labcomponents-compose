package mobi.lab.components.compose.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

/**
 * Any constants that are needed by Compose to create the UI
 */
@Immutable
public data class LabConstants(
    public val disabledAlpha: Float,
    public val maxContentWidth: Dp,
    public val buttonMediumMinWidth: Dp,
    public val buttonMediumMinHeight: Dp,
    public val buttonSmallMinWidth: Dp,
    public val buttonSmallMinHeight: Dp,
)
