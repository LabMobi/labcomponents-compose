@file:OptIn(ExperimentalMaterial3Api::class)

package mobi.lab.components.compose.demo.color

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.android.material.color.MaterialColors
import mobi.lab.components.compose.demo.common.LabelSwitch
import mobi.lab.components.compose.demo.common.LightDarkModeMenu
import mobi.lab.components.compose.theme.LabTheme
import mobi.lab.components.compose.util.interactiveValue
import mobi.lab.components.compose.widget.scaffold.LabScaffold
import mobi.lab.components.compose.widget.topappbar.LabTopAppBar
import mobi.lab.components.compose.widget.topappbar.upNavConfig

@Composable
fun ColorsDestination(onNavigateUp: () -> Unit, onToggleLightDarkModeClicked: () -> Unit) {
    LabTheme {
        LabScaffold(
            topBar = {
                LabTopAppBar("Colors", navConfig = upNavConfig(onNavigateUp), actions = { LightDarkModeMenu(onToggleLightDarkModeClicked) })
            }
        ) { contentPadding ->
            Box(
                modifier = Modifier.padding(
                    top = contentPadding.calculateTopPadding(),
                    start = contentPadding.calculateLeftPadding(LocalLayoutDirection.current),
                    end = contentPadding.calculateRightPadding(LocalLayoutDirection.current),
                    bottom = 0.dp
                )
            ) {
                Content(
                    sections = getColorSections(),
                    lastPadding = contentPadding.calculateBottomPadding()
                )
            }
        }
    }
}

@Composable
private fun Content(sections: List<ColorSection>, modifier: Modifier = Modifier, lastPadding: Dp) {
    val enabled = remember { mutableStateOf(true) }

    LazyColumn(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        item {
            Text("Colors", style = LabTheme.typography.headlineLarge)
            LabelSwitch(
                modifier = Modifier.fillMaxSize(),
                label = "Enabled state",
                checked = enabled.value,
                onCheckedChange = { enabled.value = !enabled.value },
            )
        }
        item {
            Spacer(Modifier.size(24.dp))
        }
        items(sections) { section ->
            Column {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = section.label,
                    style = LabTheme.typography.headlineSmall
                )
                for (row in section.rows) {
                    LazyRow {
                        items(row.items) { item ->
                            ColorItem(item, enabled = enabled.value)
                        }
                    }
                }
            }
        }
        // Final content padding here so we get the scroll-out-of-the-screen affect
        item {
            Spacer(Modifier.size(lastPadding + 16.dp))
        }
    }
}

@Composable
private fun ColorItem(item: ColorItem, enabled: Boolean) {
    val color = item.color
    val surface = item.surface

    val foreground: StatefulColor?
    val background: StatefulColor
    if (surface == null) {
        // If there is no separate surface, then use the main color for the entire item and don't show a foreground color
        background = color
        foreground = null
    } else {
        // If there is are 2 colors. Use surface as the background and the color value as the foreground
        background = surface
        foreground = color
    }

    val interactionSource = remember { MutableInteractionSource() }
    val backgroundColor = interactiveValue(
        enabled = enabled,
        interactionSource = interactionSource,
        disabled = background.disabled,
        pressed = background.pressed,
        focused = background.focused,
        default = background.default
    )
    val foregroundColor = interactiveValue(
        enabled = enabled,
        interactionSource = interactionSource,
        disabled = foreground?.disabled,
        pressed = foreground?.pressed,
        focused = foreground?.focused,
        default = foreground?.default
    )

    Column(
        Modifier
            .clickable(interactionSource = interactionSource, indication = null) {}
            .size(width = 160.dp, height = 96.dp)
            .background(backgroundColor.value)
            .padding(4.dp)
    ) {
        val textColor = if (MaterialColors.isColorLight(backgroundColor.value.toArgb())) {
            Color.Black
        } else {
            Color.White
        }
        Text(item.name, style = LabTheme.typography.labelLarge, color = textColor)
        Box(
            Modifier
                .fillMaxSize()
                .background(foregroundColor.value ?: Color.Transparent)
        )
    }
}

@Composable
private fun getColorSections(): List<ColorSection> {
    return listOf(
        ColorSection(
            label = "Primary",
            rows = listOf(
                ColorRow(
                    ColorItem("Primary", color = primary()),
                    ColorItem("On Primary", color = onPrimary(), surface = primary())
                ),
                ColorRow(
                    ColorItem("Primary Surface", color = primarySurface()),
                    ColorItem("On Primary Surface", color = onPrimarySurface(), surface = primarySurface())
                )
            )
        ),
        ColorSection(
            label = "Secondary",
            rows = listOf(
                ColorRow(
                    ColorItem("Secondary", color = secondary()),
                    ColorItem("On Secondary", color = onSecondary(), surface = secondary()),
                ),
                ColorRow(
                    ColorItem("Secondary Surface", color = secondarySurface()),
                    ColorItem("On Secondary Surface", color = onSecondarySurface(), surface = secondarySurface()),
                ),
            )
        ),
        ColorSection(
            label = "Error",
            rows = listOf(
                ColorRow(
                    ColorItem("Error", color = error()),
                    ColorItem("On Error", color = onError(), surface = error()),
                ),
                ColorRow(
                    ColorItem("Error Surface", color = errorSurface()),
                    ColorItem("On Error Surface", color = onErrorSurface(), surface = errorSurface()),
                ),
            )
        ),
        ColorSection(
            label = "Caution",
            rows = listOf(
                ColorRow(
                    ColorItem("Caution", color = caution()),
                    ColorItem("On Caution", color = onCaution(), surface = caution()),
                ),
                ColorRow(
                    ColorItem("Caution Surface", color = cautionSurface()),
                    ColorItem("On Caution Surface", color = onCautionSurface(), surface = cautionSurface()),
                ),
            )
        ),
        ColorSection(
            label = "Success",
            rows = listOf(
                ColorRow(
                    ColorItem("Success", color = success()),
                    ColorItem("On Success", color = onSuccess(), surface = success()),
                ),
                ColorRow(
                    ColorItem("Success Surface", color = successSurface()),
                    ColorItem("On Success Surface", color = onSuccessSurface(), surface = successSurface()),
                ),
            )
        ),
        ColorSection(
            label = "Neutral",
            rows = listOf(
                ColorRow(
                    ColorItem("Background", color = background()),
                    ColorItem("On Background", color = onBackground(), surface = background()),
                ),
                ColorRow(
                    ColorItem("Surface", color = surface()),
                    ColorItem("On Surface", color = onSurface(), surface = surface()),
                ),
                ColorRow(ColorItem("Outline", color = outline())),
                ColorRow(ColorItem("Divider", color = divider())),
            )
        ),
        ColorSection(
            label = "Neutral Variant",
            rows = listOf(
                ColorRow(
                    ColorItem("Surface Variant", color = surfaceVariant()),
                    ColorItem("On Surface Variant", color = onSurfaceVariant(), surface = surfaceVariant())
                ),
                ColorRow(ColorItem("Outline Variant", color = outlineVariant())),
                ColorRow(ColorItem("Divider Variant", color = dividerVariant())),
            )
        ),
    )
}

// Primary
@Composable
fun primary(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.primary,
        focused = LabTheme.colors.primaryFocused,
        pressed = LabTheme.colors.primaryPressed,
        disabled = LabTheme.colors.primaryDisabled
    )
}

@Composable
fun onPrimary(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onPrimary,
        disabled = LabTheme.colors.onPrimaryDisabled
    )
}

@Composable
fun primarySurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.primarySurface,
        focused = LabTheme.colors.primarySurfaceFocused,
        pressed = LabTheme.colors.primarySurfacePressed,
        disabled = LabTheme.colors.primarySurfaceDisabled
    )
}

@Composable
fun onPrimarySurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onPrimarySurface,
        disabled = LabTheme.colors.onPrimarySurfaceDisabled
    )
}

// Secondary
@Composable
fun secondary(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.secondary,
        focused = LabTheme.colors.secondaryFocused,
        pressed = LabTheme.colors.secondaryPressed,
        disabled = LabTheme.colors.secondaryDisabled
    )
}

@Composable
fun onSecondary(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onSecondary,
        disabled = LabTheme.colors.onSecondaryDisabled
    )
}

@Composable
fun secondarySurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.secondarySurface,
        focused = LabTheme.colors.secondarySurfaceFocused,
        pressed = LabTheme.colors.secondarySurfacePressed,
        disabled = LabTheme.colors.secondarySurfaceDisabled
    )
}

@Composable
fun onSecondarySurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onSecondarySurface,
        disabled = LabTheme.colors.onSecondarySurfaceDisabled
    )
}

// Error
@Composable
fun error(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.error,
        focused = LabTheme.colors.errorFocused,
        pressed = LabTheme.colors.errorPressed,
        disabled = LabTheme.colors.errorDisabled
    )
}

@Composable
fun onError(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onError,
        disabled = LabTheme.colors.onErrorDisabled
    )
}

@Composable
fun errorSurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.errorSurface,
        focused = LabTheme.colors.errorSurfaceFocused,
        pressed = LabTheme.colors.errorSurfacePressed,
        disabled = LabTheme.colors.errorSurfaceDisabled
    )
}

@Composable
fun onErrorSurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onErrorSurface,
        disabled = LabTheme.colors.onErrorSurfaceDisabled
    )
}

// Caution
@Composable
fun caution(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.caution,
        focused = LabTheme.colors.cautionFocused,
        pressed = LabTheme.colors.cautionPressed,
        disabled = LabTheme.colors.cautionDisabled
    )
}

@Composable
fun onCaution(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onCaution,
        disabled = LabTheme.colors.onCautionDisabled
    )
}

@Composable
fun cautionSurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.cautionSurface,
        focused = LabTheme.colors.cautionSurfaceFocused,
        pressed = LabTheme.colors.cautionSurfacePressed,
        disabled = LabTheme.colors.cautionSurfaceDisabled
    )
}

@Composable
fun onCautionSurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onCautionSurface,
        disabled = LabTheme.colors.onCautionSurfaceDisabled
    )
}

// Success
@Composable
fun success(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.success,
        focused = LabTheme.colors.successFocused,
        pressed = LabTheme.colors.successPressed,
        disabled = LabTheme.colors.successDisabled
    )
}

@Composable
fun onSuccess(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onSuccess,
        disabled = LabTheme.colors.onSuccessDisabled
    )
}

@Composable
fun successSurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.successSurface,
        focused = LabTheme.colors.successSurfaceFocused,
        pressed = LabTheme.colors.successSurfacePressed,
        disabled = LabTheme.colors.successSurfaceDisabled
    )
}

@Composable
fun onSuccessSurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onSuccessSurface,
        disabled = LabTheme.colors.onSuccessSurfaceDisabled
    )
}

// Neutral
@Composable
fun background(): StatefulColor {
    return StatefulColor(default = LabTheme.colors.background)
}

@Composable
fun onBackground(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onBackground,
        disabled = LabTheme.colors.onBackgroundDisabled
    )
}

@Composable
fun surface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.surface,
        focused = LabTheme.colors.surfaceFocused,
        pressed = LabTheme.colors.surfacePressed,
        disabled = LabTheme.colors.surfaceDisabled
    )
}

@Composable
fun onSurface(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onSurface,
        disabled = LabTheme.colors.onSurfaceDisabled
    )
}

@Composable
fun outline(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.outline,
        disabled = LabTheme.colors.outlineDisabled
    )
}

@Composable
fun divider(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.divider,
        disabled = LabTheme.colors.dividerDisabled
    )
}

// Neutral variant
@Composable
fun surfaceVariant(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.surfaceVariant,
        focused = LabTheme.colors.surfaceVariantFocused,
        pressed = LabTheme.colors.surfaceVariantPressed,
        disabled = LabTheme.colors.surfaceVariantDisabled
    )
}

@Composable
fun onSurfaceVariant(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.onSurfaceVariant,
        disabled = LabTheme.colors.onSurfaceVariantDisabled
    )
}

@Composable
fun outlineVariant(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.outlineVariant,
        disabled = LabTheme.colors.outlineVariantDisabled
    )
}

@Composable
fun dividerVariant(): StatefulColor {
    return StatefulColor(
        default = LabTheme.colors.dividerVariant,
        disabled = LabTheme.colors.dividerVariantDisabled
    )
}
