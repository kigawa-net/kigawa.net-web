package net.kigawa.kweb.entity.html.item

import net.kigawa.kweb.entity.AbstractEntity
import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.OneToMany

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
open class HtmlItem : AbstractEntity() {
    @OneToMany
    val child: List<HtmlItem> = mutableListOf()
}