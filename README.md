# MyFilm
MyFilm is a sample Android project based on MVVM + Clean Architecture. It showcases the latest Android tech stacks with well-designed architecture and best practices


# Tech Stacks

MVVM + Clean Architecture

[Hilt](https://dagger.dev/hilt/)  - Dependency injection.

[Retrofit](https://square.github.io/retrofit/)  -Android REST Client.

[Navigation component](https://developer.android.com/guide/navigation)  -  Fragment routing handler

[ViewBinding](https://developer.android.com/topic/libraries/view-binding) - View binding is a feature that allows you to more easily write code that interacts with views 

[Android Architecture Components](https://developer.android.com/topic/libraries/architecture)  - A collections of libraries that help you design rebust, testable and maintainable apps.

[ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel)  - UI related data holder, lifecycle aware.

[Coroutines](https://developer.android.com/kotlin/coroutines) - Concurrency design pattern for asynchronous programming.

[Flow](https://developer.android.com/kotlin/flow) - Stream of value that returns from suspend function.

[LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - LiveData is an observable data holder class


# Architectures
![Artboard_15587](https://user-images.githubusercontent.com/103646893/213918105-b99d37d2-6916-40a2-8ec1-e061a568c3b8.png)

**Presentation** : This is a layer that interacts with the (UI)user interface.

**Domain** : The app’s business logic is stored here

**Data** : All data sources are defined in a broad sense.

**Use cases** :  Interactors are another name for them.
