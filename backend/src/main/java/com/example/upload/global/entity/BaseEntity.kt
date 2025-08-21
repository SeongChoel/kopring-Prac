package com.example.upload.global.entity

import com.example.upload.standard.util.Ut
import jakarta.persistence.*

@MappedSuperclass
abstract class BaseEntity {
    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    @Column(name="id")
    private var _id: Long? = null //TODO : 나중에 고침

    var id: Long
        get() = _id ?: 0
        set(value) {
            _id = value
        }


    val modelName: String
        get() = Ut.str.lcfirst(this::class.java.simpleName)

    override fun equals(other: Any?): Boolean {
        if (other == null || javaClass != other.javaClass) return false
        other as BaseEntity

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: System.identityHashCode(this)
    }
}
