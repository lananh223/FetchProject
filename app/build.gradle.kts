plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.fetchproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fetchproject"
        minSdk = 24
        targetSdk = 34
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
    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
}

dependencies {
    implementation("androidx.compose.ui:ui-tooling-preview-android:1.5.1")
    val lifecycle_version = "2.6.2"
    val composeBom = platform("androidx.compose:compose-bom:2023.01.00")

    // AndroidX
//
//    implementation 'androidx.lifecycle:lifecycle-common-java8:2.4.1'
//    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.1'
//    implementation 'androidx.lifecycle:lifecycle-process:2.4.1'
//    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.4.1'
//    implementation 'androidx.lifecycle:lifecycle-runtime:2.4.1'
//    implementation 'androidx.lifecycle:lifecycle-service:2.4.1'
//    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1'
//    implementation 'androidx.lifecycle:lifecycle-viewmodel-savedstate:2.4.1'
//    implementation 'androidx.recyclerview:recyclerview:1.2.1'
//    implementation 'androidx.legacy:legacy-support-v4:1.0.0'

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.core:core:1.9.0")
    implementation ("androidx.activity:activity-ktx:1.8.1")
    implementation ("androidx.fragment:fragment-ktx:1.4.1")
    implementation ("androidx.fragment:fragment:1.4.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.4.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(composeBom)
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")
}