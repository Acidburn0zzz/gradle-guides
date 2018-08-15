plugins {
    id("com.gradle.build-scan") version "1.15.2"
    id("org.gradle.guides.getting-started") version "0.14.0"
}

configure<org.gradle.guides.GuidesExtension> {
    repoPath = "gradle-guides/building-cpp-executables"
    mainAuthor = "Schalk Cronjé"
}

apply {
    from("gradle/cpp.gradle")
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
    if (!System.getenv("CI").isNullOrEmpty()) {
        publishAlways()
        tag("CI")
    }
}
