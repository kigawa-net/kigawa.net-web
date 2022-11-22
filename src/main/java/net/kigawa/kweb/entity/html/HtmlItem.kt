package net.kigawa.kweb.entity.html

import net.kigawa.kweb.entity.AbstractEntity
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
class HtmlItem: AbstractEntity() {
}