@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.topappbar

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.widget.button.LabButtonDefaults

public object LabTopAppBarDefaults {
    @Composable
    public fun topAppBarColors(): TopAppBarColors {
        return TopAppBarColors(
            containerColor = LabTheme.colors.surface,
            scrolledContainerColor = LabTheme.colors.surface,
            // In the design system template, this here is an instance of the icon button
            // as per design system owner's decision.
            navigationIconContentColor = LabButtonDefaults.iconButtonColors().contentColor,
            titleContentColor = LabTheme.colors.onSurface,
            actionIconContentColor = LabTheme.colors.primary,
        )
    }

    @Composable
    public fun largeTopAppBarColors(): TopAppBarColors {
        // Colors for now are 1:1 same as with TopAppBar
        return topAppBarColors()
    }

    public val topAppBarTitleStyle: TextStyle
        @Composable
        get() = LabTheme.typography.titleLarge

    public val largeTopAppBarTitleStyle: TextStyle
        @Composable
        get() = LabTheme.typography.headlineSmall

    public val topAppBarWindowInsets: WindowInsets
        @Composable
        get() = TopAppBarDefaults.windowInsets

    public val largeTopAppBarWindowInsets: WindowInsets
        // Insets are 1:1 same as with TopAppBar
        @Composable
        get() = topAppBarWindowInsets

    public val topAppBarExpandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight

    public val largeAppBarCollapsedHeight: Dp = TopAppBarDefaults.LargeAppBarCollapsedHeight
    public val largeAppBarExpandedHeight: Dp = TopAppBarDefaults.LargeAppBarExpandedHeight
}
