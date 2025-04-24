@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.widget.progress

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import mobi.lab.components.compose.R
import mobi.lab.components.compose.util.PreviewContainer
import mobi.lab.components.compose.widget.image.IconFromSource
import mobi.lab.components.compose.widget.image.ImageSource

@Composable
public fun LabIndeterminateProgress(
    modifier: Modifier = Modifier,
    icon: ImageSource = ImageSource.fromRes(R.drawable.ic_progress_default),
    iconSize: Dp = LabIndeterminateProgressDefaults.buttonProgressSize,
    contentDescription: String = "",
) {
    val infiniteTransition = rememberInfiniteTransition(label = "rotation")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart,
        ),
        label = "rotation"
    )

    IconFromSource(
        modifier = modifier.size(iconSize).rotate(rotation),
        source = icon,
        color = LocalContentColor.current,
        contentDescription = contentDescription
    )
}

@Preview(showBackground = true)
@Composable
private fun CheckedEnabledPreview() {
    PreviewContainer {
        LabIndeterminateProgress()
    }
}
