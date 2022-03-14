import core.NoNumbersPalindromeChecker;
import core.NoSpacesPalindromeChecker;
import core.PalindromeChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPalindromeChecker {

    @Test
    void testValidPalindromes() {
        PalindromeChecker checker = new PalindromeChecker();
        checker = new NoNumbersPalindromeChecker(checker);
        checker = new NoSpacesPalindromeChecker(checker);
        assertTrue(checker.isPalindrome(""));
        assertTrue(checker.isPalindrome("ss"));
        assertTrue(checker.isPalindrome("madam"));
        assertTrue(checker.isPalindrome("kayak"));
        assertTrue(checker.isPalindrome("refer"));
        assertTrue(checker.isPalindrome("racecar"));
    }

    @Test
    void testInvalidPalindromes() {
        PalindromeChecker checker = new PalindromeChecker();
        checker = new NoNumbersPalindromeChecker(checker);
        checker = new NoSpacesPalindromeChecker(checker);
        assertFalse(checker.isPalindrome("invalid"));
        assertFalse(checker.isPalindrome("chicago"));
        assertFalse(checker.isPalindrome("exchange"));

        assertFalse(checker.isPalindrome("one one"));
        assertFalse(checker.isPalindrome("11"));

    }
}
