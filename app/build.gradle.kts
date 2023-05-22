plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    apply { "dagger.hilt.android.plugin" }
    apply {"androidx.navigation.safeargs.kotlin" }
}

android {
    namespace = "com.example.todolist_mvvm"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.todolist_mvvm"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Fragment
    implementation ("androidx.fragment:fragment-ktx:1.5.7")

    // Lifecycle + ViewModel & LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")

    // Room
    implementation ("androidx.room:room-runtime:2.5.1")
    kapt ("androidx.room:room-compiler:2.5.1")
    implementation ("androidx.room:room-ktx:2.5.1")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")

    // Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.46.1")
    kapt ("com.google.dagger:hilt-android-compiler:2.46.1")
    //implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    //kapt("androidx.hilt:hilt-compiler:1.0.0-alpha03")


    // For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.46.1")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:2.46.1")

    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:2.46.1")
    kaptTest ("com.google.dagger:hilt-android-compiler:2.46.1")

    // DataStore
    implementation ("androidx.datastore:datastore-preferences:1.0.0-alpha01")

}

kapt {
    correctErrorTypes = true
}