import org.quiltmc.gradle.licenser.extension.QuiltLicenserGradleExtension

plugins {
    id("org.quiltmc.gradle.licenser") version "2.+" apply false
    signing
}

allprojects {
    apply(plugin = "org.quiltmc.gradle.licenser")

    extensions.configure<QuiltLicenserGradleExtension>("license") {
        rule(rootProject.projectDir.resolve("codeformat").resolve("HEADER"))
    }
}

signing
