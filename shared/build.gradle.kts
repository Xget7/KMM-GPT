plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            binaryOption("bundleId", "eu.baroncelli.dkmpsample.shared")

        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
                implementation("io.ktor:ktor-client-core:"+extra["ktor.version"])
                implementation("io.ktor:ktor-client-logging:"+extra["ktor.version"])
                implementation("io.ktor:ktor-client-content-negotiation:"+extra["ktor.version"])
                implementation("io.ktor:ktor-serialization-kotlinx-json:"+extra["ktor.version"])
                implementation("com.russhwolf:multiplatform-settings-no-arg:"+extra["multiplatformSettings.version"])
                //implementation("io.ktor:ktor-server-default-headers:"+extra["ktor.version"])

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("com.russhwolf:multiplatform-settings-test:"+extra["multiplatformSettings.version"])
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:"+extra["ktor.version"])
                implementation("com.squareup.sqldelight:android-driver:"+extra["sqlDelight.version"])
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
                implementation("com.squareup.sqldelight:sqlite-driver:"+extra["sqlDelight.version"])
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:"+extra["ktor.version"])
                implementation("com.squareup.sqldelight:native-driver:"+extra["sqlDelight.version"])
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "xget.mc.mypartner"
    compileSdk = 33
    defaultConfig {
        minSdk = 27
        targetSdk = 33
    }
}


sqldelight {
    database("LocalDb") {
        packageName = "xget.mc.mypartner.db"
        sourceFolders = listOf("sqldelight")
    }
}