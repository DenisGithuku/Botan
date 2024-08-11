plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

group = "com.botan.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.android.gradle.plugin)
    implementation(libs.ksp.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("application-convention") {
            id = "botan.convention.application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("library-convention") {
            id = "botan.convention.library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("compose-application-convention") {
            id = "botan.convention.compose.application"
            implementationClass = "ComposeApplicationConventionPlugin"
        }
        register("compose-library-convention") {
            id = "botan.convention.compose.library"
            implementationClass = "ComposeLibraryConventionPlugin"
        }
        register("module-convention") {
            id = "botan.convention.module"
            implementationClass = "ModuleConventionPlugin"
        }
        register("hilt-convention"){
            id = "botan.convention.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("room-convention") {
            id = "botan.convention.room"
            implementationClass = "RoomConventionPlugin"
        }
    }
}