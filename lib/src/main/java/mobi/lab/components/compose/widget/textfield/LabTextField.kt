package mobi.lab.components.compose.widget.textfield

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.PreviewContainer

@Composable
public fun LabTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyleLarge: TextStyle = LabTextFieldDefaults.textStyleLarge,
    textStyleSmall: TextStyle = LabTextFieldDefaults.textStyleSmall,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: String? = null,
    errorValue: String? = null,
    errorReserveSpace: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = LabTheme.shapes.textField,
    colors: TextFieldColors = LabTextFieldDefaults.colors(),
    minHeight: Dp = LabTextFieldDefaults.minHeight,
    minWidth: Dp = TextFieldDefaults.MinWidth
) {
    LabTextFieldComposable(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyleLarge = textStyleLarge,
        textStyleSmall = textStyleSmall,
        label = textOrNull(label),
        placeholder = textOrNull(placeholder),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        prefix = prefix,
        suffix = suffix,
        supportingText = supportingTextOrNull(error = errorValue, supportingText = supportingText, errorReserveSpace = errorReserveSpace),
        isError = !errorValue.isNullOrEmpty(),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
        minHeight = minHeight,
        minWidth = minWidth
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun LabTextFieldComposable(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyleLarge: TextStyle = LabTextFieldDefaults.textStyleLarge,
    textStyleSmall: TextStyle = LabTextFieldDefaults.textStyleSmall,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = LabTextFieldDefaults.shape,
    colors: TextFieldColors = LabTextFieldDefaults.colors(),
    minHeight: Dp = LabTextFieldDefaults.minHeight,
    minWidth: Dp = TextFieldDefaults.MinWidth
) {
    MaterialTheme(
        typography = MaterialTheme.typography.copy(bodyLarge = textStyleLarge, bodySmall = textStyleSmall)
    ) {
        // If color is not provided via the text style, use content color as a default
        val textColor = textStyleLarge.color.takeOrElse {
            colors.textColor(enabled, isError, interactionSource).value
        }
        val mergedTextStyle = textStyleLarge.merge(TextStyle(color = textColor))
        CompositionLocalProvider(LocalTextSelectionColors provides colors.textSelectionColors) {
            BasicTextField(
                value = value,
                modifier = modifier.defaultMinSize(minWidth = minWidth, minHeight = minHeight),
                onValueChange = onValueChange,
                enabled = enabled,
                readOnly = readOnly,
                textStyle = mergedTextStyle,
                cursorBrush = SolidColor(colors.cursorColor(isError).value),
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                interactionSource = interactionSource,
                singleLine = singleLine,
                maxLines = maxLines,
                minLines = minLines,
                decorationBox = { innerTextField ->
                    // places leading icon, text field with label and placeholder, trailing icon
                    TextFieldDefaults.DecorationBox(
                        value = value,
                        visualTransformation = visualTransformation,
                        innerTextField = innerTextField,
                        placeholder = placeholder,
                        label = label,
                        leadingIcon = leadingIcon,
                        trailingIcon = trailingIcon,
                        prefix = prefix,
                        suffix = suffix,
                        supportingText = supportingText,
                        shape = shape,
                        singleLine = singleLine,
                        enabled = enabled,
                        isError = isError,
                        interactionSource = interactionSource,
                        colors = colors,
                        container = {
                            ContainerBox(enabled, isError, interactionSource, colors, shape)
                        }
                    )
                }
            )
        }
    }
}

@Composable
public fun ContainerBox(
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource,
    colors: TextFieldColors,
    shape: Shape = TextFieldDefaults.shape,
) {
    val borderStroke = animateBorderStrokeAsState(
        enabled = enabled,
        isError = isError,
        interactionSource = interactionSource,
        colors = colors,
        focusedBorderThickness = LabTextFieldDefaults.focusedIndicatorThickness,
        unfocusedBorderThickness = LabTextFieldDefaults.unfocusedIndicatorThickness
    )
    Box(
        Modifier
            .border(borderStroke.value, shape)
            .background(colors.containerColor(enabled, isError, interactionSource).value, shape)
    )
}

@Composable
internal fun TextFieldColors.textColor(
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource
): State<Color> {
    val focused by interactionSource.collectIsFocusedAsState()

    val targetValue = when {
        !enabled -> disabledTextColor
        isError -> errorTextColor
        focused -> focusedTextColor
        else -> unfocusedTextColor
    }
    return rememberUpdatedState(targetValue)
}

@Composable
internal fun TextFieldColors.cursorColor(isError: Boolean): State<Color> {
    return rememberUpdatedState(if (isError) errorCursorColor else cursorColor)
}

@Composable
internal fun TextFieldColors.containerColor(
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource
): State<Color> {
    val focused by interactionSource.collectIsFocusedAsState()

    val targetValue = when {
        !enabled -> disabledContainerColor
        isError -> errorContainerColor
        focused -> focusedContainerColor
        else -> unfocusedContainerColor
    }
    return animateColorAsState(targetValue, tween(durationMillis = LabTextFieldDefaults.ANIMATION_DURATION_MS))
}

@Composable
internal fun TextFieldColors.indicatorColor(
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource
): State<Color> {
    val focused by interactionSource.collectIsFocusedAsState()

    val targetValue = when {
        !enabled -> disabledIndicatorColor
        isError -> errorIndicatorColor
        focused -> focusedIndicatorColor
        else -> unfocusedIndicatorColor
    }
    return if (enabled) {
        animateColorAsState(targetValue, tween(durationMillis = LabTextFieldDefaults.ANIMATION_DURATION_MS))
    } else {
        rememberUpdatedState(targetValue)
    }
}

@Composable
private fun animateBorderStrokeAsState(
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource,
    colors: TextFieldColors,
    focusedBorderThickness: Dp,
    unfocusedBorderThickness: Dp
): State<BorderStroke> {
    val focused by interactionSource.collectIsFocusedAsState()
    val indicatorColor = colors.indicatorColor(enabled, isError, interactionSource)
    val targetThickness = if (focused) focusedBorderThickness else unfocusedBorderThickness
    val animatedThickness = if (enabled) {
        animateDpAsState(targetThickness, tween(durationMillis = LabTextFieldDefaults.ANIMATION_DURATION_MS))
    } else {
        rememberUpdatedState(unfocusedBorderThickness)
    }
    return rememberUpdatedState(BorderStroke(animatedThickness.value, SolidColor(indicatorColor.value)))
}

private fun isStringEmpty(string: String?): Boolean {
    return string.isNullOrEmpty()
}

@Composable
internal fun supportingTextOrNull(error: String?, supportingText: String?, errorReserveSpace: Boolean): @Composable (() -> Unit)? {
    var value = error
    if (value.isNullOrEmpty()) {
        value = supportingText
    }
    if (value.isNullOrEmpty() && errorReserveSpace) {
        return { Text("") }
    }

    return textOrNull(value)
}

@Composable
internal fun textOrNull(value: String?): @Composable (() -> Unit)? {
    return if (value.isNullOrEmpty()) {
        null
    } else {
        { Text(text = value, style = LocalTextStyle.current, color = LocalContentColor.current) }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightTextFieldEmpty() {
    PreviewContainer {
        LabTextField(
            value = "",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkTextFieldEmpty() {
    PreviewContainer(isDark = true) {
        LabTextField(
            value = "",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightTextFieldEmptyWithLabel() {
    PreviewContainer {
        LabTextField(
            value = "",
            label = "Label here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkTextFieldEmptyWithLabel() {
    PreviewContainer(isDark = true) {
        LabTextField(
            value = "",
            label = "Label here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightTextFieldWithText() {
    PreviewContainer {
        LabTextField(
            value = "Text here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkTextFieldWithText() {
    PreviewContainer(isDark = true) {
        LabTextField(
            value = "Text here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightTextFieldWithTextAndLabel() {
    PreviewContainer {
        LabTextField(
            value = "Text here",
            label = "Label here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkTextFieldWithTextAndLabel() {
    PreviewContainer(isDark = true) {
        LabTextField(
            value = "Text here",
            label = "Label here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightTextFieldWithPlaceholder() {
    PreviewContainer {
        LabTextField(
            value = "",
            placeholder = "Placeholder here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkTextFieldWithPlaceholder() {
    PreviewContainer(isDark = true) {
        LabTextField(
            value = "",
            placeholder = "Placeholder here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightTextFieldWithPlaceholderAndLabel() {
    PreviewContainer {
        LabTextField(
            value = "",
            placeholder = "Placeholder here",
            label = "Label here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkTextFieldWithPlaceholderAndLabel() {
    PreviewContainer(isDark = true) {
        LabTextField(
            value = "",
            placeholder = "Placeholder here",
            label = "Label here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLightTextFieldWithTextAndLabelAndError() {
    PreviewContainer {
        LabTextField(
            value = "Text here",
            label = "Label here",
            errorValue = "Error here",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkTextFieldWithTextAndLabelAndError() {
    PreviewContainer(isDark = true) {
        LabTextField(
            value = "Text here",
            label = "Label here",
            errorValue = "Error here",
            onValueChange = {}
        )
    }
}
