
##### README version beta 1.0
# PROJECT ARCHITECTURE

### General Development

- This App has developed in Kotlin
- The Model View ViewModel Pattern(MVVM) is used.
- The project is divided modules, being they features(Dynamic feature), repositories, networkService, app (default) and domain.
- Retrofit and coroutines are used to make requests
- For coordination of the flow of screens is used Android Navigation
- Injection dependency is done with the Koin Framework
- This app use TMDB api(https://developers.themoviedb.org/3)

### Tools and Technologies
    - Koin -> Dependency injection
    - LiveData -> ViewModel Observable
    - Retrofit -> Network(Rest) requests
    - Coroutine -> Asynchronous execute
    - Dynamic Feature Module -> Features modules onDemand
    - Kotlin -> Language

### Modules

- :app -> Coordinates the features
- :movieFeature(feature) -> Dynamic Feature(onDemand)
- :domain -> Save and coordinates features models
- :networkService -> Network(Rest) engine, coordinates retrofit calls
- :repositorie: interface and coordinates service calls from features
- :databaseService ->  Database Engine(Not Implement)

# TO FIX
    - Dependency injection organization
    - Network error flow
