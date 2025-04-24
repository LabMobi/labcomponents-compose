@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.demo.AppTheme
import mobi.lab.components.compose.demo.R
import mobi.lab.components.compose.demo.common.LabelSwitch
import mobi.lab.components.compose.demo.common.LightDarkModeMenu
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.widget.button.LabFilledButton
import mobi.lab.components.compose.widget.button.LabFilledSmallButton
import mobi.lab.components.compose.widget.image.ImageSource
import mobi.lab.components.compose.widget.scaffold.LabScaffold
import mobi.lab.components.compose.widget.topappbar.LabTopAppBar
import mobi.lab.components.compose.widget.topappbar.upNavConfig

@Composable
fun ButtonDestination(onNavigateUp: () -> Unit, onToggleLightDarkModeClicked: () -> Unit) {
    AppTheme {
        LabScaffold(
            topBar = {
                LabTopAppBar(
                    stringResource(R.string.title_buttons),
                    navConfig = upNavConfig(onNavigateUp),
                    actions = { LightDarkModeMenu(onToggleLightDarkModeClicked) }
                )
            }
        ) { contentPadding ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .padding(
                        top = contentPadding.calculateTopPadding(),
                        start = contentPadding.calculateLeftPadding(LocalLayoutDirection.current) + 16.dp,
                        end = contentPadding.calculateRightPadding(LocalLayoutDirection.current) + 16.dp,
                        bottom = 0.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                val enabled = remember { mutableStateOf(true) }
                LabelSwitch(
                    modifier = Modifier.fillMaxSize(),
                    label = "Enabled state",
                    checked = enabled.value,
                    onCheckedChange = { enabled.value = !enabled.value },
                )

                SectionTitle(stringResource(R.string.text_filled_button_medium_default))
                LabFilledButton(
                    text = stringResource(R.string.label_filled),
                    onClick = {},
                    enabled = enabled.value
                )
                LabFilledButton(
                    text = stringResource(R.string.label_filled),
                    onClick = {},
                    enabled = enabled.value,
                    iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
                )
                LabFilledButton(
                    text = stringResource(R.string.label_filled),
                    onClick = {},
                    enabled = enabled.value,
                    iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
                )
                LabFilledButton(
                    text = stringResource(R.string.label_filled),
                    onClick = {},
                    enabled = enabled.value,
                    iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
                )
                LabFilledButton(
                    text = "",
                    onClick = {},
                    enabled = enabled.value,
                    showProgress = true,
                )
                SectionTitle(stringResource(R.string.text_filled_button_small))
                LabFilledSmallButton(
                    text = stringResource(R.string.label_filled_small),
                    onClick = {},
                    enabled = enabled.value
                )
                LabFilledSmallButton(
                    text = stringResource(R.string.label_filled_small),
                    onClick = {},
                    enabled = enabled.value,
                    iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
                )
                LabFilledSmallButton(
                    text = stringResource(R.string.label_filled_small),
                    onClick = {},
                    enabled = enabled.value,
                    iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
                )
                LabFilledSmallButton(
                    text = stringResource(R.string.label_filled_small),
                    onClick = {},
                    enabled = enabled.value,
                    iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
                    iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
                )
                LabFilledSmallButton(
                    onClick = {},
                    enabled = enabled.value,
                    showProgress = true,
                )
                Spacer(Modifier.size(contentPadding.calculateBottomPadding()))
            }
        }
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        modifier = Modifier.padding(bottom = 8.dp),
        text = text,
        style = LabTheme.typography.headlineSmall
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightButtonDestination() {
    PreviewContainer {
        ButtonDestination(
            onNavigateUp = {},
            onToggleLightDarkModeClicked = { }
        )
    }
}
