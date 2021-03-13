package ru.hetcho.edms.models

import ru.hetcho.edms.entities.User

class Principal(val user: User) : org.springframework.security.core.userdetails.User(user.username, user.password, user.authorities)