import hangman.HangmanAsciiView;
import hangman.HangmanConsoleController;
import hangman.HangmanModel;
import hangman.HangmanModelImpl;
import hangman.HangmanView;
import java.io.InputStreamReader;

/**
 * Run a Hangman game interactively on the console.
 */
public class Main {

  /**
   * Run a Hangman game interactively on the console.
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    Readable input = new InputStreamReader(System.in);
    Appendable output = System.out;
    HangmanModel model = new HangmanModelImpl("res/words-test.txt");
    HangmanView view = new HangmanAsciiView();
    new HangmanConsoleController(input, output, view).playGame(model);
  }
}
