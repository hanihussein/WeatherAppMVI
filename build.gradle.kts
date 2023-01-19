// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven(BuildPlugins.ktLintMeven)

    }
    dependencies {
        classpath (BuildPlugins.android)
        classpath (BuildPlugins.kotlin)
        classpath(BuildPlugins.hilt)
        classpath(BuildPlugins.ktLint)
    }
}

allprojects {
    repositories {
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
