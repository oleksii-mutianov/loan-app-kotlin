package com.olxmute.loanservice.persistence.entity

import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.TypeDef
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
@TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: String? = null

    override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this === other) return true
        if (javaClass != other.javaClass) return false

        other as BaseEntity

        return (id != null) and (id == other.id)
    }

    override fun hashCode() = 42

    override fun toString() = "${javaClass.simpleName}(id=$id)"

}