import com.android.build.api.dsl.ApplicationExtension
import configuration.configureKotlinAndroid
import extensions.androidTestImplementation
import extensions.getBundle
import extensions.getLibrary
import extensions.implementation
import extensions.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.kotlin

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target){

            with(pluginManager) {
                apply("com.google.dagger.hilt.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", libs.findLibrary("androidx-hilt").get())
                add("kapt", libs.findLibrary("androidx-hilt-compiler").get())

                // robolectric tests
                add("testImplementation", libs.findLibrary("androidx-hilt-testing").get())
                add("kaptTest", libs.findLibrary("androidx-hilt-compiler").get())

                // instrumented tests
                add("androidTestImplementation", libs.findLibrary("androidx-hilt-testing").get())
                add("kaptAndroidTest", libs.findLibrary("androidx-hilt-compiler").get())
            }
        }
    }
}