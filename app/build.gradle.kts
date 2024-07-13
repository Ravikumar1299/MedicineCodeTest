plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-parcelize")
    id("kotlin-kapt")
    id ("kotlin-android")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.ravikumarcodetest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ravikumarcodetest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}
//dependencies {
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.1")
//    implementation("androidx.core:core-ktx:1.3.2")
//    implementation("androidx.appcompat:appcompat:1.2.0")
//    implementation("com.google.android.material:material:1.2.1")
//    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
//
//    // Room components
//    implementation("androidx.room:room-runtime:2.6.1")
//    kapt("androidx.room:room-compiler:2.6.1")
//
//    // Hilt dependencies
//    implementation("com.google.dagger:hilt-android:2.51.1")
//    kapt("com.google.dagger:hilt-compiler:2.51.1")
//
//    // ViewModel
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
//
//    // Compose
//    implementation("androidx.compose.ui:ui:1.6.8")
//    implementation("androidx.compose.material:material:1.6.8")
//    implementation("androidx.compose.ui:ui-tooling-preview:1.6.8")
//    implementation("androidx.activity:activity-compose:1.3.1")
//    implementation(libs.androidx.core.ktx)
//    // Testing dependencies
////    testImplementation("junit:junit:4.13.1")
////    androidTestImplementation("androidx.test.ext:junit:1.1.2")
////    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
//}
dependencies {
    implementation ("com.squareup.moshi:moshi-kotlin:1.12.0")
    // Compose Coil
    implementation ("io.coil-kt:coil-compose:1.3.2")

    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.runtime.livedata)
//    implementation(libs.androidx.room.common)
//    implementation(libs.androidx.room.ktx)

    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


}
kapt{
    generateStubs = true
    correctErrorTypes = true
}