package ru.hetcho.edms.entities

import javax.persistence.Entity
import javax.persistence.ManyToMany


@Entity
data class Role(
    val name: String
): Data() {

    @ManyToMany
    val privileges = mutableListOf<Privilege>()
}
