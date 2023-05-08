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
    val api by configurations
    if (project.name != "shared") {
        api(project(":shared"))
    }

    val testImplementation by configurations
    val testRuntimeOnly by configurations
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.+")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.+")
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

    configure<PublishingExtension>("publishing") {
        publications {
            create<MavenPublication>("mavenJava") {
                from(components["java"])

                groupId = "enterprises.stardust"
                artifactId = rootProject.name + "-" + project.name
                version = project.version.toString()

                pom {
                    name.set(rootProject.name + "-" + project.name)
                    url.set("https://github.com/stardust-enterprises/xconfig")

                    licenses {
                        license {
                            name.set("GNU Lesser General Public License, Version 3")
                            url.set("http://www.gnu.org/licenses/lgpl-3.0.txt")
                            distribution.set("repo")
                        }
                    }
                    developers {
                        developer {
                            id.set("xtrm")
                            name.set("xtrm")
                            email.set("oss@xtrm.me")
                        }
                    }
                }
            }
        }
    }
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
}
