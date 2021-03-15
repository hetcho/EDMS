package ru.hetcho.edms.repositories

import com.mongodb.client.gridfs.GridFSBucket
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.gridfs.GridFsResource
import org.springframework.data.mongodb.gridfs.GridFsTemplate
import org.springframework.stereotype.Repository
import ru.hetcho.edms.entities.FileInfo
import java.io.File
import java.net.URLConnection

@Repository
class MongoRepository(
    private val db: GridFsTemplate,
    private val bucket: GridFSBucket,
) {

    fun create(file: File) = db.store(file.inputStream(), file.name, URLConnection.guessContentTypeFromName(file.name))

    fun delete(id: ObjectId) = db.delete(Query(Criteria.where("_id").`is`(id)))
    fun delete(id: String) = delete(ObjectId(id))

    fun deleteAllByIds(ids: Collection<ObjectId>) = db.delete(Query(Criteria.where("_id").`in`(ids)))
    fun deleteAll(files: Iterable<FileInfo>) = deleteAllByIds(files.map { it.objectId })

    fun findById(id: ObjectId) = db.findOne(Query(Criteria.where("_id").`is`(id)))
    fun findById(id: String) = findById(ObjectId(id))

    fun findFileById(id: ObjectId) = GridFsResource(findById(id), bucket.openDownloadStream(id))
    fun findFileById(id: String) = findFileById(ObjectId(id))
}