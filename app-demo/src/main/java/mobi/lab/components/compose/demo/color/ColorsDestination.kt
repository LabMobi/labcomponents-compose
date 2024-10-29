@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.color

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mobi.lab.components.compose.theme.AppTheme
import mobi.lab.components.compose.widgets.scaffold.LabScaffold
import mobi.lab.components.compose.widgets.topappbar.LabTopAppBar
import mobi.lab.components.compose.widgets.topappbar.upNavConfig

@Composable
fun ColorsDestination(onNavigateUp: () -> Unit) {
    AppTheme {
        LabScaffold(
            topBar = {
                LabTopAppBar("Colors", navConfig = upNavConfig(onNavigateUp))
            }
        ) { contentPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
            ) {
                item {
                    Text(text = "Add colors here")
                }
            }
        }
    }
}
