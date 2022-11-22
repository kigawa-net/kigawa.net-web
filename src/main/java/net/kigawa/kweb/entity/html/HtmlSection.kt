package net.kigawa.kweb.entity.html

import net.kigawa.kweb.entity.AbstractEntity
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class HtmlSection: AbstractEntity() {
    @OneToMany
    val items: List<HtmlItem> = mutableListOf()
}