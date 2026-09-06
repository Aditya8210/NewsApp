# NewsApp - Professional Android News Application

A modern, clean, and reactive News Application built with Jetpack Compose following **Clean Architecture** and **MVVM** principles.

## 🚀 Features
- **Top Headlines:** Browse latest news by categories (Business, Tech, Sports, etc.).
- **Global Search:** Search for any news topic worldwide.
- **Deep Details:** Read full articles in an integrated WebView.
- **Reactive UI:** Automatic UI updates using StateFlow and Coroutines.
- **Clean Architecture:** Separated into Data, Domain, and Presentation layers for maximum scalability.

## 🛠 Tech Stack
- **UI:** Jetpack Compose (Declarative UI)
- **Architecture:** Clean Architecture + MVVM
- **Dependency Injection:** Dagger Hilt
- **Networking:** Retrofit + OkHttp
- **JSON Parsing:** Kotlin Serialization
- **Image Loading:** Coil 3
- **Async Operations:** Coroutines & Flow
- **Navigation:** Type-Safe Jetpack Navigation

## 📁 Project Structure
```text
com.wp7367.newsapp
├── data             # API, DTOs, Mappers, and Repository Implementations
├── domain           # Models, Repository Interfaces, and UseCases (Pure Logic)
├── presentation     # ViewModels, UI Screens, and Navigation Logic
├── di               # Hilt Modules
└── utils            # Helpers and Constants
```

## 🔑 Setup & Installation
1. Clone the repository:
   
2. Get your API Key from [NewsAPI.org](https://newsapi.org/).
3. Open `local.properties` in the root folder and add:
   ```properties
   API_KEY=your_api_key_here
   ```
4. Sync Project with Gradle Files and Run.

## 🛡 Security Note
This project uses `local.properties` to store the API Key, which is ignored by Git. This prevents leaking sensitive credentials in your public repository.

---
Developed with ❤️ for Learning Android Development.
