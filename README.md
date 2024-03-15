You have already developed a model for the classic game of Hangman, and now it's time to bring it to life in the console. In addition to the Model, we have prepared an ASCII View. Your task is to integrate these components by constructing the game's controller.

Please clone this repository. Inside, you'll find predefined interfaces for the model, controller, and view components of the game. The model and view components are fully implemented and ready for use.

**Game Logic:**

- The core game logic resides within the `HangmanModelImpl` class. This class maintains the game's state, tracks the number of guesses left, and updates the current state of the word to be guessed.
- The `HangmanAsciiView` class generates the visual ASCII representation of the hangman figurine, updating based on the number of incorrect guesses.
- Your primary focus, the `HangmanConsoleController` class, orchestrates the game flow. It interacts with both the `HangmanModel` and `HanganAsciiView` classes. We've provided some starter code for this class, but it's up to you to complete it and achieve a fully functioning MVC (Model-View-Controller) architecture for the Hangman game.

**Instructions:**

- Carefully review the starter code and existing implementations of the model and view.
- Develop the `HangmanConsoleController` by following the MVC design pattern, ensuring seamless interaction between the model and view.
- Use the `Main` class to test the game to make sure that the gameplay flows correctly, inputs are handled appropriately, and the ASCII representation updates as expected.

**Extra Challenges (Optional):**

If you complete this exercise ahead of schedule, we encourage you to tackle these additional tasks for extra practice and fun:

- **Unit Testing:** Develop comprehensive unit tests for the `HangmanConsoleController`. You can approach this in two ways:
    - Utilize the existing implementations of the model and view for a direct testing approach.
    - Employ mocking techniques for the model and view components to isolate and test the controller's functionality independently.

This assignment offers a fantastic opportunity to apply MVC design principles in a fun and engaging way. We can't wait to see your completed Hangman console game.
