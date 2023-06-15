package xconfig

import org.gradle.kotlin.dsl.*

val javaTarget = 8

apply(plugin = "java-library")

repositories {
    mavenCentral()
}

dependencies {
    val api by configurations
    val implementation by configurations
    val runtimeOnly by configurations
    val testImplementation by configurations
    val testRuntimeOnly by configurations

    if (project.name != "xconfig-shared") {
        api(project(":xconfig-shared"))
    }

    implementation("org.jetbrains:annotations:24.0.1")
    implementation("org.slf4j:slf4j-api:2.0.7")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl:2.14.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.+")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.+")
}

extensions.apply {
    configure<JavaPluginExtension>("java") {
        // withJavadocJar() // FIXME: apparently @implNote breaks javadoc generation
        withSourcesJar()

        toolchain {
            languageVersion.set(JavaLanguageVersion.of(javaTarget))
        }
    }
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
}
