package hangman;

/**
 * Represents an Ascii view for the Hangman game. The view is responsible for displaying the state
 * of the game to the user.
 */
public class HangmanAsciiView implements HangmanView {

  /**
   * Constructs a new HangmanAsciiView.
   */
  public HangmanAsciiView() {
    // This constructor is empty because no initialization is needed.
  }

  @Override public String getHangman(int guessesRemaining) {
    switch (guessesRemaining) {
      case 6:
        return "  +---+\n" + "  |   |\n" + "      |\n" + "      |\n" + "      |\n" + "      |\n"
            + "=========\n";
      case 5:
        return "  +---+\n" + "  |   |\n" + "  O   |\n" + "      |\n" + "      |\n" + "      |\n"
            + "=========\n";
      case 4:
        return "  +---+\n" + "  |   |\n" + "  O   |\n" + "  |   |\n" + "      |\n" + "      |\n"
            + "=========\n";
      case 3:
        return "  +---+\n" + "  |   |\n" + "  O   |\n" + " /|   |\n" + "      |\n" + "      |\n"
            + "=========\n";
      case 2:
        return "  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + "      |\n" + "      |\n"
            + "=========\n";
      case 1:
        return "  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + " /    |\n" + "      |\n"
            + "=========\n";
      default:
        return "  +---+\n" + "  |   |\n" + "  O   |\n" + " /|\\  |\n" + " / \\  |\n" + "      |\n"
            + "=========\n";
    }
  }

  @Override public String getWelcomeMessage() {
    return "Welcome to Hangman!\nUse \"?\" to quit the game.\n";
  }

  @Override public String getGuessesRemainingMessage(int guessesRemaining) {
    return "Guesses remaining: " + guessesRemaining + "\n";
  }

  @Override public String getCurrentGuessMessage(String currentState) {
    return "Guess the word: " + currentState + "\n";
  }

  @Override public String getEnterGuessMessage() {
    return "Guess a letter: ";
  }

  @Override public String getWinMessage(String answer) {
    return "You win!\nThe word was: " + answer + "\n";
  }

  @Override public String getLoseMessage(String answer) {
    return "You lose!\nThe word was: " + answer + "\n";
  }
}