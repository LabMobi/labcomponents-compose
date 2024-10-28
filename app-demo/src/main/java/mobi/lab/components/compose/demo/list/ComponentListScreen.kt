package mobi.lab.components.compose.demo.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mobi.lab.components.compose.demo.ui.theme.LabcomponentscomposeTheme

@Composable
fun ComponentListScreen() {
    LabcomponentscomposeTheme {
        Scaffold { contentPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
            ) {
                // TODO add items here
                item {
                    Text("Item1")
                }
                item {
                    Text("Item2")
                }
            }
        }
    }
}
