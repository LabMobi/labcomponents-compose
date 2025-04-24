@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import mobi.lab.components.compose.demo.R
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.widget.button.LabButtonDefaults
import mobi.lab.components.compose.widget.button.LabIconButton
import mobi.lab.components.compose.widget.image.ImageSource

@Composable
fun LightDarkModeMenu(onToggleLightDarkModeClicked: () -> Unit) {
    LabIconButton(
        icon = ImageSource.painter(painterResource(R.drawable.ic_invert_colors)),
        contentDescription = stringResource(R.string.text_toggle_between_light_and_dark_theme),
        onClick = onToggleLightDarkModeClicked,
        enabled = true,
        colors = LabButtonDefaults.iconButtonColors().copy(containerColor = LabTheme.colors.background)
    )
}
