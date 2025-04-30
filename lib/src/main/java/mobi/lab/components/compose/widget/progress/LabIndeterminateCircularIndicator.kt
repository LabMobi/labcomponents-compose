@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.progress

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import mobi.lab.components.compose.R
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.widget.image.IconFromSource
import mobi.lab.components.compose.widget.image.ImageSource

@Composable
public fun LabIndeterminateCircularIndicator(
    modifier: Modifier = Modifier,
    color: Color = LabIndeterminateCircularIndicatorDefaults.defaultIndeterminateProgressColor(),
    contentDescription: String = stringResource(R.string.text_loading_please_wait),
) {
    val infiniteTransition = rememberInfiniteTransition(label = "rotation")
    val rotationProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart,
        ),
        label = "rotation"
    )

    // In order to not have a smooth rotation convert the 0..1 position to discrete rotations
    val rotationPositions: List<Float> = remember {
        // 12 discrete positions, 0f to 330f, with a rotation of 360/12 = 30 each
        List(12) { it * 30f }
    }
    val currentRotationIndex: Int = ((rotationProgress * rotationPositions.size).toInt() % rotationPositions.size)
    val currentRotation: Float = rotationPositions[currentRotationIndex]

    IconFromSource(
        modifier = modifier
            .rotate(currentRotation),
        source = ImageSource.fromRes(R.drawable.ic_progress_default),
        color = color,
        contentDescription = contentDescription
    )
}

@Preview(showBackground = true)
@Composable
private fun LabIndeterminateCircularIndicatorPreview() {
    PreviewContainer {
        LabIndeterminateCircularIndicator()
    }
}
