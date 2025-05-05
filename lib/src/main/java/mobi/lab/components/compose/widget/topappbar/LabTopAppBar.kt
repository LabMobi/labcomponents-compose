@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.topappbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
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
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.widget.button.LabButtonDefaults
import mobi.lab.components.compose.widget.button.LabIconButton
import mobi.lab.components.compose.widget.image.ImageSource

@Composable
public fun LabTopAppBar(
    title: String?,
    modifier: Modifier = Modifier,
    navConfig: NavConfig? = null,
    titleStyle: TextStyle = LabTopAppBarDefaults.topAppBarTitleStyle,
    colors: TopAppBarColors = LabTopAppBarDefaults.topAppBarColors(),
    actions: @Composable RowScope.() -> Unit = {},
    expandedHeight: Dp = LabTopAppBarDefaults.topAppBarExpandedHeight,
    windowInsets: WindowInsets = LabTopAppBarDefaults.topAppBarWindowInsets,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    LabTopAppBar(
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
        },
        modifier = modifier,
        navigationIcon = {
            if (navConfig != null) {
                // In the design system template, this here is an instance of the icon button
                // as per design system owner's.
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
        expandedHeight = expandedHeight,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior,
    )
}

@Composable
public fun LabTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    expandedHeight: Dp = LabTopAppBarDefaults.topAppBarExpandedHeight,
    windowInsets: WindowInsets = LabTopAppBarDefaults.topAppBarWindowInsets,
    colors: TopAppBarColors = LabTopAppBarDefaults.topAppBarColors(),
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

@Composable
public fun LabLargeTopAppBar(
    title: String?,
    modifier: Modifier = Modifier,
    navConfig: NavConfig? = null,
    titleStyle: TextStyle = LabTopAppBarDefaults.largeTopAppBarTitleStyle,
    colors: TopAppBarColors = LabTopAppBarDefaults.largeTopAppBarColors(),
    actions: @Composable RowScope.() -> Unit = {},
    collapsedHeight: Dp = LabTopAppBarDefaults.largeAppBarCollapsedHeight,
    expandedHeight: Dp = LabTopAppBarDefaults.largeAppBarExpandedHeight,
    windowInsets: WindowInsets = LabTopAppBarDefaults.largeTopAppBarWindowInsets,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    LabLargeTopAppBar(
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
        },
        modifier = modifier,
        navigationIcon = {
            if (navConfig != null) {
                // In the design system template, this here is an instance of the icon button
                // as per design system owner's.
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
        collapsedHeight = collapsedHeight,
        expandedHeight = expandedHeight,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior,
    )
}

@Composable
public fun LabLargeTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    collapsedHeight: Dp = LabTopAppBarDefaults.largeAppBarCollapsedHeight,
    expandedHeight: Dp = LabTopAppBarDefaults.largeAppBarExpandedHeight,
    windowInsets: WindowInsets = LabTopAppBarDefaults.largeTopAppBarWindowInsets,
    colors: TopAppBarColors = LabTopAppBarDefaults.largeTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    LargeTopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = actions,
        collapsedHeight = collapsedHeight,
        expandedHeight = expandedHeight,
        windowInsets = windowInsets,
        colors = colors,
        scrollBehavior = scrollBehavior,
    )
}

@Preview(showBackground = true)
@Composable
private fun LabTopAppBarLightWithTitle() {
    PreviewContainer {
        LabTopAppBar(
            title = "Title"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LabTopAppBarLightWithBackAndTitle() {
    PreviewContainer {
        LabTopAppBar(
            navConfig = upNavConfig(),
            title = "Title"
        )
    }
}

/**
 * For now, actions need to be specified via a Composable.
 */
@Preview(showBackground = true)
@Composable
private fun LabTopAppBarLightWithBackAndTitleAndAction() {
    PreviewContainer {
        LabTopAppBar(
            navConfig = upNavConfig(),
            title = "Title",
            actions = {
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Edit),
                    contentDescription = "Edit",
                    onClick = {},
                )
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Email),
                    contentDescription = "Email",
                    onClick = {},
                )
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Call),
                    contentDescription = "Call",
                    onClick = {},
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LabTopAppBarDarkWithTitle() {
    PreviewContainer(isDark = true) {
        LabTopAppBar(
            navConfig = null,
            title = "Title"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LabTopAppBarDarkWithBackAndTitle() {
    PreviewContainer(isDark = true) {
        LabTopAppBar(
            navConfig = upNavConfig(),
            title = "Title"
        )
    }
}

/**
 * For now, actions need to be specified via a Composable.
 */
@Preview(showBackground = true)
@Composable
private fun LabTopAppBarDarkWithBackAndTitleAndAction() {
    PreviewContainer(isDark = true) {
        LabTopAppBar(
            navConfig = upNavConfig(),
            title = "Title",
            actions = {
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Edit),
                    contentDescription = "Edit",
                    onClick = {},
                )
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Email),
                    contentDescription = "Email",
                    onClick = {},
                )
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Call),
                    contentDescription = "Call",
                    onClick = {},
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LabLargeTopAppBarLightWithTitle() {
    PreviewContainer {
        LabLargeTopAppBar(
            title = "Title"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LabLargeTopAppBarLightWithBackAndTitle() {
    PreviewContainer {
        LabLargeTopAppBar(
            navConfig = upNavConfig(),
            title = "Title"
        )
    }
}

/**
 * For now, actions need to be specified via a Composable.
 */
@Preview(showBackground = true)
@Composable
private fun LabLargeTopAppBarLightWithBackAndTitleAndAction() {
    PreviewContainer {
        LabLargeTopAppBar(
            navConfig = upNavConfig(),
            title = "Title",
            actions = {
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Edit),
                    contentDescription = "Edit",
                    onClick = {},
                )
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Email),
                    contentDescription = "Email",
                    onClick = {},
                )
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Call),
                    contentDescription = "Call",
                    onClick = {},
                )
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LabLargeTopAppBarDarkWithTitle() {
    PreviewContainer(isDark = true) {
        LabLargeTopAppBar(
            navConfig = null,
            title = "Title"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LabLargeTopAppBarDarkWithBackAndTitle() {
    PreviewContainer(isDark = true) {
        LabLargeTopAppBar(
            navConfig = upNavConfig(),
            title = "Title"
        )
    }
}

/**
 * For now, actions need to be specified via a Composable.
 */
@Preview(showBackground = true)
@Composable
private fun LabLargeTopAppBarDarkWithBackAndTitleAndAction() {
    PreviewContainer(isDark = true) {
        LabLargeTopAppBar(
            navConfig = upNavConfig(),
            title = "Title",
            actions = {
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Edit),
                    contentDescription = "Edit",
                    onClick = {},
                )
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Email),
                    contentDescription = "Email",
                    onClick = {},
                )
                LabIconButton(
                    icon = ImageSource.vector(Icons.Filled.Call),
                    contentDescription = "Call",
                    onClick = {},
                )
            },
        )
    }
}
