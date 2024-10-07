import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.abhishek.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    ktlint {
        android.set(true)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        reporters {
            reporter(ReporterType.PLAIN)
            reporter(ReporterType.CHECKSTYLE)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    // Retrofit
    api(libs.retrofit)
    api(libs.okhttp.logging.interceptor)
    api(libs.kotlinx.serialization.json)
    // Hilt dependencies
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
