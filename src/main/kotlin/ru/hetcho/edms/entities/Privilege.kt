package ru.hetcho.edms.entities

import javax.persistence.Entity

@Entity
class Privilege(
    var name: String
) : Data()
