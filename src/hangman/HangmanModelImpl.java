package hangman;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Implementation of the HangmanModel interface. Created by Lino Coria Mendoza - October 2023.
 */
public class HangmanModelImpl implements HangmanModel {

  private String word;
  private String guessedLetters;
  private int guessesRemaining;
  private String currentState;
  private final List<String> wordList;

  /**
   * Constructs a HangmanModelImpl object.
   *
   * @param fileName The file to read words from.
   * @throws IllegalStateException if the file is empty.
   */
  public HangmanModelImpl(String fileName) {
    this.wordList = new LinkedList<>();
    this.guessedLetters = "";
    this.guessesRemaining = 6;
    this.currentState = "";
    getWordList(fileName);
    initialize();
    initializeCurrentState();
  }

  @Override
  public void initialize() {
    int index = (int) (Math.random() * this.wordList.size());
    this.word = this.wordList.get(index);
  }

  @Override
  public boolean makeGuess(char letter) throws IllegalArgumentException, IllegalStateException {
    // Make sure letter is lowercase.
    char guessedLetter = Character.toLowerCase(letter);
    // Check that the game is not over.
    if (isGameOver()) {
      throw new IllegalStateException("The game is over.");
    }
    // Check that the letter is not already guessed.
    if (guessedLetters.contains(String.valueOf(guessedLetter))) {
      throw new IllegalArgumentException("The letter has already been guessed.");
    }
    // Check if the letter is in the word.
    if (word.indexOf(guessedLetter) == -1) {
      guessesRemaining--;
      guessedLetters += guessedLetter;
      return false;
    } else {
      // Update the current state.
      StringBuilder newCurrentState = new StringBuilder(currentState);
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == guessedLetter) {
          newCurrentState.setCharAt(i, guessedLetter);
        }
      }
      currentState = newCurrentState.toString();
      guessedLetters += guessedLetter;
      return true;
    }
  }

  @Override
  public boolean isGameOver() {
    return guessesRemaining == 0 || !currentState.contains("_");
  }

  @Override
  public String getCurrentState() {
    return this.currentState;
  }

  @Override
  public int getGuessesRemaining() {
    return this.guessesRemaining;
  }

  /**
   * Gets a random word from the file at fileName.
   *
   * @param fileName The file to read words from. The file should contain one word per line. The
   *                 file should be encoded in UTF-8.
   * @throws IllegalStateException if the file is empty.
   */
  private void getWordList(String fileName) {
    Path path = Paths.get(fileName);
    if (path.toFile().length() == 0) {
      throw new IllegalStateException("The file is empty.");
    } else {
      try (Scanner scanner = new Scanner(path)) {
        while (scanner.hasNextLine()) {
          this.wordList.add(scanner.nextLine());
        }
      } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
      }
    }
  }

  @Override
  public String getAnswer() {
    return this.word;
  }

  @Override
  public String toString() {
    return "Word: " + this.word + "\n" + "Guessed letters: " + this.guessedLetters + "\n"
        + "Guesses remaining: " + this.guessesRemaining + "\n" + "Current state: "
        + this.currentState;
  }

  /**
   * Initializes current state to be a string of underscores with the same length as the word.
   */
  private void initializeCurrentState() {
    this.currentState = "_".repeat(this.word.length());
  }

}
