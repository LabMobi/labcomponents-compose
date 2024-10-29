@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.theme

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RippleConfiguration
import androidx.compose.material3.RippleDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
public fun noRippleConfiguration(): RippleConfiguration {
    return RippleConfiguration(
        color = Color.Companion.Unspecified,
        rippleAlpha = RippleAlpha(0f, 0f, 0f, 0f)
    )
}

@Composable
public fun coloredRippleConfiguration(color: Color): RippleConfiguration {
    return RippleConfiguration(color = color, rippleAlpha = RippleDefaults.RippleAlpha)
}
