package mobi.lab.components.compose.util

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState

@Composable
public fun <T> interactiveValue(
    enabled: Boolean,
    interactionSource: InteractionSource,
    disabled: T,
    pressed: T,
    focused: T,
    default: T
): State<T> {
    val focusedState by interactionSource.collectIsFocusedAsState()
    val pressedState by interactionSource.collectIsPressedAsState()

    val targetValue = when {
        !enabled -> disabled
        pressedState -> pressed
        focusedState -> focused
        else -> default
    }
    return rememberUpdatedState(targetValue)
}
