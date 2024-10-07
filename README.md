# Android Project Template

This is a modular Android project template designed to make development scalable, maintainable, and easy to expand. It follows best practices in modern Android development, utilizing **Kotlin**, **Clean Architecture** principles, and **Jetpack libraries**. The template includes four main modules, each focused on a distinct part of the architecture, ensuring a clean separation of concerns.

## Modules Overview

### 1. `app`
- **Description**: The main application module that holds the core UI code and serves as the entry point for the app.
- **Contents**:
  - **Activities**, **Fragments**, and XML **layouts**.
  - Navigation, **dependency injection** (Hilt) setup, and app-level configuration.
  - **Jetpack Compose** components for UI development.
- **Dependencies**:
  - Depends on the `data`, `core`, and `domain` modules to bring together the entire functionality of the app.

### 2. `core`
- **Description**: Contains reusable and common utilities shared across the project.
- **Contents**:
  - Utility classes, extension functions, shared constants, and helper methods.
- **Dependencies**:
  - No direct dependencies on other modules to maintain a lightweight and reusable nature.
  - Provides utility functions and extensions used by `app`, `data`, and `domain` modules.

### 3. `data`
- **Description**: Manages data sources, including both local and remote sources. It serves as a bridge between the `domain` layer and data storage or API calls.
- **Contents**:
  - **Repository implementations** that interface with both local and remote data sources.
  - **Local Data**: Utilizes **Room Database**, DAOs, and entity classes to manage data persistence.
  - **Remote Data**: Uses **Retrofit** setup for API calls, including **OkHttp** for HTTP client capabilities.
- **Dependencies**:
  - Depends on `core` for utility functions.
  - Provides data handling to the `domain` module via repository interfaces.

### 4. `domain`
- **Description**: Represents the business logic layer of the application.
- **Contents**:
  - **Use cases** that encapsulate business rules and orchestrate application logic.
  - **Domain models** that are independent of data storage or UI representation.
  - **Repository interfaces** that the `data` module implements.
- **Dependencies**:
  - Depends on the `data` module for repository interfaces.
  - Remains independent of the `app` module to keep it reusable, isolated, and testable.

## How to Use the Template

### Adding Dependencies Between Modules
When creating new features or integrating modules, you may need to add dependencies between the modules. Below are some examples of adding module dependencies in the `build.gradle.kts` file of the respective module:

Add the following lines in the `build.gradle.kts` file where you need to access other modules:

```kotlin
implementation(project(":core"))
implementation(project(":data"))
implementation(project(":domain"))
