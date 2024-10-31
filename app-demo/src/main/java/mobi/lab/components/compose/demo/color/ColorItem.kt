package mobi.lab.components.compose.demo.color

data class ColorItem(
    val name: String,
    val color: StatefulColor,
    val surface: StatefulColor? = null,
)
