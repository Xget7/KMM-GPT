plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    namespace = "xget.mc.mypartner.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "xget.mc.mypartner.android"
        minSdk = 27
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.2")
    implementation("androidx.compose.ui:ui-tooling:1.4.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.2")
    implementation("androidx.compose.foundation:foundation:1.4.2")
    implementation("androidx.compose.material:material:1.4.2")
    implementation("androidx.activity:activity-compose:1.7.1")
    implementation("androidx.lifecycle:lifecycle-process:2.6.1")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.2")

}