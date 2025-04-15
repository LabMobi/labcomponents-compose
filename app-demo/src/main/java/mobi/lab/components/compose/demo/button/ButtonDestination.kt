@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.button

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
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.demo.AppTheme
import mobi.lab.components.compose.demo.R
import mobi.lab.components.compose.demo.common.LabelSwitch
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.widget.button.LabFilledButton
import mobi.lab.components.compose.widget.image.ImageSource
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
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .padding(
                        top = contentPadding.calculateTopPadding(),
                        start = contentPadding.calculateLeftPadding(LocalLayoutDirection.current) + 16.dp,
                        end = contentPadding.calculateRightPadding(LocalLayoutDirection.current) + 16.dp,
                        bottom = 0.dp
                    )
            ) {
                val buttonModifier = Modifier.padding(bottom = 4.dp)
                val placeholderIcon = ImageSource.fromRes(R.drawable.ic_placeholder16)
                val enabled = remember { mutableStateOf(true) }
                Text("Buttons", style = LabTheme.typography.headlineLarge)
                LabelSwitch(
                    modifier = Modifier.fillMaxSize(),
                    label = "Enabled state",
                    checked = enabled.value,
                    onCheckedChange = { enabled.value = !enabled.value },
                )

                SectionTitle("Filled button")
                LabFilledButton(
                    modifier = buttonModifier,
                    text = "Filled",
                    onClick = {},
                    enabled = enabled.value
                )
                LabFilledButton(
                    modifier = buttonModifier,
                    text = "Filled",
                    onClick = {},
                    enabled = enabled.value,
                    iconStart = placeholderIcon,
                )
                LabFilledButton(
                    modifier = buttonModifier,
                    text = "Filled",
                    onClick = {},
                    enabled = enabled.value,
                    iconEnd = placeholderIcon,
                )

                LabFilledButton(
                    modifier = buttonModifier,
                    text = "Filled small",
                    onClick = {},
                    enabled = enabled.value
                )
                LabFilledButton(
                    modifier = buttonModifier,
                    text = "Filled small",
                    onClick = {},
                    enabled = enabled.value,
                    iconStart = placeholderIcon,
                )
                LabFilledButton(
                    modifier = buttonModifier,
                    text = "Filled small",
                    onClick = {},
                    enabled = enabled.value,
                    iconEnd = placeholderIcon,
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
