package xconfig

import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.create
import org.gradle.plugins.signing.SigningExtension

val developers = mapOf(
    "xtrm" to "oss@xtrm.me"
)

apply(plugin = "maven-publish")
apply(plugin = "signing")

extensions.apply {
    configure<PublishingExtension>("publishing") {
        publications {
            create<MavenPublication>("mavenJava") {
                from(components["java"])

                groupId = rootProject.group.toString()
                artifactId = rootProject.name + "-" + project.name
                version = project.version.toString()

                pom {
                    name.set(rootProject.name + "-" + project.name)
                    url.set("https://github.com/stardust-enterprises/xconfig")
                    description.set(project.description)

                    licenses {
                        license {
                            name.set("GNU Lesser General Public License, Version 3")
                            url.set("http://www.gnu.org/licenses/lgpl-3.0.txt")
                            distribution.set("repo")
                        }
                    }
                    this.developers {
                        developers.forEach { id, email ->
                            developer {
                                this.id.set(id)
                                this.email.set(email)
                            }
                        }
                    }
                }
            }.also {
                configure<SigningExtension>("signing") {
                    sign(it)
                }
            }
        }
    }
}
