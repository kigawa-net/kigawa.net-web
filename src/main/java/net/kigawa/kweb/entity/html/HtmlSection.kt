package net.kigawa.kweb.entity.html

import net.kigawa.kweb.entity.AbstractEntity
import net.kigawa.kweb.entity.html.item.HtmlItem
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class HtmlSection: AbstractEntity() {
    @OneToMany
    val items: List<HtmlItem> = mutableListOf()
}