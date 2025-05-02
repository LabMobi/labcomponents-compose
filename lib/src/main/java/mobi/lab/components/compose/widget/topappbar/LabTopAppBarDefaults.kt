@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.topappbar

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.widget.button.LabButtonDefaults

public object LabTopAppBarDefaults {
    @Composable
    public fun colors(): TopAppBarColors {
        return TopAppBarColors(
            containerColor = LabTheme.colors.surface,
            scrolledContainerColor = LabTheme.colors.surface,
            // In the design system template, this here is an instance of the icon button
            // as per Elmo's decision.
            navigationIconContentColor = LabButtonDefaults.iconButtonColors().contentColor,
            titleContentColor = LabTheme.colors.onSurface,
            actionIconContentColor = LabTheme.colors.primary,
        )
    }

    public val windowInsets: WindowInsets
        @Composable
        get() = TopAppBarDefaults.windowInsets

    public val topAppBarExpandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight
}
