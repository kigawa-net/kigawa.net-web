package net.kigawa.kweb.entity

import java.net.URL
import javax.persistence.*

@Entity
class Service
{
    companion object
    {
        fun create(strId: String, topImg: URL, title: String, titleColor: String): Service
        {
            val service = Service()
            service.strId = strId
            service.topImg = topImg
            service.title = title
            service.titleColor = titleColor
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
    var topImg: URL? = null

    @Column
    var title: String = ""

    @Column
    var titleColor: String = ""
}