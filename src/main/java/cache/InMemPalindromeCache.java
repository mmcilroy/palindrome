package cache;

import java.util.HashSet;
import java.util.Set;

/**
 * InMemPalindromeCache is a very simple PalindromeCache implementation used mainly
 * to help write unit tests
 */
public class InMemPalindromeCache implements PalindromeCache {
    private Set<String> cache;

    public InMemPalindromeCache() {
        this.cache = new HashSet<>();
    }

    public void remove(String palindrome) {
        this.cache.remove(palindrome);
    }

    @Override
    public void add(String palindrome) {
        this.cache.add(palindrome);
    }

    @Override
    public boolean contains(String palindrome) {
        return this.cache.contains(palindrome);
    }
}
