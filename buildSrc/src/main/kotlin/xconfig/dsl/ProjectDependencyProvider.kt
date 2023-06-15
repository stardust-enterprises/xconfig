package xconfig.dsl

import org.gradle.api.artifacts.ProjectDependency
import org.gradle.kotlin.dsl.project
import javax.inject.Inject

abstract class ProjectDependencyProvider(
    @Inject private val project: org.gradle.api.Project,
) {
    operator fun invoke(moduleName: String): ProjectDependency =
        project.dependencies.project(":xconfig-$moduleName")
}
