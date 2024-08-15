plugins {
    alias(libs.plugins.botan.library.convention)
    alias(libs.plugins.botan.hilt.convention)
}

android { namespace = "com.githukudenis.botan.core.data" }

dependencies {
    implementation(project(AndroidModules.Core.domain))
    implementation(project(AndroidModules.Core.database))
}
