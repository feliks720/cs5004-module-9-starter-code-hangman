package hangman;

/**
 * Interface for a Hangman game model. The model is responsible for keeping track of the state of
 * the game, including the word to guess, the letters guessed, and the number of guesses remaining.
 */
public interface HangmanModel {
  /**
   * Initializes the game with a randomly selected word from a list.
   */
  void initialize();

  /**
   * Makes a guess in the Hangman game. If the letter has already been used, no change is made to
   * the game state. If the letter has not been used and is in the word, the letter is added to the
   * list of used letters and the current state of the word is updated to reflect the newly guessed
   * letter.
   *
   * @param letter The letter to guess.
   * @return true if the guess is correct, false otherwise.
   * @throws IllegalArgumentException if letter has already been guessed.
   * @throws IllegalStateException    if the game is over.
   */
  boolean makeGuess(char letter) throws IllegalArgumentException, IllegalStateException;

  /**
   * Checks if the Hangman game is over.
   *
   * @return true if the game is over, false otherwise.
   */
  boolean isGameOver();

  /**
   * Gets the current state of the word with guessed letters filled in.
   *
   * @return The current state of the word.
   */
  String getCurrentState();

  /**
   * Gets the number of guesses remaining.
   *
   * @return The number of guesses remaining.
   */
  int getGuessesRemaining();

  /**
   * Displays the word to guess (answer).
   *
   * @return The word to guess.
   */
  String getAnswer();
}

