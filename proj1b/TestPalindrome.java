import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    /** tests to see if palindrome words are said to be palindrome */
    @Test
    public void testIsPalindrome(){
        assertEquals(true, palindrome.isPalindrome(""));
        assertEquals(true, palindrome.isPalindrome("a"));
        assertEquals(true, palindrome.isPalindrome("A"));
        assertEquals(true, palindrome.isPalindrome("helleh"));

    }

    /** tests to see if non-palindrome words are said to be palindrome */
    @Test
    public void testIsNotPalindrome(){
        assertEquals(false, palindrome.isPalindrome("aA"));
        assertEquals(false, palindrome.isPalindrome("nope"));
        assertEquals(false, palindrome.isPalindrome("Aasdkvajsdn"));

    }



}

