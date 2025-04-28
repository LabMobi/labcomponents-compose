@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.demo.AppTheme
import mobi.lab.components.compose.demo.R
import mobi.lab.components.compose.demo.common.LightDarkModeMenu
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.widget.progress.LabIndeterminateCircularIndicator
import mobi.lab.components.compose.widget.scaffold.LabScaffold
import mobi.lab.components.compose.widget.topappbar.LabTopAppBar
import mobi.lab.components.compose.widget.topappbar.upNavConfig

@Composable
fun ProgressDestination(onNavigateUp: () -> Unit, onToggleLightDarkModeClicked: () -> Unit) {
    AppTheme {
        LabScaffold(
            topBar = {
                LabTopAppBar(
                    stringResource(R.string.title_progress),
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
                Progress()
            }
        }
    }
}

@Composable
private fun Progress() {
    SectionTitle(stringResource(R.string.text_indeterminate_progress))
    LabIndeterminateCircularIndicator()
    LabIndeterminateCircularIndicator(modifier = Modifier.size(40.dp))
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
        ProgressDestination(
            onNavigateUp = {},
            onToggleLightDarkModeClicked = { }
        )
    }
}
