<h1 align="center"> Weather Forecast App </h1>

<p align="center">
Simply Weather App is an app created to display weather forecast for current city and the upcoming 7 days with min/max degrees, Wind speed and day status.
from Norwegian Meteorological Institute</p>

## Architecture

Application that follow modern application architecture with MVI pattern , separation of concerns approach , data layer , domain layers 
and UseCase pattern to contains the business logic in it and to be independent from Android platform.

## Layers

- [x] Data ( Network data source -  Repositories Implementation - Data Models -  Wrappers/Data Handlers)

- [x] Domain ( Usecases -  Repositories - Domain Models)

- [x] Presentation ( Activities - Fragments - ViewModels - Binding Adapters)

## Tech stack & libraries

- Architecture & patterns
  - MVI Architecture pattern
  - Repository pattern
  - Dependency Injection pattern
  - Clean Architecture approach.
  - Delegate pattern
  - Data/View Binding
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/)
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)
- [StateFlow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/index.html)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection.
- [JetPack](https://developer.android.com/jetpack)
- [Mockk](https://mockk.io/) for unit testing
- [Gradle KotlinDsl](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Construct the REST APIs.
- [GSON](https://github.com/google/gson) - A Modern JSON library for Android.
- [Ktlint](https://github.com/pinterest/ktlint)- An anti-bikeshedding Kotlin linter with a built-in
  formatter.


