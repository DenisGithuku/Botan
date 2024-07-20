object AndroidConvention {
    // parent
    val application = "botan.convention.application"
    val library = "botan.convention.library"
    val hilt = "botan.convention.hilt"

    // child
    val module = "botan.convention.module"
    val feature = "botan.convention.feature"

    object Compose {
        const val application = "botan.convention.compose.application"
        const val library = "botan.convention.compose.library"
    }
}