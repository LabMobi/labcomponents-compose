@file:Suppress("UnusedPrivateMember")

package mobi.lab.components.compose.util

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.flowOf
import mobi.lab.components.compose.theme.LabTheme

@Composable
public fun PreviewContainer(
    modifier: Modifier = Modifier,
    isDark: Boolean = false,
    color: Color = if (isDark) Color.Companion.Black else Color.Companion.White,
    content: @Composable BoxScope.() -> Unit
) {
    LabTheme(isDark = isDark) {
        Box(
            modifier = modifier
                .defaultMinSize(minHeight = 96.dp)
                .background(color),
            content = content
        )
    }
}

@Composable
public fun previewInteractionSourceOf(vararg interactions: Interaction): MutableInteractionSource {
    return remember {
        object : MutableInteractionSource {
            override val interactions = flowOf(*interactions)

            override suspend fun emit(interaction: Interaction) {
                // Do nothing
            }

            override fun tryEmit(interaction: Interaction): Boolean {
                // Do nothing
                return false
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewContainerPreviewLight() {
    PreviewContainer(isDark = false) {
        Text("Light container")
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewContainerPreviewDark() {
    PreviewContainer(isDark = true) {
        Text("Dark container", color = Color.Companion.White)
    }
}
