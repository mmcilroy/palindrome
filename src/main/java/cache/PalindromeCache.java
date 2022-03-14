package cache;

/**
 * PalindromeCache is an interface for adding palindromes to a cache and also
 * checking for the presence of a palindrome in that cache
 */
public interface PalindromeCache {
    void add(String palindrome);
    boolean contains(String palindrome);
}
