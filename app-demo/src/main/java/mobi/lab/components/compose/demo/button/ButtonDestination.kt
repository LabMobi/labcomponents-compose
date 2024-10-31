@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.button

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mobi.lab.components.compose.demo.AppTheme
import mobi.lab.components.compose.widget.scaffold.LabScaffold
import mobi.lab.components.compose.widget.topappbar.LabTopAppBar
import mobi.lab.components.compose.widget.topappbar.upNavConfig

@Composable
fun ButtonDestination(onNavigateUp: () -> Unit) {
    AppTheme {
        LabScaffold(
            topBar = {
                LabTopAppBar("Button", navConfig = upNavConfig(onNavigateUp))
            }
        ) { contentPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
            ) {
                item {
                    Text("Add all buttons here")
                }
            }
        }
    }
}
