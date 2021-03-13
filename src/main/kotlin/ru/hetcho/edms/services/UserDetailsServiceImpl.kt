package ru.hetcho.edms.services

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.hetcho.edms.models.Principal
import ru.hetcho.edms.repositories.UserRepository


@Service
class UserDetailsServiceImpl(private val repo: UserRepository) : UserDetailsService {

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = repo.findByUsername(username).orElseThrow { throw UsernameNotFoundException("username $username not found") }
        return Principal(user)
    }
}
