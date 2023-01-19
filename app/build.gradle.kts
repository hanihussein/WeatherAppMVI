plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("org.jlleitschuh.gradle.ktlint")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding =  true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {

    implementation(Dependencies.androidCore)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.hiltViewModel)
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hiltCompiler)
    implementation(Dependencies.hitlNavigation)
    implementation(Dependencies.daggerHiltAndroid)
    kapt(Dependencies.daggerCompiler)
    implementation(Dependencies.retrofitCoroutinesAdapter)
    implementation(Dependencies.gson)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitGsonAdapter)
    implementation(Dependencies.httpLogger)
    implementation(Dependencies.retrofitScalarsAdapter)


    testImplementation(Dependencies.testJunit)
    testImplementation(Dependencies.mockk)
    androidTestImplementation(Dependencies.androidTestJunit)
    androidTestImplementation(Dependencies.espressoTest)
}