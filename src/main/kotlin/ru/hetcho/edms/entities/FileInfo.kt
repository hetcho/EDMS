package ru.hetcho.edms.entities

import org.bson.types.ObjectId
import javax.persistence.*

@Entity
@Table(name = "file_infos")
data class FileInfo(
    val filename: String,
    @Column(unique = true)
    val objectId: ObjectId,
    @ManyToOne
    val document: Document
) : Data()
