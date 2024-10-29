@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.typography

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.demo.AppTheme
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.widgets.scaffold.LabScaffold
import mobi.lab.components.compose.widgets.topappbar.LabTopAppBar
import mobi.lab.components.compose.widgets.topappbar.upNavConfig

@Composable
fun TypographyDestination(onNavigateUp: () -> Unit) {
    AppTheme {
        LabScaffold(
            topBar = {
                LabTopAppBar("Typography", navConfig = upNavConfig(onNavigateUp))
            }
        ) { contentPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
            ) {
                item {
                    ListItem("Text styles", LabTheme.typography.headlineLarge)
                }
                // Display
                item {
                    ListItem("Display large", LabTheme.typography.displayLarge)
                }
                item {
                    ListItem("Display medium", LabTheme.typography.displayMedium)
                }
                item {
                    ListItem("Display small", LabTheme.typography.displaySmall)
                }
                // Headline
                item {
                    ListItem("Headline large", LabTheme.typography.headlineLarge)
                }
                item {
                    ListItem("Headline medium", LabTheme.typography.headlineMedium)
                }
                item {
                    ListItem("Headline small", LabTheme.typography.headlineSmall)
                }
                // Title
                item {
                    ListItem("Title large", LabTheme.typography.titleLarge)
                }
                item {
                    ListItem("Title medium", LabTheme.typography.titleMedium)
                }
                item {
                    ListItem("Title small", LabTheme.typography.titleSmall)
                }
                // Body
                item {
                    ListItem("Body large", LabTheme.typography.bodyLarge)
                }
                item {
                    ListItem("Body large emphasis", LabTheme.typography.bodyLargeEmphasis)
                }
                item {
                    ListItem("Body medium", LabTheme.typography.bodyMedium)
                }
                item {
                    ListItem("Body medium emphasis", LabTheme.typography.bodyMediumEmphasis)
                }
                item {
                    ListItem("Body small", LabTheme.typography.bodySmall)
                }
                item {
                    ListItem("Body small emphasis", LabTheme.typography.bodySmall)
                }
                // Label
                item {
                    ListItem("Label large", LabTheme.typography.labelLarge)
                }
                item {
                    ListItem("Label medium", LabTheme.typography.labelMedium)
                }
                item {
                    ListItem("Label small", LabTheme.typography.labelSmall)
                }
            }
        }
    }
}

@Composable
private fun ListItem(title: String, style: TextStyle, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = title,
        style = style
    )
}
