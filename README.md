# Botan

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Requirements](#requirements)
  - [Installation](#installation)
  - [Configuration](#configuration)
    - [Build Variants](#build-variants)
    - [Local Data Storage](#local-data-storage)
    - [Notifications](#notifications)
- [Architecture](#architecture)
  - [Overview](#overview)
  - [Key Components](#key-components)
  - [Data Flow](#data-flow)
- [Testing](#testing)
  - [Unit Testing](#unit-testing)
  - [Instrumented Testing](#instrumented-testing)
- [Modules](#modules)
- [User Interface](#user-interface)
  - [Key Features](#key-features)
  - [Navigation](#navigation)
- [Play Store Release](#play-store-release)
  - [Version Code](#version-code)
  - [Version Name](#version-name)
  - [Release Notes](#release-notes)
- [Continuous Integration/Continuous Deployment (CI/CD)](#continuous-integrationcontinuous-deployment-cicd)
  - [Continuous Integration (CI)](#continuous-integration-ci)
  - [Continuous Deployment (CD)](#continuous-deployment-cd)
  - [Workflow Files](#workflow-files)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
  - [How to Contribute](#how-to-contribute)
- [License](#license)
- [Coding Standards](#coding-standards)
- [Testing Guidelines](#testing-guidelines)
- [Contribution Guidelines](#contribution-guidelines)

---

## Introduction

**Botan** is a comprehensive plant care app designed to help users effortlessly care for their plants. Whether you're a seasoned gardener or a beginner, Botan provides a suite of tools to keep your plants healthy and thriving. The app offers plant health monitoring, identification, personalized care tips, and detailed analytics to ensure your plants get the care they need. With an intuitive onboarding process, Botan is easy to set up and start using, making plant care accessible to everyone.

## Features

- **Plant Health Monitoring:** Keep track of your plants' well-being with real-time health assessments, alerts, and personalized care recommendations.

- **Plant Identification:** Easily identify plants using image recognition technology and access detailed information about each species.

- **Personalized Care Tips:** Receive tailored care instructions based on the specific needs of your plants, including watering schedules, sunlight exposure, and soil requirements.

- **Growth Analytics:** Monitor your plants' growth over time with detailed analytics and visual progress charts.

- **Reminders and Notifications:** Set reminders for watering, fertilizing, and other essential plant care tasks, and get notifications to ensure you never miss a step.

- **Onboarding Assistance:** New users can easily get started with a guided onboarding process that helps them set up their plant collection and preferences.

- **Settings Customization:** Customize the app to fit your needs with adjustable settings, including themes, notification preferences, and more.

- **User-Friendly Interface:** Enjoy a clean, intuitive design that makes plant care simple and enjoyable, even for beginners.

## Getting Started

### Requirements

Prerequisites needed to run or develop the app are:

- **Android Studio version**: `Koala`
- **Gradle version**: `8.5.2`
- **Minimum SDK version**: `21`
- **Kotlin/Java version**: `2.0.0`

### Installation

Step-by-step guide to setting up the project on a local machine.

1. Clone the repository.
2. Open the project in Android Studio.
3. Sync the project with Gradle.
4. Build and run the app on a device or emulator.

### Configuration

### Build Variants

Botan supports two build variants: `debug` and `release`.

- **Debug Variant:**
  - Used for development and testing.
  - Includes debugging features and settings specific to development.
- **Release Variant:**
  - Used for production.
  - Optimized for performance and includes settings for code obfuscation and app signing.

To switch between build variants, use the Build Variants panel in Android Studio.

### Local Data Storage

The app uses local storage solutions to manage data:

- **Room Database:**
  - Stores structured data such as plant information and care logs.
- **Datastore:**
  - Manages user preferences like notification settings and theme choices.

### Notifications

The app utilizes notifications to remind users about plant care tasks.

- **Local Notifications:**
  - Configured to provide alerts based on user preferences and scheduled tasks.

Adjust notification settings within the app according to user preferences. Test notifications to ensure they are triggered correctly.

## Architecture

### Overview

The app follows a modular architecture to ensure scalability, maintainability, and separation of concerns. Key architectural components include:

- **Model-View-ViewModel (MVVM):** This pattern separates the UI (View) from the business logic (ViewModel) and data (Model), making the app easier to manage and test.

### Key Components

1. **Modules:**
   
   - **Plant Health:** Manages plant health monitoring, including real-time assessments and recommendations.
   - **Analytics:** Provides detailed growth and care analytics for user plants.
   - **Identification:** Handles plant identification through image recognition.
   - **Settings:** Manages user preferences and application settings.
   - **Notifications:** Handles scheduling and sending notifications for plant care tasks.
   - **Onboarding:** Guides new users through the initial setup and configuration process.

2. **Data Layer:**
   
   - **Room Database:** Used for persistent storage of structured data, such as plant details and care logs.
   - **Datastore:** Handles user preferences and settings for a personalized experience.

3. **Repository Pattern:**
   
   - Acts as a clean API for data access to the rest of the application, abstracting the sources of data such as local storage or network sources.

4. **ViewModels:**
   
   - Manage UI-related data in a lifecycle-conscious way, providing a way to communicate between the UI (Views) and the data layer (Models).

5. **Views:**
   
   - Activities and Fragments that display data and handle user interactions. Views observe changes in the ViewModel and update the UI accordingly.

### Data Flow

- **User Interaction:** Users interact with the UI components (Composables).
- **ViewModels:** ViewModels handle user inputs and business logic, interacting with repositories to fetch or store data.
- **Repositories:** Repositories abstract data sources and provide data to ViewModels.
- **Data Sources:** Room database and Datastore serve as local data sources, with potential for future network sources if required.

### Testing

- **Unit Tests:** Focuses on ViewModels, and repositories to ensure that business logic and data manipulation work as expected.
- **UI Tests:** Validates user interactions and UI behavior to ensure the application is responsive and behaves correctly.

## Modules

The app is organized into several modules to enhance maintainability and scalability. Each module focuses on a specific aspect of the app:

- **Plant Health:**
  
  - Manages plant health monitoring, including real-time assessments and personalized care recommendations.

- **Analytics:**
  
  - Provides detailed insights and visualizations of plant growth and care history.

- **Identification:**
  
  - Handles plant identification through image recognition, offering information about various plant species.

- **Settings:**
  
  - Manages user preferences and application settings for a personalized experience.

- **Onboarding:**
  
  - Guides new users through the initial setup process, helping them configure their plant collection and preferences.

- **Notifications:**
  
  - Manages the scheduling and delivery of notifications for plant care tasks, ensuring timely reminders for users.

## User Interface

The app utilizes **Jetpack Compose** to build its user interface, providing a modern and declarative approach to UI development in Android. Key aspects of the UI design include:

### Key Features

- **Declarative UI:** The user interface is built using Compose's declarative syntax, allowing you to describe the UI components and their state in a straightforward manner.

- **Composable Functions:** UI elements are created using composable functions, which can be combined and reused across different parts of the app.

- **State Management:** State management in the UI is handled using Compose's state management features, ensuring that the UI updates in response to state changes efficiently.

- **Theming:** The app employs a consistent and customizable theme using Compose’s theming capabilities, allowing for easy adjustments to the app’s look and feel.

### Navigation

- **Navigation Component:** Jetpack Compose's navigation library is used for handling screen transitions and passing data between screens.

## Testing

### Unit Testing

Unit tests verify the functionality of components such as repositories, ViewModels, and other classes within the plant care app. The following tools and practices are used:

- **Turbine:** Utilized to test Kotlin Flows, ensuring that flow emissions are correct and occur in the expected order, which is crucial for verifying data streams and state management in features like plant health assessments.

- **Truth:** Provides fluent assertion methods to validate the correctness of test results, ensuring that expected outcomes align with actual behavior, particularly for data and state assertions in plant care functionality.

- **JUnit:** The primary framework for running unit tests, organizing test cases for components such as ViewModels and repositories.

**Fakes and Test Doubles:**

- **Fakes and Test Doubles:** Employed to create controlled test environments. Fakes simulate the behavior of real components like plant repositories, allowing isolation of ViewModel and repository functionality without relying on actual data sources.

### Instrumented Testing

Instrumented tests run on Android devices or emulators and validate interactions with the app’s database, DAOs, and UI screens. The following tools and practices are utilized:

- **Room Database and DAOs:** Tests ensure that the Room database and DAOs handle plant data operations correctly, such as storing and retrieving plant information and care logs.

- **Compose Testing Tools:** Jetpack Compose testing tools are used to verify the user interface components and interactions. This includes testing screens to ensure they display plant details correctly and handle user interactions as expected.

## Play Store Release

The app follows a date-based versioning strategy to manage version codes and names, ensuring clarity and uniqueness for each release.

### Version Code

The `versionCode` is calculated based on the current date:

- **Calculation:**
  - Starts with a base value.
  - Adds the current date in the `yyyyMMdd` format.
  - Includes a fixed number that can be adjusted if multiple versions are released on the same day.

### Version Name

The `versionName` is formatted to reflect the release date:

- **Format:** `vYYYY.MM (dd)`

This format provides a clear indication of the release date in a human-readable form, aiding in version tracking and release management.

### Release Notes

### [Version vYYYY.MM (dd)]

**Release Date:** YYYY-MM-DD

#### Description of Release Notes Creation

Release notes are crafted to provide clear and concise information about changes made in each version of the app. The process includes:

1. **Feature Updates:**
   
   - Highlight new features and functionalities added in the release. Focus on improvements that enhance user experience or introduce significant capabilities.

2. **Enhancements:**
   
   - Document improvements to existing features, performance optimizations, and UI/UX refinements. Emphasize any changes that improve the app's overall efficiency or user interaction.

3. **Bug Fixes:**
   
   - Include details about resolved issues, including specific bugs or glitches that have been addressed in the release.

4. **Miscellaneous:**
   
   - Mention any other important updates, such as changes in dependencies, security updates, or adjustments to internal processes.

5. **Versioning:**
   
   - Ensure that the version number and release date are clearly specified, aligning with the app’s versioning strategy to facilitate tracking and management.

**Example Entries:**

- **New Features:** Description of new functionalities added to the app.
- **Enhancements:** Information on improvements made to existing features.
- **Bug Fixes:** Details of issues resolved in this release.

## Continuous Integration/Continuous Deployment (CI/CD)

The app uses GitHub Actions to implement Continuous Integration and Continuous Deployment (CI/CD), with additional tools integrated to maintain code quality and coverage.

### Continuous Integration (CI)

- **Automated Testing:** GitHub Actions runs unit tests and instrumented tests to validate code changes and ensure that new commits do not introduce regressions.
- **Build Process:** The app is automatically built in different configurations (e.g., debug and release) to verify that the build process succeeds and produces the expected artifacts.
- **Code Quality:**
  - **Spotless:** Enforces consistent code formatting and style across the project. Spotless automatically applies code formatting rules to ensure that code adheres to the defined standards.
  - **JaCoCo:** Provides code coverage reports to track the percentage of code tested by unit tests. This helps identify untested areas of the codebase and improve test coverage.

### Continuous Deployment (CD)

- **Release Automation:** Upon successful builds and tests, GitHub Actions can automate the deployment process to the Google Play Store, streamlining the release of new versions.
- **Version Management:** Automated workflows handle versioning based on the app’s versioning strategy, ensuring that version codes and names are updated correctly.

### Workflow Files

- **Location:** Workflow files are defined in the `.github` directory. `build-gradle-project.yml` configures the CI process, including steps for building the project and running tests. It ensures that the build process and automated tests are executed with each commit or pull request.

## Troubleshooting

If you encounter any issues or bugs, please report them by opening an issue in the repository. Provide as much detail as possible to help us understand and address the problem effectively.

## Contributing

We welcome contributions to enhance the plant care app! Whether you’re fixing a bug, adding a feature, or improving documentation, your input is valuable. Please follow these guidelines to ensure a smooth contribution process.

### How to Contribute

1. **Fork the Repository:**
   
   - Start by forking the repository to your own GitHub account. This allows you to make changes without affecting the main project.

2. **Create a Feature Branch:**
   
   - Create a new branch for your changes with a descriptive name that reflects the nature of your contribution.

3. **Make Your Changes:**
   
   - Implement your changes in your feature branch. Ensure that your code follows the project’s coding standards and guidelines.

4. **Write Tests:**
   
   - Write tests to verify the functionality of your changes, ensuring that existing tests pass and your new tests cover the added functionality.

5. **Update Documentation:**
   
   - Update relevant documentation to reflect your changes, including README files and other documentation affected by your contribution.

6. **Commit Your Changes:**
   
   - Commit your changes with a clear and descriptive message that explains your modifications.

7. **Push and Create a Pull Request:**
   
   - Push your changes to your forked repository and open a pull request to the main repository. Provide a detailed description of your changes and their benefits.

8. **Address Feedback:**
   
   - Respond to feedback on your pull request and make any necessary adjustments. Engage in discussions to ensure your contribution meets the project’s needs.

## License

```
/*
*   Copyright 2024 Denis Githuku
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*/
```

#### Coding Standards

To maintain consistency and readability across the Kotlin codebase, please adhere to the following coding standards:

- **Code Style:** Follow the Kotlin Coding Conventions. This includes consistent naming conventions, indentation, and formatting.
- **Documentation:** Use KDoc for documenting Kotlin code. Provide clear and concise comments for public methods and classes.
- **Error Handling:** Handle errors gracefully and use meaningful error messages. Prefer using specific exceptions over generic ones.
- **Code Reviews:** Ensure your code is reviewed before merging. Address the feedback provided by reviewers to improve code quality.

## Testing Guidelines

Testing is essential for maintaining the quality and reliability of your Kotlin project. Follow these guidelines:

- **Unit Tests:**
  
  - Write unit tests for all new features and bug fixes. Ensure that each test is focused on a specific piece of functionality.
  - Use JUnit for writing unit tests and [Truth](https://truth.dev/) for assertions.
  - Utilize [Turbine](https://github.com/cashapp/turbine) for testing Kotlin Flows to handle asynchronous operations.

- **Instrumented Tests:**
  
  - Write instrumented tests for components interacting with the Android framework, such as database operations and UI elements.
  - Use [Jetpack Compose Testing Tools](https://developer.android.com/jetpack/androidx/releases/compose-testing) for testing Compose UI components.

- **Test Coverage:**
  
  - Ensure new code includes appropriate tests and that existing tests cover critical functionality.
  - Use JaCoCo to measure test coverage and aim for high coverage.

## Contribution Guidelines

To contribute effectively to the Kotlin project, follow these guidelines:

1. **Fork and Clone:**
   
   - Fork the repository and clone it to your local machine to work on your changes.

2. **Branch Naming:**
   
   - Create a feature branch with a descriptive name related to your work.

3. **Commits:**
   
   - Write clear and descriptive commit messages. Each commit should represent a single logical change.

4. **Pull Requests:**
   
   - Open a pull request with a descriptive title and a summary of the changes made. Include any relevant issue numbers and explanations.

5. **Code Review:**
   
   - Participate in code reviews by providing constructive feedback and responding to comments on your pull requests.

6. **Testing:**
   
   - Ensure that all tests pass before submitting a pull request. Add tests for new features or bug fixes.

7. **Documentation:**
   
   - Update documentation to reflect any changes made, including README files and inline code comments.