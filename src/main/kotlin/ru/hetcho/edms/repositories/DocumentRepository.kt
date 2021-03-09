package ru.hetcho.edms.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hetcho.edms.entities.Document

@Repository
interface DocumentRepository: CrudRepository<Document, Long>