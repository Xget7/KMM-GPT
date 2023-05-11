pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    plugins {
        kotlin("plugin.serialization").version(extra["kotlin.version"] as String)
        kotlin("multiplatform").version(extra["kotlin.version"] as String)
        kotlin("jvm").version(extra["kotlin.version"] as String)
        kotlin("android").version(extra["kotlin.version"] as String)
        id("com.android.application").version(extra["android.gradlePlugin"] as String)
        id("com.android.library").version(extra["android.gradlePlugin"] as String)
        id("org.jetbrains.compose").version(extra["compose.version"] as String)
        id("com.squareup.sqldelight").version(extra["sqlDelight.version"] as String)
        id("com.android.library") version "7.4.1"
        id("org.jetbrains.kotlin.android") version "1.8.0"
    }
}

rootProject.name = "MyPartner2"
include(":androidApp")
include(":desktopApp")
include(":shared")
