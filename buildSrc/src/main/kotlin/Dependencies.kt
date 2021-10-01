import org.gradle.api.JavaVersion

object Config {
    const val gradleVersion = "7.0.2"
    const val kotlinVersion = "1.5.30"
    const val application_id = "com.dentag.getcat"
    const val compileSdk = 30
    const val minSdk = 24
    const val targetSdk = 30
    const val buildTools = "30.0.3"
    val javaVersion = JavaVersion.VERSION_1_8
    const val ktlintVersion = "10.2.0"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    //Kotlin
    const val core = "1.6.0"
    const val coroutinesCore = "1.5.1"
    const val coroutinesAndroid = "1.5.1"

    //Design
    const val appcompat = "1.3.1"
    const val material = "1.4.0"
    const val constraintLayout = "2.1.0"

    //Test
    const val jUnit = "4.12"

    //Retrofit
    const val retrofitVersion = "2.9.0"
    const val loggingInterceptorVersion = "4.9.1"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.jUnit}"
}

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"
}
