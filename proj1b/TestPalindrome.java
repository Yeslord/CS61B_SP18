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
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testisPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("A"));
        assertTrue(palindrome.isPalindrome(" "));
        assertTrue(palindrome.isPalindrome("abb",new OffByOne()));
        assertTrue(palindrome.isPalindrome("bbca",new OffByOne()));
        assertTrue(palindrome.isPalindrome("A",new OffByOne()));
        assertTrue(palindrome.isPalindrome(" ",new OffByOne()));
        assertTrue(palindrome.isPalindrome("abc",new OffByN(2)));
        assertTrue(palindrome.isPalindrome("cbda",new OffByN(2)));
    }
}
