package ru.hetcho.edms.entities

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import ru.hetcho.edms.models.DocumentType
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "documents")
data class Document(
    var title: String,
    @Enumerated(EnumType.STRING)
    var type: DocumentType,
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
) : Data {
    @Id
    @GeneratedValue
    override var id: Long? = null

    @OneToMany(cascade = [CascadeType.REMOVE], orphanRemoval = true)
    val files = mutableListOf<FileInfo>()
}
