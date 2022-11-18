package net.kigawa.kweb.entity

import java.net.URL
import javax.persistence.*

@Entity
open class Service protected constructor(){
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    var id: Long = 0

    @Column(nullable = false, unique = true)
    var strId: String = ""

    @Column
    lateinit var topImg: URL

    @Column
    var title: String = ""

    @Column
    var subtitle: String = ""
}