import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import hangman.HangmanModel;
import hangman.HangmanModelImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the HangmanModelImpl class.
 */
public class HangmanModelImplTest {

  HangmanModel hangmanModelEasy;

  /**
   * Sets up the test fixture.
   */
  @Before public void setUp() {
    this.hangmanModelEasy = new HangmanModelImpl("res/words-test.txt");
  }

  /**
   * Tests the initialize method. We check that we always get a word from the list.
   */
  @Test public void initialize() {
    HangmanModel hangmanModel = new HangmanModelImpl("res/words.txt");

    // We cannot check the word, but we can check its length is greater than zero.
    for (int i = 0; i < 100; i++) {
      hangmanModel.initialize();
      String word = hangmanModel.getCurrentState();
      assertFalse(word.isEmpty());
    }

    // We can check the exact length of the word.
    hangmanModelEasy.initialize();
    String word = hangmanModelEasy.getCurrentState();
    assertEquals(9, word.length());
    assertEquals("algorithm", hangmanModelEasy.getAnswer());
  }

  /**
   * Tests the constructor throws exception when file does not exist.
   */
  @Test(expected = IllegalStateException.class)
  public void testInitializeThrowsExceptionWhenFileDoesNotExist() {
    HangmanModel hangmanModel = new HangmanModelImpl("res/words-not-here.txt");
    hangmanModel.initialize();
  }

  /**
   * Tests the constructor throws exception when file is empty.
   */
  @Test(expected = IllegalStateException.class)
  public void testInitializeThrowsExceptionWhenFileIsEmpty() {
    HangmanModel hangmanModel = new HangmanModelImpl("res/words-empty-test.txt");
    hangmanModel.initialize();
  }

  /**
   * Tests the makeGuess method.
   */
  @Test
  public void makeGuess() {
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());

    assertTrue(hangmanModelEasy.makeGuess('a'));
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());

    assertTrue(hangmanModelEasy.makeGuess('l'));
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());

    assertTrue(hangmanModelEasy.makeGuess('g'));
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());

    assertFalse(hangmanModelEasy.makeGuess('z'));
    assertEquals(5, hangmanModelEasy.getGuessesRemaining());

    assertFalse(hangmanModelEasy.makeGuess('x'));
    assertEquals(4, hangmanModelEasy.getGuessesRemaining());

  }

  /**
   * Test capital and lowercase letters are treated the same.
   */
  @Test
  public void makeGuessCapitalAndLowercase() {
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());

    assertTrue(hangmanModelEasy.makeGuess('a'));
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());

    assertTrue(hangmanModelEasy.makeGuess('L'));
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());

    assertTrue(hangmanModelEasy.makeGuess('G'));
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());

    assertFalse(hangmanModelEasy.makeGuess('Z'));
    assertEquals(5, hangmanModelEasy.getGuessesRemaining());

    assertFalse(hangmanModelEasy.makeGuess('x'));
    assertEquals(4, hangmanModelEasy.getGuessesRemaining());

  }

  /**
   * Tests the isGameOver method.
   */
  @Test
  public void isGameOver() {
    assertFalse(hangmanModelEasy.isGameOver());
    hangmanModelEasy.makeGuess('a');
    assertFalse(hangmanModelEasy.isGameOver());
    hangmanModelEasy.makeGuess('l');
    assertFalse(hangmanModelEasy.isGameOver());
    hangmanModelEasy.makeGuess('g');
    assertFalse(hangmanModelEasy.isGameOver());
    hangmanModelEasy.makeGuess('o');
    assertFalse(hangmanModelEasy.isGameOver());
    hangmanModelEasy.makeGuess('r');
    assertFalse(hangmanModelEasy.isGameOver());
    hangmanModelEasy.makeGuess('i');
    assertFalse(hangmanModelEasy.isGameOver());
    hangmanModelEasy.makeGuess('t');
    assertFalse(hangmanModelEasy.isGameOver());
    hangmanModelEasy.makeGuess('h');
    assertFalse(hangmanModelEasy.isGameOver());
    hangmanModelEasy.makeGuess('m');
    assertTrue(hangmanModelEasy.isGameOver());
  }

  /**
   * Tests the current state method.
   */
  @Test
  public void getCurrentState() {
    String expectedWord = "_________";
    assertEquals(expectedWord, hangmanModelEasy.getCurrentState());

    hangmanModelEasy.makeGuess('a');
    expectedWord = "a________";
    assertEquals(expectedWord, hangmanModelEasy.getCurrentState());

    hangmanModelEasy.makeGuess('l');
    expectedWord = "al_______";
    assertEquals(expectedWord, hangmanModelEasy.getCurrentState());
  }

  /**
   * Tests the getGuessesRemaining method.
   */
  @Test
  public void testGetGuessesRemaining() {
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('a');
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('l');
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('b');
    assertEquals(5, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('c');
    assertEquals(4, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('d');
    assertEquals(3, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('e');
    assertEquals(2, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('f');
    assertEquals(1, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('y');
    assertEquals(0, hangmanModelEasy.getGuessesRemaining());
  }

  /**
   * Tests the getGuessesRemaining method throws exception when game is over.
   */
  @Test(expected = IllegalStateException.class)
  public void testGetGuessesRemainingThrowsExceptionsWhenGameIsOver() {
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('b');
    assertEquals(5, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('c');
    assertEquals(4, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('d');
    assertEquals(3, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('e');
    assertEquals(2, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('f');
    assertEquals(1, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('y');
    assertEquals(0, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('x');
  }

  /**
   * Tests the getGuessesRemaining method throws exception when letter has already been used.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGuessesRemainingThrowsExceptionWhenLetterIsRepeated() {
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('a');
    assertEquals(6, hangmanModelEasy.getGuessesRemaining());
    hangmanModelEasy.makeGuess('a');
  }

  /**
   * Test getAnswer method.
   */
  @Test
  public void testGetAnswer() {
    assertEquals("algorithm", hangmanModelEasy.getAnswer());
  }
}