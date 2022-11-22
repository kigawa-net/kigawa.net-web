package net.kigawa.kweb.entity

class Theme(
    val thinTheme: String,
    val theme1: String,
    val theme2: String,
    val theme3: String,
    val accent: String,
    val plain: String,
    val baseText: String,
    val fonts: MutableList<Font>,
) {
}