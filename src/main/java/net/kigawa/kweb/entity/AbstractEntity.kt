package net.kigawa.kweb.entity

import javax.persistence.*

@MappedSuperclass
abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    open var id: Long = 0
}