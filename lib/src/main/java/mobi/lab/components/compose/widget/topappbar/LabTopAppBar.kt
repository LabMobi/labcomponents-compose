@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.topappbar

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.R
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.widget.button.LabButtonDefaults
import mobi.lab.components.compose.widget.button.LabIconButton
import mobi.lab.components.compose.widget.image.IconFromSource
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
    // We will not use the MyToolbar as the left text button is not any official spec
    TopAppBar(
        navigationIcon = {
            if (navConfig != null) {
                // Up navigation and left buttons can't be used at the same time.
                Row {
                    IconButton(
                        onClick = navConfig.onClick,
                        colors = IconButtonDefaults.iconButtonColors().copy(
                            contentColor = colors.navigationIconContentColor,
                            containerColor = colors.containerColor,
                        )
                    ) {
                        IconFromSource(
                            source = navConfig.icon,
                            contentDescription = stringResource(R.string.lab_back),
                        )
                    }
                    Spacer(Modifier.size(16.dp))
                }
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

public object LabTopAppBarDefaults {
    @Composable
    public fun colors(): TopAppBarColors {
        return TopAppBarColors(
            // We only need this one atm:
            containerColor = LabTheme.colors.background,
            scrolledContainerColor = LabTheme.colors.background,
            navigationIconContentColor = LabTheme.colors.primary,
            titleContentColor = LabTheme.colors.onBackground,
            actionIconContentColor = LabTheme.colors.primary,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MyTopBarWithButtonComposableWithUpNavPreview() {
    PreviewContainer(Modifier.height(200.dp)) {
        LabTopAppBar(
            navConfig = upNavConfig(),
            title = "Title"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MyTopBarWithButtonComposableWithNoNavConfigPreview() {
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
private fun MyTopBarWithButtonComposableWithRightButtonPreview() {
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
