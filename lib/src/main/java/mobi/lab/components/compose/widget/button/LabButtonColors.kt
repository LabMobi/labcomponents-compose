package mobi.lab.components.compose.widget.button

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import mobi.lab.components.compose.util.interactiveValue

@Suppress("LongParameterList")
@Immutable
public data class LabButtonColors(
    val contentColor: Color,
    val focusedContentColor: Color,
    val pressedContentColor: Color,
    val disabledContentColor: Color,
    val containerColor: Color,
    val focusedContainerColor: Color,
    val pressedContainerColor: Color,
    val disabledContainerColor: Color,
) {

    @Composable
    public fun contentColor(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
        return interactiveValue(
            enabled = enabled,
            interactionSource = interactionSource,
            disabled = disabledContentColor,
            pressed = pressedContentColor,
            focused = focusedContentColor,
            default = contentColor
        )
    }

    @Composable
    public fun containerColor(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
        return interactiveValue(
            enabled = enabled,
            interactionSource = interactionSource,
            disabled = disabledContainerColor,
            pressed = pressedContainerColor,
            focused = focusedContainerColor,
            default = containerColor
        )
    }
}
