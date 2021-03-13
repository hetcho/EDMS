package ru.hetcho.edms.auditing

import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import ru.hetcho.edms.entities.User
import ru.hetcho.edms.models.Principal
import java.util.*

class AuditorAwareImpl : AuditorAware<User> {

    override fun getCurrentAuditor() = Optional.ofNullable(SecurityContextHolder.getContext())
        .map(SecurityContext::getAuthentication)
        .filter(Authentication::isAuthenticated)
        .map(Authentication::getPrincipal)
        .map { (it as Principal).user }!!
}