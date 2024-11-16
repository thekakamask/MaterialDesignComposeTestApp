# MaterialDesignComposeApp
**MaterialDesignComposeApp** is a simple Android app developed using Jetpack Compose and Material 3 design to provide a modern and responsive user interface.

## Features

### 1. Interactive Home Interface
   - The application displays a home page with a welcome message and three navigation buttons.
   - A top bar displays a centered logo and title, with a visual separator to better distinguish the main content of the toolbar.
   - The buttons provide access to the following sections: Affirmations, Races, Woof, Superheroes and Wellness.

### 2. Affirmations Section
   - A top bar displays a centered logo and title, with a visual separator to better distinguish the main content of the toolbar.
   - A list of statement cards is displayed in a `LazyColumn` type layout.
   - Each card features an image and affirmation text, with an elegant layout and clearly defined margins.
   - A top bar displays a centered logo and title, with a visual separator to better distinguish the main content of the toolbar.
   - A fixed bottom bar with a return button to the home page, styled for clear separation from the list of affirmations.

### 3. Courses Section
   - Using `LazyVerticalGrid` to display courses in a 2 column grid.
   - Each course card displays an image, a title, and the number of associated courses.
   - A top bar displays a centered logo and title, with a visual separator to better distinguish the main content of the toolbar.
   - A fixed bottom bar with a return button to the home page, styled for clear separation from the list of courses.

### 4. Woof Section
   - An overview of dog profiles displayed in a list with LazyColumn.
   - Each profile card displays a picture, the dog's name, age, and an expandable description of their hobbies. The map animation uses animateContentSize for smooth adjustment when expanding or shrinking.
   - Profile cards feature background colors that change depending on the expanded or collapsed state, providing a dynamic visual touch. 
   - A top bar displays a centered logo and title, with a visual separator to better distinguish the main content of the toolbar.
   - A fixed bottom bar with a return button to the home page, styled for clear separation from the list of dog profiles.

### 5. Superheroes Section
   - A list of superhero cards displayed in a LazyColumn layout.
   - Each card contains an image, the name of the superhero and a description of their powers.
   - A top bar displays a centered logo and title, with a visual separator.
   - A fixed bottom bar with a return to home page button.

### 6. Wellness Section
   - A horizontal layout using LazyRow to display Wellness Advice cards.
   - Each card contains: A title and a subtitle, A highlight image, A truncated description by default, with an expandable button to display all content.
   - The map animation uses animateContentSize for smooth expansion when text is expanded.
   - The cards are grouped in pairs in the horizontal layout.
   - A top bar with a centered logo and title, with a visual separator.
   - A fixed bottom bar with a return to home page button.

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
  - **LazyColumn** and **LazyVerticalGrid** and **LazyRow**: List components for powerful layouts.

## Objective
The goal of **MaterialDesignComposeApp** is to demonstrate Android development best practices with Compose and Material Design 3 by creating a simple, well-organized application. The project highlights:

- Using `LazyColumn` and `LazyVerticalGrid` to manage dynamic lists.
- Management of dynamic themes to adapt to user preferences (dark and light mode).
- Simple navigation between the different activities of the application.

