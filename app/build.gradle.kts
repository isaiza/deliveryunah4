plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.google.gms:google-services:4.3.10")
    }
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.deliveryunah" // ID de la app
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Especifica el namespace aquí
        namespace = "com.example.deliveryunah"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // Dependencias de Android
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.compose:compose-bom:2024.09.00")
    implementation("androidx.compose.ui:ui:2024.09.00")
    implementation("androidx.compose.ui:ui-graphics:2024.09.00")
    implementation("androidx.compose.ui:ui-tooling:2024.09.00")
    implementation("androidx.compose.ui:ui-tooling-preview:2024.09.00")
    implementation("androidx.compose.ui:ui-test-manifest:2024.09.00")
    implementation("androidx.compose.ui:ui-test-junit4:2024.09.00")
    implementation("androidx.compose.material3:material3:1.0.0")

    // Firebase
    implementation("com.google.firebase:firebase-auth:20.3.0")
    implementation("com.google.firebase:firebase-firestore:24.2.0")

    // Dependencias de pruebas
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Dependencia para Activity-Compose
    implementation("androidx.activity:activity-compose:1.10.1")
}

// Aplicar el plugin de Google Services
apply(plugin = "com.google.gms.google-services")
