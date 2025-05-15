@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.button

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import mobi.lab.components.compose.util.limitMaxContentWidth
import mobi.lab.components.compose.util.withAlpha
import mobi.lab.components.compose.widget.button.LabFilledButton
import mobi.lab.components.compose.widget.button.LabFilledSmallButton
import mobi.lab.components.compose.widget.button.LabIconButton
import mobi.lab.components.compose.widget.button.LabIconSmallButton
import mobi.lab.components.compose.widget.button.LabOutlinedButton
import mobi.lab.components.compose.widget.button.LabOutlinedSmallButton
import mobi.lab.components.compose.widget.button.LabTextButton
import mobi.lab.components.compose.widget.button.LabTextSmallButton
import mobi.lab.components.compose.widget.button.LabTonedButton
import mobi.lab.components.compose.widget.button.LabTonedSmallButton
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
                    val enabled = rememberSaveable { mutableStateOf(true) }
                    LabelSwitch(
                        modifier = Modifier.fillMaxSize(),
                        checked = enabled.value,
                        onCheckedChange = { enabled.value = !enabled.value },
                        label = "Enabled state",
                    )
                    FilledButtons(enabled)
                    TonedButtons(enabled)
                    OutlinedButtons(enabled)
                    TextButtons(enabled)
                    IconButtons(enabled)
                    CustomProgressButtons(enabled)
                    CustomTextStyleButtons(enabled)
                    CustomMinSizeButtons(enabled)
                    Spacer(Modifier.size(contentPadding.calculateBottomPadding()))
                }
            }
        }
    }
}

@Composable
private fun FilledButtons(enabled: MutableState<Boolean>) {
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
        text = stringResource(R.string.label_filled),
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
}

@Composable
private fun TonedButtons(enabled: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_toned_button_medium_default))
    LabTonedButton(
        text = stringResource(R.string.label_toned),
        onClick = {},
        enabled = enabled.value
    )
    LabTonedButton(
        text = stringResource(R.string.label_toned),
        onClick = {},
        enabled = enabled.value,
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabTonedButton(
        text = stringResource(R.string.label_toned),
        onClick = {},
        enabled = enabled.value,
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabTonedButton(
        text = stringResource(R.string.label_toned),
        onClick = {},
        enabled = enabled.value,
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabTonedButton(
        text = "",
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
    )
    SectionTitle(stringResource(R.string.text_toned_button_small))
    LabTonedSmallButton(
        text = stringResource(R.string.label_toned_small),
        onClick = {},
        enabled = enabled.value
    )
    LabTonedSmallButton(
        text = stringResource(R.string.label_toned_small),
        onClick = {},
        enabled = enabled.value,
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabTonedSmallButton(
        text = stringResource(R.string.label_toned_small),
        onClick = {},
        enabled = enabled.value,
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabTonedSmallButton(
        text = stringResource(R.string.label_toned_small),
        onClick = {},
        enabled = enabled.value,
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabTonedSmallButton(
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
    )
}

@Composable
private fun OutlinedButtons(enabled: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_outlined_button_medium_default))
    LabOutlinedButton(
        text = stringResource(R.string.label_outlined),
        onClick = {},
        enabled = enabled.value
    )
    LabOutlinedButton(
        text = stringResource(R.string.label_outlined),
        onClick = {},
        enabled = enabled.value,
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabOutlinedButton(
        text = stringResource(R.string.label_outlined),
        onClick = {},
        enabled = enabled.value,
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabOutlinedButton(
        text = stringResource(R.string.label_outlined),
        onClick = {},
        enabled = enabled.value,
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabOutlinedButton(
        text = "",
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
    )
    SectionTitle(stringResource(R.string.text_outlined_button_small))
    LabOutlinedSmallButton(
        text = stringResource(R.string.label_outlined_small),
        onClick = {},
        enabled = enabled.value
    )
    LabOutlinedSmallButton(
        text = stringResource(R.string.label_outlined_small),
        onClick = {},
        enabled = enabled.value,
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabOutlinedSmallButton(
        text = stringResource(R.string.label_outlined_small),
        onClick = {},
        enabled = enabled.value,
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabOutlinedSmallButton(
        text = stringResource(R.string.label_outlined_small),
        onClick = {},
        enabled = enabled.value,
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
    )
    LabOutlinedSmallButton(
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
    )
}

@Composable
private fun TextButtons(enabled: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_text_button_medium_default))
    LabTextButton(
        text = stringResource(R.string.label_text),
        onClick = {},
        enabled = enabled.value
    )
    LabTextButton(
        text = stringResource(R.string.label_text),
        onClick = {},
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
        enabled = enabled.value,
    )
    LabTextButton(
        text = stringResource(R.string.label_text),
        onClick = {},
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
        enabled = enabled.value,
    )
    LabTextButton(
        text = stringResource(R.string.label_text),
        onClick = {},
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
        enabled = enabled.value,
    )
    LabTextButton(
        text = "",
        onClick = {},
        showProgress = true,
        enabled = enabled.value,
    )
    SectionTitle(stringResource(R.string.text_text_button_small))
    LabTextSmallButton(
        text = stringResource(R.string.label_text_small),
        onClick = {},
        enabled = enabled.value
    )
    LabTextSmallButton(
        text = stringResource(R.string.label_text_small),
        onClick = {},
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
        enabled = enabled.value,
    )
    LabTextSmallButton(
        text = stringResource(R.string.label_text_small),
        onClick = {},
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
        enabled = enabled.value,
    )
    LabTextSmallButton(
        text = stringResource(R.string.label_text_small),
        onClick = {},
        iconStart = ImageSource.fromRes(R.drawable.ic_placeholder16),
        iconEnd = ImageSource.fromRes(R.drawable.ic_placeholder16),
        enabled = enabled.value,
    )
    LabTextSmallButton(
        text = "",
        onClick = {},
        showProgress = true,
        enabled = enabled.value,
    )
}

@Composable
private fun IconButtons(enabled: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_icon_button_medium_default))
    LabIconButton(
        icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
        contentDescription = stringResource(R.string.text_button_with_a_placeholder_icon),
        onClick = {},
        enabled = enabled.value
    )
    LabIconButton(
        icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
        contentDescription = stringResource(R.string.text_button_with_a_placeholder_icon),
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
    )
    SectionTitle(stringResource(R.string.text_icon_button_small))
    LabIconSmallButton(
        icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
        contentDescription = stringResource(R.string.text_button_with_a_placeholder_icon),
        onClick = {},
        enabled = enabled.value
    )
    LabIconSmallButton(
        icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
        contentDescription = stringResource(R.string.text_button_with_a_placeholder_icon),
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
    )
}

@Composable
private fun CustomProgressButtons(enabled: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_customization_custom_progress))
    LabFilledButton(
        text = stringResource(R.string.label_filled),
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
        indeterminateProgressIndicator = { modifier ->
            CircularProgressIndicator(
                modifier = modifier,
                color = LocalContentColor.current,
                strokeWidth = 3.dp,
                trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
            )
        }
    )
    LabFilledSmallButton(
        text = stringResource(R.string.label_filled),
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
        indeterminateProgressIndicator = { modifier ->
            CircularProgressIndicator(
                modifier = modifier,
                color = LocalContentColor.current,
                strokeWidth = 3.dp,
                trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
            )
        }
    )
    LabTonedButton(
        text = stringResource(R.string.label_toned),
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
        indeterminateProgressIndicator = { modifier ->
            CircularProgressIndicator(
                modifier = modifier,
                color = LocalContentColor.current,
                strokeWidth = 3.dp,
                trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
            )
        },
    )
    LabTonedSmallButton(
        text = stringResource(R.string.label_toned),
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
        indeterminateProgressIndicator = { modifier ->
            CircularProgressIndicator(
                modifier = modifier,
                color = LocalContentColor.current,
                strokeWidth = 3.dp,
                trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
            )
        },
    )
    LabOutlinedButton(
        text = stringResource(R.string.label_outlined),
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
        indeterminateProgressIndicator = { modifier ->
            CircularProgressIndicator(
                modifier = modifier,
                color = LocalContentColor.current,
                strokeWidth = 3.dp,
                trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
            )
        },
    )
    LabOutlinedSmallButton(
        text = stringResource(R.string.label_outlined),
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
        indeterminateProgressIndicator = { modifier ->
            CircularProgressIndicator(
                modifier = modifier,
                color = LocalContentColor.current,
                strokeWidth = 3.dp,
                trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
            )
        },
    )
    LabTextButton(
        text = "",
        onClick = {},
        showProgress = true,
        enabled = enabled.value,
        indeterminateProgressIndicator = { modifier ->
            CircularProgressIndicator(
                modifier = modifier,
                color = LocalContentColor.current,
                strokeWidth = 3.dp,
                trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
            )
        },
    )
    LabTextSmallButton(
        text = "",
        onClick = {},
        showProgress = true,
        enabled = enabled.value,
        indeterminateProgressIndicator = { modifier ->
            CircularProgressIndicator(
                modifier = modifier,
                color = LocalContentColor.current,
                strokeWidth = 3.dp,
                trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
            )
        },
    )
    LabIconButton(
        icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
        contentDescription = stringResource(R.string.text_button_with_a_placeholder_icon),
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
        indeterminateProgressIndicator = { modifier ->
            CircularProgressIndicator(
                modifier = modifier,
                color = LocalContentColor.current,
                strokeWidth = 3.dp,
                trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
            )
        },
    )
    LabIconSmallButton(
        icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
        contentDescription = stringResource(R.string.text_button_with_a_placeholder_icon),
        onClick = {},
        enabled = enabled.value,
        showProgress = true,
        indeterminateProgressIndicator = { modifier ->
            CircularProgressIndicator(
                modifier = modifier,
                color = LocalContentColor.current,
                strokeWidth = 3.dp,
                trackColor = LocalContentColor.current.withAlpha(LabTheme.constants.disabledAlpha),
            )
        },
    )
}

@Composable
private fun CustomTextStyleButtons(enabled: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_customization_custom_text_style))
    val customTextStyle = LabTheme.typography.labelSmall.copy(color = Color.Unspecified)
    LabFilledButton(
        text = stringResource(R.string.label_filled),
        onClick = {},
        enabled = enabled.value,
        textStyle = customTextStyle,
    )
    LabFilledSmallButton(
        text = stringResource(R.string.label_filled),
        onClick = {},
        enabled = enabled.value,
        textStyle = customTextStyle,
    )
    LabTonedButton(
        text = stringResource(R.string.label_toned),
        onClick = {},
        enabled = enabled.value,
        textStyle = customTextStyle,
    )
    LabTonedSmallButton(
        text = stringResource(R.string.label_toned),
        onClick = {},
        enabled = enabled.value,
        textStyle = customTextStyle,
    )
    LabOutlinedButton(
        text = stringResource(R.string.label_outlined),
        onClick = {},
        enabled = enabled.value,
        textStyle = customTextStyle,
    )
    LabOutlinedSmallButton(
        text = stringResource(R.string.label_outlined),
        onClick = {},
        enabled = enabled.value,
        textStyle = customTextStyle,
    )
    LabTextButton(
        text = stringResource(R.string.label_text),
        onClick = {},
        enabled = enabled.value,
        textStyle = customTextStyle,
    )
    LabTextSmallButton(
        text = stringResource(R.string.label_text_small),
        onClick = {},
        enabled = enabled.value,
        textStyle = customTextStyle,
    )
}

@Composable
private fun CustomMinSizeButtons(enabled: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_customization_custom_min_size))
    val customTextStyle = LabTheme.typography.labelSmall.copy(color = Color.Unspecified)
/*    LabFilledButton(
        text = stringResource(R.string.label_filled),
        onClick = {},
        enabled = enabled.value,
        minWidth = 60.dp,
        minHeight = 60.dp,
    )
    LabFilledSmallButton(
        text = stringResource(R.string.label_filled),
        onClick = {},
        enabled = enabled.value,
        minWidth = 28.dp,
        minHeight = 28.dp,
        textStyle = customTextStyle,
    )
    LabTonedButton(
        text = stringResource(R.string.label_toned),
        onClick = {},
        enabled = enabled.value,
        minWidth = 60.dp,
        minHeight = 60.dp,
    )
    LabTonedSmallButton(
        text = stringResource(R.string.label_toned),
        onClick = {},
        enabled = enabled.value,
        minWidth = 28.dp,
        minHeight = 28.dp,
        textStyle = customTextStyle,
    )
    LabOutlinedButton(
        text = stringResource(R.string.label_outlined),
        onClick = {},
        enabled = enabled.value,
        minWidth = 60.dp,
        minHeight = 60.dp,
    )
    LabOutlinedSmallButton(
        text = stringResource(R.string.label_outlined),
        onClick = {},
        enabled = enabled.value,
        minWidth = 28.dp,
        minHeight = 28.dp,
        textStyle = customTextStyle,
    )
    LabTextButton(
        text = stringResource(R.string.label_text),
        onClick = {},
        enabled = enabled.value,
        minWidth = 60.dp,
        minHeight = 60.dp,
    )
    LabTextSmallButton(
        text = stringResource(R.string.label_text_small),
        onClick = {},
        enabled = enabled.value,
        minWidth = 28.dp,
        minHeight = 28.dp,
        textStyle = customTextStyle,
    )
    LabIconButton(
        icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
        contentDescription = stringResource(R.string.text_button_with_a_placeholder_icon),
        onClick = {},
        enabled = enabled.value,
        minWidth = 60.dp,
        minHeight = 60.dp,
    )
    LabIconSmallButton(
        icon = ImageSource.fromRes(R.drawable.ic_placeholder16),
        contentDescription = stringResource(R.string.text_button_with_a_placeholder_icon),
        onClick = {},
        enabled = enabled.value,
        minWidth = 28.dp,
        minHeight = 28.dp,
    )*/
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
