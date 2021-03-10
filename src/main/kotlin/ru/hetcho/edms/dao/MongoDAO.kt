package ru.hetcho.edms.dao

import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import ru.hetcho.edms.entities.FileInfo
import ru.hetcho.edms.repositories.MongoRepository
import java.io.File


@Service
class MongoDAO(private val repo: MongoRepository) {

    fun create(file: File) = repo.create(file)

    fun delete(id: ObjectId) = repo.delete(id)
    fun delete(id: String) = repo.delete(ObjectId(id))

    fun deleteAllByIds(ids: Collection<ObjectId>) = repo.deleteAllByIds(ids)

    fun deleteAll(files: Iterable<FileInfo>) = deleteAllByIds(files.map { it.objectId })

    fun findById(id: ObjectId) = repo.findById(id)
    fun findById(id: String) = repo.findById(ObjectId(id))

    fun findFileById(id: ObjectId) = repo.findFileById(id)
    fun findFileById(id: String) = repo.findFileById(ObjectId(id))
}