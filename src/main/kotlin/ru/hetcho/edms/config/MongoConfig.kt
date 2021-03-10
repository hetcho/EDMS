package ru.hetcho.edms.config

import com.mongodb.client.gridfs.GridFSBuckets
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory


@Configuration
class MongoConfig(private val factory: MongoDatabaseFactory) {

    @Value("\${spring.data.mongodb.gridfs.bucket}")
    private lateinit var bucketName: String

    @Bean
    fun gridFSBucket() = GridFSBuckets.create(factory.mongoDatabase, bucketName)
}