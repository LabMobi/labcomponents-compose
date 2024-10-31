package mobi.lab.components.compose.widget.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import mobi.lab.components.compose.widget.image.ImageSource

public data class NavConfig(
    val icon: ImageSource,
    val onClick: () -> Unit
)

@Composable
public fun upNavConfig(
    onClick: () -> Unit = {}
): NavConfig {
    return NavConfig(
        icon = ImageSource.vector(Icons.AutoMirrored.Filled.ArrowBack),
        onClick = onClick
    )
}

@Composable
public fun navConfig(
    icon: ImageSource,
    onClick: () -> Unit = {}
): NavConfig {
    return NavConfig(
        icon = icon,
        onClick = onClick
    )
}
