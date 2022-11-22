package net.kigawa.kweb.entity

import java.net.URL
import javax.persistence.Entity

@Entity
class Font(
    val name: String = "",
    val url: URL? = null,
): AbstractEntity() {
}