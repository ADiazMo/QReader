plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.chiky.qreader"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.chiky.qreader"
        minSdk = 21
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }
    //viewBinding{
    //    enabled = true
    //}
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.21")
    implementation("androidx.appcompat:appcompat:1.6.1")
    //Activity
    implementation("androidx.activity:activity-ktx:1.6.1")

    // Dependencies for working with Architecture components
    // You'll probably have to update the version numbers in build.gradle (Project)

    // Room components
    implementation("androidx.room:room-ktx:2.5.0")
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("com.google.android.gms:play-services-mlkit-barcode-scanning:18.3.0")
    kapt("androidx.room:room-compiler:2.5.0")
    androidTestImplementation("androidx.room:room-testing:2.5.0")

    // ViewModel components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    //LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.5.1")

    // Kotlin components
    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib-jdk7
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.22")
    //Corrutinas
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0-RC2")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0-RC2")

    // UI
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")

    //zxing
    implementation("com.google.zxing:core:3.3.0")
    implementation("com.journeyapps:zxing-android-embedded:4.1.0")

    // Fragment
    implementation("androidx.fragment:fragment-ktx:1.3.2")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //dagger hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    //Glide images
    implementation("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")
}
kapt {
    correctErrorTypes = true
}