rootProject.name = "edms"

pluginManagement {

    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.springframework.boot") useModule("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
            if (requested.id.id == "io.spring.dependency-management") useModule("io.spring.gradle:dependency-management-plugin:$springDependencyManagementVersion")
            if (requested.id.namespace?.startsWith("org.jetbrains.kotlin") == true) useVersion(kotlinVersion)
        }
    }
}
