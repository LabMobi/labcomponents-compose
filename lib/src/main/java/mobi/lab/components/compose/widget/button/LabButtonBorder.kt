@file:Suppress("LongParameterList")

package mobi.lab.components.compose.widget.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import mobi.lab.components.compose.util.interactiveValue

public sealed class LabButtonBorder {

    @Immutable
    public data object Disabled : LabButtonBorder()

    @Stable
    public data class Enabled(
        private val color: Color,
        private val focusedColor: Color = color,
        private val pressedColor: Color = color,
        private val disabledColor: Color = color,
        private val width: Dp,
        private val focusedWidth: Dp = width,
        private val pressedWidth: Dp = width,
        private val disabledWidth: Dp = width
    ) : LabButtonBorder() {

        @Composable
        internal fun borderStrokeInternal(enabled: Boolean, interactionSource: InteractionSource): State<BorderStroke> {
            val widthState = width(enabled, interactionSource)
            val colorState = color(enabled, interactionSource)
            return rememberUpdatedState(BorderStroke(widthState.value, colorState.value))
        }

        @Composable
        internal fun width(enabled: Boolean, interactionSource: InteractionSource): State<Dp> {
            return interactiveValue(
                enabled = enabled,
                interactionSource = interactionSource,
                disabled = disabledWidth,
                pressed = pressedWidth,
                focused = focusedWidth,
                default = width
            )
        }

        @Composable
        internal fun color(enabled: Boolean, interactionSource: InteractionSource): State<Color> {
            return interactiveValue(
                enabled = enabled,
                interactionSource = interactionSource,
                disabled = disabledColor,
                pressed = pressedColor,
                focused = focusedColor,
                default = color
            )
        }
    }

    @Composable
    public fun borderStroke(enabled: Boolean, interactionSource: InteractionSource): State<BorderStroke>? {
        return when (this) {
            Disabled -> null
            is Enabled -> this.borderStrokeInternal(enabled, interactionSource)
        }
    }
}
