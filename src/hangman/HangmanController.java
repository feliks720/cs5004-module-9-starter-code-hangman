package hangman;

/**
 * Represents a Controller for Hangman: handle user moves by executing them
 * using the model; convey move outcomes to the user in some form.
 */
public interface HangmanController {

  /**
   * Execute a single game of hangman given a hangman model. When the game
   * is over, the playGame method ends.
   *
   * @param model a non-null hangman Model
   * @throws IllegalArgumentException if model is null
   */
  void playGame(HangmanModel model) throws IllegalArgumentException;
}
