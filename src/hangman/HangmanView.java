package hangman;

/**
 * Interface for the view for the Hangman game. The view is responsible for displaying the state of
 * the game to the user.
 */
public interface HangmanView {

  /**
   * Gets the art for the Hangman game.
   *
   * @param guessesRemaining the number of guesses remaining
   * @return the art for the Hangman game
   */
  String getHangman(int guessesRemaining);

  /**
   * Display welcome message.
   *
   * @return welcome message
   */
  String getWelcomeMessage();

  /**
   * Display message for number of guesses remaining.
   *
   * @param guessesRemaining number of guesses remaining
   * @return message for number of guesses remaining
   */
  String getGuessesRemainingMessage(int guessesRemaining);

  /**
   * Display message for current guess.
   *
   * @param currentState current state of the word
   * @return message for current guess
   */
  String getCurrentGuessMessage(String currentState);

  /**
   * Display message for entering a guess.
   *
   * @return message for entering a guess
   */
  String getEnterGuessMessage();

  /**
   * Display message that the user has won.
   *
   * @param answer the word that was guessed
   * @return message that the user has won
   */
  String getWinMessage(String answer);

  /**
   * Display message that the user has lost.
   *
   * @param answer the word that was guessed
   * @return message that the user has lost
   */
  String getLoseMessage(String answer);

}
