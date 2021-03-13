package ru.hetcho.edms.entities

import org.springframework.security.core.authority.SimpleGrantedAuthority
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Column(unique = true)
    var username: String,
    @Column(unique = true)
    var email: String,
    var password: String
) : Data() {

    @ManyToMany
    val roles = mutableListOf<Role>()

    val authorities
        get() = roles.flatMap { it.privileges }.map { it.name }.map { SimpleGrantedAuthority(it) }
}
