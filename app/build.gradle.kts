plugins {
    alias(libs.plugins.botan.application.convention)
    alias(libs.plugins.botan.compose.application.convention)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.githukudenis.botan"

    defaultConfig {
        applicationId = AndroidSdk.applicationId
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables { useSupportLibrary = true }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
}

dependencies { implementation(project(AndroidModules.Core.designsystem)) }
