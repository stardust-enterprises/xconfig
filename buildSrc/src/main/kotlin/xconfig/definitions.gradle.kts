package xconfig

import org.gradle.kotlin.dsl.apply

group = "enterprises.stardust"
version = "0.0.1-SNAPSHOT"
description = "A universal configuration standard for the JVM."

apply(plugin = "base")

extensions.apply {
    configure<BasePluginExtension>("base") {
        archivesName.set(rootProject.name + "-" + project.name)
    }
}
