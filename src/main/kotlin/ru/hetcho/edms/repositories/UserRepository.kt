package ru.hetcho.edms.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hetcho.edms.entities.User

@Repository
interface UserRepository: CrudRepository<User, Long>