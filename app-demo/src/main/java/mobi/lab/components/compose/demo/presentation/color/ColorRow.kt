package mobi.lab.components.compose.demo.presentation.color

data class ColorRow(
    val items: List<ColorItem>
) {
    constructor(vararg items: ColorItem) : this(items.toList())
}
