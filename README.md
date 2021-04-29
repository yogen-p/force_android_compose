# Force Android Compose App
Android App using Jetpack Compose that calls the UK Police Open API.

### Packages

- `di`
  
  Dependency Injection | Multiple modules that provide various required dependencies throughout the project
  
- `network`
  
  Network Models | Models for network JSON file and the corresponding responses are stored here along with the NetworkService Interface
  
- `presentation`
  
  View & ViewModels | All the Fragments, their ViewModels and the host activities are written here
  
 - `repository`
  
  Repository Interface & Impl | Repository to access remote and local data source
  
- `util`
  
  Utilities | Files for general purpose to provide additional functionalities



### UI Test

[MainActivityTest.kt](https://github.com/yogen-p/force_android_compose/blob/master/app/src/androidTest/java/com/yogenp/openweathercompose/presentation/MainActivityTest.kt) | Test to check the basic working of the app



### Unit Tests

[MainSharedViewModelTest.kt](https://github.com/yogen-p/force_android_compose/blob/master/app/src/test/java/com/yogenp/openweathercompose/presentation/ui/MainSharedViewModelTest.kt) | Unit Testing ViewModel and Repository using mockito
