plugins {
    alias(libs.plugins.botan.library.convention)
    alias(libs.plugins.botan.compose.library.convention)
    alias(libs.plugins.botan.hilt.convention)
    alias(libs.plugins.compose.compiler)
}

android { namespace = "com.githukudenis.botan.core.design_system" }

dependencies {}
