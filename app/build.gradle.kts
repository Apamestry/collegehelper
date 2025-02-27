plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.collegehelper"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.collegehelper"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.support.annotations)
    implementation(libs.annotation)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation (libs.jsoup)
    implementation (libs.photoview)
    implementation("com.github.chrisbanes:PhotoView:2.3.0")
    implementation("com.davemorrissey.labs:subsampling-scale-image-view:3.10.0")

}