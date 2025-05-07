@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.switches

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.demo.R
import mobi.lab.components.compose.demo.common.LabelSwitch
import mobi.lab.components.compose.demo.common.LightDarkModeMenu
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.limitMaxContentWidth
import mobi.lab.components.compose.widget.image.ImageSource
import mobi.lab.components.compose.widget.scaffold.LabScaffold
import mobi.lab.components.compose.widget.switch.LabSwitch
import mobi.lab.components.compose.widget.topappbar.LabTopAppBar
import mobi.lab.components.compose.widget.topappbar.upNavConfig

@Composable
fun SwitchDestination(onNavigateUp: () -> Unit, onToggleLightDarkModeClicked: () -> Unit) {
    LabTheme {
        LabScaffold(
            topBar = {
                LabTopAppBar(
                    title = stringResource(R.string.title_switch),
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
                        .padding(
                            top = contentPadding.calculateTopPadding(),
                            start = contentPadding.calculateLeftPadding(LocalLayoutDirection.current) + 16.dp,
                            end = contentPadding.calculateRightPadding(LocalLayoutDirection.current) + 16.dp,
                            bottom = 0.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Spacer(Modifier.size(16.dp))
                    val enabled = rememberSaveable { mutableStateOf(true) }
                    LabelSwitch(
                        modifier = Modifier.fillMaxSize(),
                        checked = enabled.value,
                        onCheckedChange = { enabled.value = !enabled.value },
                        label = stringResource(R.string.label_enabled_state),
                    )
                    Spacer(Modifier.size(16.dp))
                    val checked1 = rememberSaveable { mutableStateOf(true) }
                    LabSwitch(
                        checked = checked1.value,
                        enabled = enabled.value,
                        onCheckedChange = { checked1.value = !checked1.value }
                    )
                    Spacer(Modifier.size(contentPadding.calculateBottomPadding()))
                }
            }
        }
    }
}

@Composable
private fun Content(modifier: Modifier = Modifier, lastPadding: Dp) {
}
