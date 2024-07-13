# CODE-TASK ACCORDING TO BELOW REQUIREMENTS 📝

The task is to create a simple MVVM project in kotlin and compose that should have all tasks below

1) A simple login screen. ( you can allow anyone to log in, no validation needed)

2) Once you login, greet the user based on the time of the day (show a textbox displaying the message and the username/email which the user entered)

3) On the same page,  display the name , dose and strength of medicine shown in the json below : (add them as cards in a recyclerview)

https://pastebin.com/jKVv22p8 ( use mocky.io to create mock api  if you'd like or to extend the existing api). Tapping on each of these cards, will open a detailed view showing the same data.(please use just 1 model class for this and keep code as consistent as possible)

4) Use room DB to store any data.

5) Write at least 3 unit tests for any use cases that apply.

# Api Used made From Response provided by You
https://run.mocky.io/v3/c6b987e9-fa8a-49e4-9df4-577a037caa45

This is app built with Jetpack Compose UI Toolkit.


## Built With 🛠

- **Kotlin**: First-class and official programming language for Android development.
- **Coroutines**: Asynchronous programming for efficient handling of background tasks.
- **Jetpack Compose UI Toolkit**: Modern UI development toolkit for building native Android UIs.
- **Android Architecture Components**:
    - **LiveData**: Data objects that notify views when the underlying database changes.
    - **ViewModel**: Stores UI-related data that isn't destroyed on UI changes.
    - **Retrofit**: Networking Library for Android, To handle network requests and responses.
- **Dependency Injection**:
    - **Hilt-Dagger**: Standard dependency injection for Android applications.
    - **Hilt-ViewModel**: Dependency injection for ViewModel.
- **Moshi**:A modern JSON library for Android and Java, used for parsing JSON into Java/Kotlin objects and serializing Java/Kotlin objects into JSON.
- **Room Database**:Simplified ORM (Object-Relational Mapping) for persisting data with type-safe queries in Android..
## Architecture 👷‍♂️

This App follows combination of  MVVM (Model-View-ViewModel) architecture and Clean Architecture pattern, providing a robust and maintainable structure for the app.
