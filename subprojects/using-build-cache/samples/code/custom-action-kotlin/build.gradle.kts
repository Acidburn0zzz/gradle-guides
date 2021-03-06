plugins {
    java
}

subprojects {
    apply(plugin = "java")
}

// tag::customAction[]
tasks.jar {
    doFirst {
        manifest {
            val classPath = listOf(":core", ":base-services").joinToString(" ") {
                project(it).tasks.getByName<Jar>("jar").archivePath.name
            }
            attributes("Class-Path" to classPath)
        }
    }
}
// end::customAction[]
