package net.kigawa.kweb.entity.html

import net.kigawa.kweb.entity.AbstractEntity
import net.kigawa.kweb.entity.Service
import javax.persistence.*

@Entity
class HtmlPage: AbstractEntity() {
    companion object {
        fun create(service: Service): HtmlPage {
            val page = HtmlPage()
            page.service = service
            return page
        }
    }
    
    @OneToOne
    lateinit var service: Service
    
    @OneToMany
    var sections: List<HtmlSection> = mutableListOf()
}