package hangman;

import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a Controller for the Hangman game. The controller is responsible for handling user
 * moves by executing them using the model and conveying move outcomes to the user.
 */
public class HangmanConsoleController implements HangmanController {

  private final Readable in;
  private final Appendable out;
  private final HangmanView view;

  /**
   * Constructs a new HangmanConsoleController.
   *
   * @param in   the input source
   * @param out  the output source
   * @param view the view for the game
   * @throws IllegalArgumentException if in or out is null
   */
  public HangmanConsoleController(Readable in, Appendable out, HangmanView view)
      throws IllegalArgumentException {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.in = in;
    this.out = out;
    this.view = view;
  }

  @Override
  public void playGame(HangmanModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model can't be null");
    }
    Scanner scan = new Scanner(in);
    try {
      out.append(view.getWelcomeMessage()).append("\n");
      // Loop until the game is over.
      while (!model.isGameOver()) {
        // Display current hangman art, remaining guesses, and current state.
        out.append(view.getHangman(model.getGuessesRemaining())).append("\n");
        out.append(view.getGuessesRemainingMessage(model.getGuessesRemaining())).append("\n");
        out.append(view.getCurrentGuessMessage(model.getCurrentState())).append("\n");
        // Ask for user input.
        out.append(view.getEnterGuessMessage()).append("\n");

        if (!scan.hasNext()) {
          break;
        }
        String input = scan.next();
        if (input.length() != 1) {
          out.append("Please enter a single letter.\n");
          continue;
        }
        char guess = input.charAt(0);
        try {
          boolean isCorrect = model.makeGuess(guess);
          if (isCorrect) {
            out.append("Correct guess!\n");
          } else {
            out.append("Incorrect guess.\n");
          }
        } catch (IllegalArgumentException e) {
          out.append(e.getMessage()).append("\n");
        } catch (IllegalStateException e) {
          out.append(e.getMessage()).append("\n");
          break;
        }
      }
      // Display final output.
      if (!model.getCurrentState().contains("_")) {
        out.append(view.getWinMessage(model.getAnswer())).append("\n");
      } else {
        out.append(view.getLoseMessage(model.getAnswer())).append("\n");
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}