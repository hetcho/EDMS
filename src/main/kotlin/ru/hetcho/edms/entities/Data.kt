package ru.hetcho.edms.entities

import java.util.*

interface Data {
    val createdBy: User?
    val createdAt: Date
    var updatedBy: User?
    var updatedAt: Date
    var id: Long?
}