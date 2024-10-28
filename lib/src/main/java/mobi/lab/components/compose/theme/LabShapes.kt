package mobi.lab.components.compose.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

@Immutable
@Suppress("LongParameterList")
public data class LabShapes(
    val button: CornerBasedShape,
    val textField: CornerBasedShape,
) {
    public companion object {

        @Composable
        fun fromResources(dimensions: LabDimensions): LabShapes {
            return LabShapes(
                button = RoundedCornerShape(dimensions.cornerRadiusButton),
                floatingActionButton = RoundedCornerShape(16.dp),
                textField = RoundedCornerShape(dimensions.cornerRadiusShape),
                statusLabel = RoundedCornerShape(100.dp),
                card = RoundedCornerShape(dimensions.cornerRadiusShape),
                minimap = RoundedCornerShape(16.dp),
                roundButton = RoundedCornerShape(64.dp),
            )
        }
    }
}
