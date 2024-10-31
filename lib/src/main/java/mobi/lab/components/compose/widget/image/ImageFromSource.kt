@file:Suppress("UnusedPrivateMember", "LongParameterList")

package mobi.lab.components.compose.widget.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import mobi.lab.components.compose.theme.LabTheme

@Composable
public fun IconFromSource(
    source: ImageSource,
    contentDescription: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Companion.Fit,
    color: Color = LabTheme.colors.onSurface,
) {
    ImageFromSource(
        source = source,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
        colorFilter = ColorFilter.Companion.tint(color)
    )
}

@Composable
public fun ImageFromSource(
    source: ImageSource,
    contentDescription: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Companion.Fit,
    colorFilter: ColorFilter? = null
) {
    when (source) {
        is ImageSource.Bitmap -> {
            Image(
                bitmap = source.bitmap,
                modifier = modifier,
                contentDescription = contentDescription,
                colorFilter = colorFilter,
                contentScale = contentScale,
            )
        }
        is ImageSource.Paint -> {
            Image(
                painter = source.painter,
                modifier = modifier,
                contentDescription = contentDescription,
                colorFilter = colorFilter,
                contentScale = contentScale,
            )
        }
        is ImageSource.Vector -> {
            Image(
                imageVector = source.vector,
                modifier = modifier,
                contentDescription = contentDescription,
                colorFilter = colorFilter,
                contentScale = contentScale,
            )
        }
    }
}

public sealed class ImageSource {
    public data class Paint(val painter: Painter) : ImageSource()
    public data class Bitmap(val bitmap: ImageBitmap) : ImageSource()
    public data class Vector(val vector: ImageVector) : ImageSource()

    public companion object {
        @Composable
        public fun bitmap(source: ImageBitmap): Bitmap {
            return Bitmap(source)
        }

        @Composable
        public fun vector(source: ImageVector): Vector {
            return Vector(source)
        }

        @Composable
        public fun painter(source: Painter): Paint {
            return Paint(source)
        }

        @Composable
        public fun fromRes(@DrawableRes id: Int): Paint {
            return Paint(painterResource(id))
        }
    }
}
