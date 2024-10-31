package mobi.lab.components.compose.demo.color

data class ColorRow(
    val items: List<ColorItem>
) {
    constructor(vararg items: ColorItem) : this(items.toList())
}
