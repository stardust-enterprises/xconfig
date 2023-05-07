arrayOf(
    "java-library",
    "maven-publish",
    "signing",
).forEach { apply(plugin = it) }

group = "enterprises.stardust"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val testImplementation by configurations
    val testRuntimeOnly by configurations

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

extensions.apply {
    configure<BasePluginExtension>("base") {
        archivesName.set(rootProject.name + "-" + project.name)
    }

    configure<JavaPluginExtension>("java") {
        // withJavadocJar() // FIXME: apparently @implNote breaks javadoc generation
        withSourcesJar()

        toolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
    }
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
}
