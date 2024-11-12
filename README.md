# MaterialDesignComposeApp
**MaterialDesignComposeApp** is a simple Android app developed using Jetpack Compose and Material 3 design to provide a modern and responsive user interface.

## Features

### 1. Interactive Home Interface
   - The application displays a home page with a welcome message and three navigation buttons.
   - The buttons provide access to the following sections: Affirmations, Courses and Woof.

### 2. Affirmations Section
   - A list of statement cards is displayed in a `LazyColumn` type layout.
   - Each card features an image and affirmation text, with an elegant layout and clearly defined margins.
   - A fixed back button makes it easy to return to the home page.

### 3. Courses Section
   - Using `LazyVerticalGrid` to display courses in a 2 column grid.
   - Each course card displays an image, a title, and the number of associated courses.
   - Fluid and responsive layout with adapted margins.

### 4. Woof Section
   - A showcase of dog profiles displayed in a list using LazyColumn. 
   - Each profile card includes an image, the dog's name, age, and additional information styled with custom fonts. 
   - Enhanced design with a top bar displaying a logo and title, and a divider to visually separate the toolbar from the content. 
   - A fixed bottom bar with a return button to the home page, styled for clear separation from the list of dog profiles.

## Design and Theming Enhancement
- Typography: Custom fonts (Abril Fatface and Montserrat) were added for a more distinctive look
- Shape Customization: Updated shapes with custom rounded corners
- Colors: Custom colors for better displaying the UI elements

## Technology Stack
- **Kotlin**: Primary language for modern Android development.
- **Jetpack Compose**: Used to create responsive and modern user interfaces.
- **Material Design 3**: Implementation of the latest version of Material Design for themes and color palette.
- **Android Jetpack Components**:
  - **Activity**: Manages the life cycle of components.
  - **Composable**: Jetpack Compose components for building responsive screens.
  - **LazyColumn** and **LazyVerticalGrid**: List components for powerful layouts.

## Objective
The goal of **MaterialDesignComposeApp** is to demonstrate Android development best practices with Compose and Material Design 3 by creating a simple, well-organized application. The project highlights:

- Using `LazyColumn` and `LazyVerticalGrid` to manage dynamic lists.
- Management of dynamic themes to adapt to user preferences (dark and light mode).
- Simple navigation between the different activities of the application.

