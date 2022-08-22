# MyFilm
MyFilm is a test android app that makes use of the [Filimo](https://https://www.filimo.com/) API for search. 
This app showcases the MVVM pattern, Coroutine, Hilt and Clean Architecture approach.

## Guideline
To run the solution, you should install apk file(app_debug.apk).
Afetr 2 seconds, app navigates from Splash Screen to Search Page. In this page you should enter your search text, and click the search button to get related movie list and display them in related recyclerview.
Note: To fetch the data from Api, you need network connection. 

## Features
* Kotlin [1.7.0]
* Single Activity
* MVVM Pattern, Clean Architecture
* Jetpack Architecture Components: Navigation Component [2.5.0], DataBinding, ...
* Coroutine
* Retrofit [2.9.0]
* Dependency injection(Hilt) [2.43]
* Other: Glide [4.11.0], Lottie [3.4.0]