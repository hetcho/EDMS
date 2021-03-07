package ru.hetcho.edms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EdmsApplication

fun main(args: Array<String>) {
    runApplication<EdmsApplication>(*args)
}
