package net.kigawa.kweb.entity

import java.net.URL
import javax.persistence.Column
import javax.persistence.Entity

@Entity
open class Service protected constructor(): AbstractEntity() {
    companion object {
        fun create(topImg: URL, title: String, strId: String, subtitle: String): Service {
            val service = Service()
            service.strId = strId
            service.topImg = topImg
            service.title = title
            service.subtitle = subtitle
            return service
        }
    }
    
    @Column(nullable = false, unique = true)
    open var strId: String = ""
    
    @Column
    open lateinit var topImg: URL
    
    @Column
    open var title: String = ""
    
    @Column
    open var subtitle: String = ""
}