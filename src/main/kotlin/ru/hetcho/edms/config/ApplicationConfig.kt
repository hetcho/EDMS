package ru.hetcho.edms.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import ru.hetcho.edms.auditing.AuditorAwareImpl


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
class ApplicationConfig {

    @Bean
    fun auditorProvider() = AuditorAwareImpl()
}