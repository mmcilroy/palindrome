import cache.InMemPalindromeCache;
import core.PalindromeApp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPalindromeApp {

    @Test
    void testCachedPalindrome() {
        InMemPalindromeCache cache = new InMemPalindromeCache();
        PalindromeApp app = new PalindromeApp(cache);

        cache.add("123");
        assertTrue(app.isPalindrome("123"));

        cache.remove("123");
        assertFalse(app.isPalindrome("123"));
    }

    @Test
    void testUncachedPalindrome() {
        InMemPalindromeCache cache = new InMemPalindromeCache();
        PalindromeApp app = new PalindromeApp(cache);
        assertTrue(app.isPalindrome("kayak"));
        assertFalse(app.isPalindrome("123"));
    }
}
