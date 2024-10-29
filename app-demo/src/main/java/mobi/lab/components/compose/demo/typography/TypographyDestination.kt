@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.typography

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.widgets.scaffold.LabScaffold
import mobi.lab.components.compose.widgets.topappbar.LabTopAppBar
import mobi.lab.components.compose.widgets.topappbar.upNavConfig

@Composable
fun TypographyDestination(onNavigateUp: () -> Unit) {
    LabTheme {
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
                    Text(text = "Add text styles here")
                }
            }
        }
    }
}
