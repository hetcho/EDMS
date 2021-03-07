import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val springBootVersion: String by project
val jacksonModuleVersion: String by project

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

group = "ru.hetcho"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    fun starter(module: String, version: String = springBootVersion) = "org.springframework.boot:spring-boot-starter-$module:$version"

    // Kotlin
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    // Spring
    implementation(starter("web"))
    implementation(starter("security"))
    implementation(starter("data-jpa"))
    implementation(starter("data-mongodb"))
    implementation(starter("oauth2-client"))

    // Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleVersion")

    // Test
    testImplementation(starter("test"))
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
