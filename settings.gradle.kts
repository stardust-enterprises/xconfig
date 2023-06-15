rootProject.name = "xconfig"

rootDir.list { _, name -> name.startsWith("xconfig-")}
    ?.forEach { include(":$it") }
