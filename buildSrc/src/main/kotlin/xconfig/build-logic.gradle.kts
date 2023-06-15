package xconfig

import org.gradle.kotlin.dsl.apply

arrayOf(
    "xconfig.definitions",
    "xconfig.dsl",
    "xconfig.java",
    "xconfig.publish",
).forEach { apply(plugin = it) }

