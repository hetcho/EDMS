package ru.hetcho.edms.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hetcho.edms.entities.User
import java.util.*

@Repository
interface UserRepository: CrudRepository<User, Long> {

    fun findByUsername(username: String): Optional<User>
}