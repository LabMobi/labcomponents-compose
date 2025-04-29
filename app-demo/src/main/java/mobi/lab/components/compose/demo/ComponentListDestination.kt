@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.demo.common.LightDarkModeMenu
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.widget.scaffold.LabScaffold
import mobi.lab.components.compose.widget.topappbar.LabTopAppBar

@Composable
fun ComponentListDestination(
    onButtonsClicked: () -> Unit,
    onColorsClicked: () -> Unit,
    onTextFieldClicked: () -> Unit,
    onTypographyClicked: () -> Unit,
    onProgressClicked: () -> Unit,
    onToggleLightDarkModeClicked: () -> Unit,
) {
    AppTheme {
        LabScaffold(
            topBar = {
                LabTopAppBar(
                    title = stringResource(R.string.app_name),
                    actions = { LightDarkModeMenu(onToggleLightDarkModeClicked) },
                )
            }
        ) { contentPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = contentPadding.calculateTopPadding(),
                        start = contentPadding.calculateLeftPadding(LocalLayoutDirection.current),
                        end = contentPadding.calculateRightPadding(LocalLayoutDirection.current),
                        bottom = 0.dp
                    )
            ) {
                item {
                    ListItem(title = stringResource(R.string.btn_buttons), onClick = onButtonsClicked)
                }
                item {
                    ListItem(title = stringResource(R.string.btn_colors), onClick = onColorsClicked)
                }
                item {
                    ListItem(title = stringResource(R.string.btn_text_fields), onClick = onTextFieldClicked)
                }
                item {
                    ListItem(title = stringResource(R.string.btn_typography), onClick = onTypographyClicked)
                }
                item {
                    ListItem(title = stringResource(R.string.btn_progress), onClick = onProgressClicked)
                }
                // Final content padding here so we get the scroll-out-of-the-screen affect
                item {
                    Spacer(Modifier.size(contentPadding.calculateBottomPadding()))
                }
            }
        }
    }
}

@Composable
private fun ListItem(title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 56.dp)
            .clickable { onClick() }
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            text = title,
            style = LabTheme.typography.bodyLarge
        )
        HorizontalDivider(modifier = Modifier.align(Alignment.BottomStart), color = LabTheme.colors.divider)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewComponentListDestination() {
    PreviewContainer {
        ComponentListDestination(
            onButtonsClicked = {},
            onColorsClicked = {},
            onTextFieldClicked = {},
            onTypographyClicked = {},
            onProgressClicked = {},
            onToggleLightDarkModeClicked = {}
        )
    }
}
