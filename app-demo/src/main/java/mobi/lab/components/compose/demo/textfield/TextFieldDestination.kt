@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mobi.lab.components.compose.demo.AppTheme
import mobi.lab.components.compose.demo.R
import mobi.lab.components.compose.demo.common.LabelSwitch
import mobi.lab.components.compose.demo.common.LightDarkModeMenu
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.util.limitMaxContentWidth
import mobi.lab.components.compose.widget.image.ImageSource
import mobi.lab.components.compose.widget.scaffold.LabScaffold
import mobi.lab.components.compose.widget.textfield.LabTextField
import mobi.lab.components.compose.widget.topappbar.LabTopAppBar
import mobi.lab.components.compose.widget.topappbar.upNavConfig

@Composable
fun TextFieldDestination(onNavigateUp: () -> Unit, onToggleLightDarkModeClicked: () -> Unit) {
    AppTheme {
        LabScaffold(
            topBar = {
                LabTopAppBar(
                    stringResource(R.string.title_text_fields),
                    navConfig = upNavConfig(onNavigateUp),
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
                        .imePadding()
                        .verticalScroll(rememberScrollState())
                        .fillMaxSize()
                        .padding(
                            top = contentPadding.calculateTopPadding(),
                            start = contentPadding.calculateLeftPadding(LocalLayoutDirection.current) + 16.dp,
                            end = contentPadding.calculateRightPadding(LocalLayoutDirection.current) + 16.dp,
                            bottom = 0.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    val enabled = rememberSaveable { mutableStateOf(true) }
                    val showError = rememberSaveable { mutableStateOf(false) }
                    val singleLine = rememberSaveable { mutableStateOf(true) }
                    val errorText = if (showError.value) {
                        stringResource(R.string.text_error_here)
                    } else {
                        null
                    }
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        LabelSwitch(
                            label = stringResource(R.string.label_enabled_state),
                            checked = enabled.value,
                            onCheckedChange = { enabled.value = !enabled.value },
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        LabelSwitch(
                            label = stringResource(R.string.label_show_error),
                            checked = showError.value,
                            onCheckedChange = { showError.value = !showError.value },
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        LabelSwitch(
                            label = stringResource(R.string.label_single_line),
                            checked = singleLine.value,
                            onCheckedChange = { singleLine.value = !singleLine.value },
                        )
                    }
                    LabelText(enabled, errorText, singleLine)
                    InputText(enabled, errorText, singleLine)
                    PlaceholderText(enabled, errorText, singleLine)
                    Custom(enabled, errorText, singleLine)
                    Spacer(Modifier.size(contentPadding.calculateBottomPadding()))
                }
            }
        }
    }
}

@Composable
fun LabelText(enabled: MutableState<Boolean>, errorText: String?, singleLine: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_label_text))
    var textLabel1: String by rememberSaveable { mutableStateOf("") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textLabel1,
        label = stringResource(R.string.label_label),
        onValueChange = { textLabel1 = it },
        enabled = enabled.value,
        supportingText = stringResource(R.string.text_supporting_text),
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    var textLabel2: String by rememberSaveable { mutableStateOf("") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textLabel2,
        label = stringResource(R.string.label_label),
        leadingIcon = ImageSource.fromRes(R.drawable.ic_search),
        supportingText = stringResource(R.string.text_supporting_text),
        onValueChange = { textLabel2 = it },
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    var textLabel3: String by rememberSaveable { mutableStateOf("") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textLabel3,
        label = stringResource(R.string.label_label),
        trailingIcon = ImageSource.fromRes(R.drawable.ic_cancel),
        trailingIconContentDescription = stringResource(R.string.label_clear),
        onTrailingIconClick = {
            textLabel3 = ""
        },
        supportingText = stringResource(R.string.text_supporting_text),
        onValueChange = { textLabel3 = it },
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    var textLabel4: String by rememberSaveable { mutableStateOf("") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textLabel4,
        label = stringResource(R.string.label_label),
        leadingIcon = ImageSource.fromRes(R.drawable.ic_search),
        trailingIcon = ImageSource.fromRes(R.drawable.ic_cancel),
        trailingIconContentDescription = stringResource(R.string.label_clear),
        onTrailingIconClick = { textLabel4 = "" },
        supportingText = stringResource(R.string.text_supporting_text),
        onValueChange = { textLabel4 = it },
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
}

@Composable
fun InputText(enabled: MutableState<Boolean>, errorText: String?, singleLine: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_input_text))
    var textInput1: String by rememberSaveable { mutableStateOf("Input") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textInput1,
        label = stringResource(R.string.label_label),
        onValueChange = { textInput1 = it },
        enabled = enabled.value,
        supportingText = stringResource(R.string.text_supporting_text),
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    var textInput2: String by rememberSaveable { mutableStateOf("Input") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textInput2,
        label = stringResource(R.string.label_label),
        leadingIcon = ImageSource.fromRes(R.drawable.ic_search),
        supportingText = stringResource(R.string.text_supporting_text),
        onValueChange = { textInput2 = it },
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    var textInput3: String by rememberSaveable { mutableStateOf("Input") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textInput3,
        label = stringResource(R.string.label_label),
        trailingIcon = ImageSource.fromRes(R.drawable.ic_cancel),
        trailingIconContentDescription = stringResource(R.string.label_clear),
        onTrailingIconClick = { textInput3 = "" },
        supportingText = stringResource(R.string.text_supporting_text),
        onValueChange = { textInput3 = it },
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    var textInput4: String by rememberSaveable { mutableStateOf("Input") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textInput4,
        label = stringResource(R.string.label_label),
        leadingIcon = ImageSource.fromRes(R.drawable.ic_search),
        trailingIcon = ImageSource.fromRes(R.drawable.ic_cancel),
        trailingIconContentDescription = stringResource(R.string.label_clear),
        onTrailingIconClick = { textInput4 = "" },
        supportingText = stringResource(R.string.text_supporting_text),
        onValueChange = { textInput4 = it },
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
}

@Composable
fun PlaceholderText(enabled: MutableState<Boolean>, errorText: String?, singleLine: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_placeholder_text))
    var textPlaceholder1: String by rememberSaveable { mutableStateOf("") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textPlaceholder1,
        placeholder = stringResource(R.string.label_placeholder),
        onValueChange = { textPlaceholder1 = it },
        enabled = enabled.value,
        supportingText = stringResource(R.string.text_supporting_text),
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    var textPlaceholder2: String by rememberSaveable { mutableStateOf("") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textPlaceholder2,
        placeholder = stringResource(R.string.label_placeholder),
        leadingIcon = ImageSource.fromRes(R.drawable.ic_search),
        supportingText = stringResource(R.string.text_supporting_text),
        onValueChange = { textPlaceholder2 = it },
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    var textPlaceholder3: String by rememberSaveable { mutableStateOf("") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textPlaceholder3,
        placeholder = stringResource(R.string.label_placeholder),
        trailingIcon = ImageSource.fromRes(R.drawable.ic_cancel),
        trailingIconContentDescription = stringResource(R.string.label_clear),
        onTrailingIconClick = { textPlaceholder3 = "" },
        supportingText = stringResource(R.string.text_supporting_text),
        onValueChange = { textPlaceholder3 = it },
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    var textPlaceholder4: String by rememberSaveable { mutableStateOf("") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textPlaceholder4,
        placeholder = stringResource(R.string.label_placeholder),
        leadingIcon = ImageSource.fromRes(R.drawable.ic_search),
        trailingIcon = ImageSource.fromRes(R.drawable.ic_cancel),
        trailingIconContentDescription = stringResource(R.string.label_clear),
        onTrailingIconClick = { textPlaceholder4 = "" },
        supportingText = stringResource(R.string.text_supporting_text),
        onValueChange = { textPlaceholder4 = it },
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
}

@Composable
fun Custom(enabled: MutableState<Boolean>, errorText: String?, singleLine: MutableState<Boolean>) {
    SectionTitle(stringResource(R.string.text_custom_both_icons_clickable))
    var textCustom1: String by rememberSaveable { mutableStateOf("") }
    LabTextField(
        modifier = Modifier.fillMaxWidth(),
        value = textCustom1,
        leadingIcon = ImageSource.fromRes(R.drawable.ic_search),
        leadingIconContentDescription = stringResource(R.string.text_generate_content),
        onLeadingIconClick = { textCustom1 = randomBookName() },
        trailingIcon = ImageSource.fromRes(R.drawable.ic_cancel),
        trailingIconContentDescription = stringResource(R.string.label_clear),
        onTrailingIconClick = { textCustom1 = "" },
        onValueChange = { textCustom1 = it },
        enabled = enabled.value,
        supportingText = stringResource(R.string.text_supporting_text),
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    SectionTitle(stringResource(R.string.text_custom_autofillable_username_password))
    var textCustom2: String by rememberSaveable { mutableStateOf("") }
    LabTextField(
        modifier = Modifier
            .fillMaxWidth()
            .semantics { contentType = ContentType.EmailAddress },
        value = textCustom2,
        onValueChange = { textCustom2 = it },
        label = stringResource(R.string.label_email),
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
    )
    var textCustom3: String by rememberSaveable { mutableStateOf("") }
    var textCustom3ShowPassword by rememberSaveable { mutableStateOf(false) }
    LabTextField(
        modifier = Modifier
            .fillMaxWidth()
            .semantics { contentType = ContentType.Password },
        value = textCustom3,
        onValueChange = { textCustom3 = it },
        label = stringResource(R.string.label_password),
        trailingIcon = ImageSource.vector(Icons.Filled.Info),
        trailingIconContentDescription = stringResource(R.string.label_toggle_password_visibility),
        onTrailingIconClick = { textCustom3ShowPassword = !textCustom3ShowPassword },
        enabled = enabled.value,
        errorValue = errorText,
        errorReserveSpace = true,
        singleLine = singleLine.value,
        visualTransformation = if (textCustom3ShowPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

fun randomBookName(): String {
    return listOf(
        "Consider Phlebas",
        "The Player of Games",
        "The State of the Art",
        "Use of Weapons",
        "Excession",
        "Inversions",
        "Look to Windward",
        "Matter",
        "Surface Detail",
        "The Hydrogen Sonata",
    ).asSequence().shuffled().find { true } ?: "O_o"
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
private fun PreviewTextFieldDestination() {
    PreviewContainer {
        TextFieldDestination(
            onNavigateUp = {},
            onToggleLightDarkModeClicked = { }
        )
    }
}
