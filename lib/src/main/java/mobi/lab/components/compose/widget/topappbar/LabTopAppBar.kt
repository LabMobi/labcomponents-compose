@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.topappbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.widget.button.LabButtonDefaults
import mobi.lab.components.compose.widget.button.LabIconButton
import mobi.lab.components.compose.widget.image.ImageSource

@Composable
public fun LabTopAppBar(
    title: String?,
    modifier: Modifier = Modifier,
    navConfig: NavConfig? = null,
    titleStyle: TextStyle = LabTheme.typography.titleLarge,
    colors: TopAppBarColors = LabTopAppBarDefaults.colors(),
    actions: @Composable RowScope.() -> Unit = {},
) {
    LabTopAppBar(
        navigationIcon = {
            if (navConfig != null) {
                // In the design system template, this here is an instance of the icon button
                // as per Elmo's decision.
                LabIconButton(
                    icon = navConfig.icon,
                    contentDescription = navConfig.contentDescription,
                    onClick = navConfig.onClick,
                    colors = LabButtonDefaults.iconButtonColors().copy(
                        containerColor = colors.containerColor,
                        contentColor = colors.navigationIconContentColor
                    )
                )
            }
        },
        actions = actions,
        modifier = modifier,
        colors = colors,
        title = {
            if (title != null) {
                Text(
                    color = colors.titleContentColor,
                    style = titleStyle,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    text = title,
                )
            }
        }
    )
}

@Composable
public fun LabTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    expandedHeight: Dp = LabTopAppBarDefaults.topAppBarExpandedHeight,
    windowInsets: WindowInsets = LabTopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = LabTopAppBarDefaults.colors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        expandedHeight = expandedHeight,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior,
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LabTopAppBarWithButtonComposableWithUpNavPreview() {
    PreviewContainer(Modifier.height(200.dp)) {
        LabTopAppBar(
            navConfig = upNavConfig(),
            title = "Title"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LabTopAppBarWithButtonComposableWithNoNavConfigPreview() {
    PreviewContainer(Modifier.height(200.dp)) {
        LabTopAppBar(
            navConfig = null,
            title = "Title"
        )
    }
}

/**
 * For now, actions need to be specified via a Composable.
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LabTopAppBarWithButtonComposableWithRightButtonPreview() {
    PreviewContainer(Modifier.height(200.dp)) {
        LabTopAppBar(
            navConfig = null,
            title = "Title",
            actions = {
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.FavoriteBorder),
                    contentDescription = "Like",
                    onClick = {},
                    enabled = true,
                    colors = LabButtonDefaults.iconButtonColors().copy(containerColor = LabTheme.colors.background)
                )
            },
        )
    }
}
