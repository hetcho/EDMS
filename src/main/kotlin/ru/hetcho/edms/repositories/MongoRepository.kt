package ru.hetcho.edms.repositories

import com.mongodb.client.gridfs.GridFSBucket
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.gridfs.GridFsResource
import org.springframework.data.mongodb.gridfs.GridFsTemplate
import org.springframework.stereotype.Repository
import java.io.File
import java.net.URLConnection
import kotlin.jvm.Throws

@Repository
class MongoRepository(
    private val db: GridFsTemplate,
    private val bucket: GridFSBucket,
) {

    fun create(file: File) = db.store(file.inputStream(), file.name, URLConnection.guessContentTypeFromName(file.name))

    @Throws(IllegalArgumentException::class)
    fun delete(id: ObjectId) = db.delete(Query(Criteria.where("_id").`is`(id)))

    @Throws(IllegalArgumentException::class)
    fun findById(id: ObjectId) = db.findOne(Query(Criteria.where("_id").`is`(id)))

    @Throws(IllegalArgumentException::class)
    fun findFileById(id: ObjectId) = GridFsResource(findById(id), bucket.openDownloadStream(id))
}