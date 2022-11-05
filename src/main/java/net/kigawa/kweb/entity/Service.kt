package net.kigawa.kweb.entity

import java.net.URL
import javax.persistence.*

@Entity
class Service
{
    companion object
    {
        fun create(topImg: URL, title: String, strId: String = ""): Service
        {
            val service = Service()
            service.strId = strId
            service.topImg = topImg
            service.title = title
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
    var description: String = ""
}