@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.demo.AppTheme
import mobi.lab.components.compose.demo.R
import mobi.lab.components.compose.demo.common.LightDarkModeMenu
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.util.limitMaxContentWidth
import mobi.lab.components.compose.widget.button.LabIconButton
import mobi.lab.components.compose.widget.button.LabTextButton
import mobi.lab.components.compose.widget.image.ImageSource
import mobi.lab.components.compose.widget.scaffold.LabScaffold
import mobi.lab.components.compose.widget.topappbar.LabTopAppBar
import mobi.lab.components.compose.widget.topappbar.LabTopAppBarDefaults
import mobi.lab.components.compose.widget.topappbar.navConfig
import mobi.lab.components.compose.widget.topappbar.upNavConfig

@Composable
fun TopAppBarDestination(onNavigateUp: () -> Unit, onToggleLightDarkModeClicked: () -> Unit) {
    AppTheme {
        LabScaffold(
            topBar = {
                LabTopAppBar(
                    stringResource(R.string.title_top_app_bar),
                    navConfig = upNavConfig(
                        icon = ImageSource.vector(Icons.AutoMirrored.Filled.ArrowBack),
                        contentDescription = stringResource(R.string.btn_back),
                        onClick = onNavigateUp
                    ),
                    actions = { LightDarkModeMenu(onToggleLightDarkModeClicked) }
                )
            }
        ) { contentPadding ->
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier
                        .limitMaxContentWidth()
                        .verticalScroll(rememberScrollState())
                        .fillMaxSize()
                        .background(color = LabTheme.colors.surfaceVariant)
                        .padding(
                            top = contentPadding.calculateTopPadding(),
                            start = contentPadding.calculateLeftPadding(LocalLayoutDirection.current) + 16.dp,
                            end = contentPadding.calculateRightPadding(LocalLayoutDirection.current) + 16.dp,
                            bottom = 0.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Spacer(Modifier.size(16.dp))
                    SmallWithTitle()
                    Spacer(Modifier.size(contentPadding.calculateBottomPadding()))
                }
            }
        }
    }
}

@Composable
private fun SmallWithTitle() {
    SectionTitle(text = stringResource(R.string.text_topappbar_small_with_title))
    Text(
        modifier = Modifier.padding(bottom = 8.dp),
        text = stringResource(R.string.text_edge_to_edge_top_app_bars),
        style = LabTheme.typography.bodySmall
    )
    SectionTitle2(text = stringResource(R.string.text_topappbar_leading_and_trailing_icons))
    // Leading and trailing icons
    LabTopAppBar(
        title = stringResource(R.string.text_title),
        navConfig = navConfig(
            icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
            contentDescription = stringResource(R.string.text_navigation_icon),
            onClick = {}
        ),
        actions = {
            // The design system uses the LabIconButton here
            Row {
                LabIconButton(
                    icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    contentDescription = stringResource(R.string.text_button_1),
                    onClick = {}
                )
                LabIconButton(
                    icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    contentDescription = stringResource(R.string.text_button_2),
                    onClick = {}
                )
                LabIconButton(
                    icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    contentDescription = stringResource(R.string.text_button_3),
                    onClick = {}
                )
            }
        }
    )
    Spacer(Modifier.size(16.dp))
    SectionTitle2(text = stringResource(R.string.text_topappbar_leading_icon_and_trailing_text))
    // Leading icon and trailing text
    LabTopAppBar(
        stringResource(R.string.text_title),
        navConfig = navConfig(
            icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
            contentDescription = stringResource(R.string.text_navigation_icon),
            onClick = {}
        ),
        actions = {
            // The design system uses the LabTextButton here
            LabTextButton(
                text = stringResource(R.string.btn_enabled),
                onClick = {}
            )
        }
    )
    Spacer(Modifier.size(16.dp))
    SectionTitle2(text = stringResource(R.string.text_topappbar_leading_text_and_trailing_action))
    // Leading text and trailing action
    LabTopAppBar(
        title = {
            Text(
                color = LabTopAppBarDefaults.colors().titleContentColor,
                style = LabTopAppBarDefaults.titleStyle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = stringResource(R.string.text_title),
            )
        },
        navigationIcon = {
            // The design system uses the LabTextButton here
            LabTextButton(
                text = stringResource(R.string.btn_enabled),
                onClick = {}
            )
        },
        actions = {
            // The design system uses the LabIconButton here
            Row {
                LabIconButton(
                    icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    contentDescription = stringResource(R.string.text_button_1),
                    onClick = {}
                )
                LabIconButton(
                    icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    contentDescription = stringResource(R.string.text_button_2),
                    onClick = {}
                )
                LabIconButton(
                    icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    contentDescription = stringResource(R.string.text_button_3),
                    onClick = {}
                )
            }
        }
    )
    Spacer(Modifier.size(16.dp))
    SectionTitle2(text = stringResource(R.string.text_topappbar_leading_and_trailing_texts))
    // Leading and trailing texts
    LabTopAppBar(
        title = {
            Text(
                color = LabTopAppBarDefaults.colors().titleContentColor,
                style = LabTopAppBarDefaults.titleStyle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = stringResource(R.string.text_title),
            )
        },
        navigationIcon = {
            // The design system uses the LabTextButton here
            LabTextButton(
                text = stringResource(R.string.btn_enabled),
                onClick = {}
            )
        },
        actions = {
            // The design system uses the LabTextButton here
            LabTextButton(
                text = stringResource(R.string.btn_enabled),
                onClick = {}
            )
        }
    )
    Spacer(Modifier.size(16.dp))
    SectionTitle2(text = stringResource(R.string.text_topappbar_with_leading_icon))
    // Leading icon
    LabTopAppBar(
        title = stringResource(R.string.text_title),
        navConfig = upNavConfig(icon = ImageSource.fromRes(R.drawable.ic_placeholder16)),
    )
    Spacer(Modifier.size(16.dp))
    SectionTitle2(text = stringResource(R.string.text_topappbar_with_leading_text))
    //
    LabTopAppBar(
        title = {
            Text(
                color = LabTopAppBarDefaults.colors().titleContentColor,
                style = LabTopAppBarDefaults.titleStyle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                text = stringResource(R.string.text_title),
            )
        },
        navigationIcon = {
            LabTextButton(
                text = stringResource(R.string.btn_enabled),
                onClick = {}
            )
        }
    )
    Spacer(Modifier.size(16.dp))
    SectionTitle2(text = stringResource(R.string.text_topappbar_trailing_icons_only))
    // Trailing icons only
    LabTopAppBar(
        title = stringResource(R.string.text_title),
        actions = {
            // The design system uses the LabIconButton here
            Row {
                LabIconButton(
                    icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    contentDescription = stringResource(R.string.text_button_1),
                    onClick = {}
                )
                LabIconButton(
                    icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    contentDescription = stringResource(R.string.text_button_2),
                    onClick = {}
                )
                LabIconButton(
                    icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    contentDescription = stringResource(R.string.text_button_3),
                    onClick = {}
                )
            }
        }
    )
    Spacer(Modifier.size(16.dp))
    SectionTitle2(text = stringResource(R.string.text_topappbar_trailing_text_only))
    // Trailing text only
    LabTopAppBar(
        title = stringResource(R.string.text_title),
        actions = {
            // The design system uses the LabTextButton here
            LabTextButton(
                text = stringResource(R.string.btn_enabled),
                onClick = {}
            )
        }
    )
    Spacer(Modifier.size(16.dp))
    SectionTitle2(text = stringResource(R.string.text_topappbar_title_only))
    // Title only
    LabTopAppBar(
        title = stringResource(R.string.text_title),
    )
}

@Composable
fun SectionTitle(text: String) {
    Text(
        modifier = Modifier.padding(bottom = 8.dp),
        text = text,
        style = LabTheme.typography.headlineSmall
    )
}

@Composable
fun SectionTitle2(text: String) {
    Text(
        modifier = Modifier.padding(bottom = 8.dp),
        text = text,
        style = LabTheme.typography.titleSmall
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopAppBarDestination() {
    PreviewContainer {
        TopAppBarDestination(
            onNavigateUp = {},
            onToggleLightDarkModeClicked = { }
        )
    }
}
