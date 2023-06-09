// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0-beta03" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id ("com.google.dagger.hilt.android") version "2.46.1" apply false
}
buildscript {
    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.46.1")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
    }
}
apply {"dagger.hilt.android.plugin"}