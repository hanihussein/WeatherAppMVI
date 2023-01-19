import org.gradle.kotlin.dsl.provideDelegate

/**
 * Application main plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltPath}" }
    val ktLint by lazy {  "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLintGradle}" }
    val ktLintMeven = "https://plugins.gradle.org/m2/"
}

/**
 * Application dependencies/ Libraries
 */
object Dependencies {
    //Android Main
    val androidCore by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }

    //Design
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }

    //DI
    val hiltViewModel by lazy { "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03" }
    val hiltCompiler = "androidx.hilt:hilt-compiler:1.0.0"
    val hitlNavigation = "androidx.hilt:hilt-navigation-compose:1.0.0"
    val daggerHiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.daggerHilt}" }
    val daggerCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.daggerHilt}" }

    //Network
    val retrofitCoroutinesAdapter by lazy { "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}" }
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val retrofitGsonAdapter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}" }
    val retrofitScalarsAdapter by lazy { "com.squareup.retrofit2:converter-scalars:${Versions.scalarsAdapter}" }
    val httpLogger by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}" }

    //Testing
    val testJunit by lazy { "junit:junit:${Versions.jUnit}" }
    val androidTestJunit by lazy { "androidx.test.ext:junit:${Versions.androidTest}" }
    val espressoTest by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoTest}" }
    val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
}




