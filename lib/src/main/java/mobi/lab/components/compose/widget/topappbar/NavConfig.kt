package mobi.lab.components.compose.widget.topappbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import mobi.lab.components.compose.R
import mobi.lab.components.compose.widget.image.ImageSource

public data class NavConfig(
    val icon: ImageSource,
    val contentDescription: String,
    val onClick: () -> Unit
)

@Composable
public fun upNavConfig(
    icon: ImageSource = ImageSource.vector(Icons.AutoMirrored.Filled.ArrowBack),
    contentDescription: String = stringResource(R.string.lab_back),
    onClick: () -> Unit = {}
): NavConfig {
    return NavConfig(
        icon = icon,
        contentDescription = contentDescription,
        onClick = onClick,
    )
}

@Composable
public fun navConfig(
    icon: ImageSource,
    contentDescription: String,
    onClick: () -> Unit = {}
): NavConfig {
    return NavConfig(
        icon = icon,
        contentDescription = contentDescription,
        onClick = onClick
    )
}
