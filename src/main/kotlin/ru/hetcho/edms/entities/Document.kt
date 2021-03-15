package ru.hetcho.edms.entities

import ru.hetcho.edms.models.DocumentType
import javax.persistence.*

@Entity
@Table(name = "documents")
data class Document(
    var title: String,
    @Enumerated(EnumType.STRING)
    var type: DocumentType = DocumentType.PUBLIC
) : Data() {

    @OneToMany(cascade = [CascadeType.REMOVE, CascadeType.PERSIST], orphanRemoval = true)
    val files = mutableListOf<FileInfo>()
}
