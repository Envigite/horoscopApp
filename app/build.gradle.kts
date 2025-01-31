plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

    //safeargs
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.envigite.horoscopapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.envigite.horoscopapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.envigite.horoscopapp.ui.CustomTestRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            resValue("string", "envigite", "HoroscopApp")

            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
        getByName("debug") {
            isDebuggable = true
            resValue("string", "envigite", "[DEBUG] HoroscopApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
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
        buildConfig = true
    }
}

dependencies {
    val navVersion = "2.8.1"
    val daggerVersion = "2.52"
    val retrofitVersion = "2.11.0"
    val camerax_version = "1.3.4"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //UnitTesting
    testImplementation(libs.junit)
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    testImplementation("io.mockk:mockk:1.13.12")

    //UITesting
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.4.0")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.52")
    androidTestImplementation("androidx.fragment:fragment-testing:1.8.3")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.52")


    //NavComponent
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //DaggerHilt
    implementation("com.google.dagger:hilt-android:$daggerVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerVersion")

    //Retrofitt
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    //LoggingInterceptor
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //CameraX
    implementation("androidx.camera:camera-core:${camerax_version}")
    implementation("androidx.camera:camera-camera2:${camerax_version}")
    implementation("androidx.camera:camera-lifecycle:${camerax_version}")
    implementation("androidx.camera:camera-view:${camerax_version}")
    implementation("androidx.camera:camera-extensions:${camerax_version}")
}