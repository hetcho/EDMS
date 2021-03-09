package ru.hetcho.edms.entities

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    var username: String,
    var email: String,
    @ManyToOne
    @CreatedBy
    override val createdBy: User?,
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    override val createdAt: Date,
    @ManyToOne
    @LastModifiedDate
    override var updatedBy: User?,
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    override var updatedAt: Date
): Data {
    @Id
    @GeneratedValue
    override var id: Long? = null
}
