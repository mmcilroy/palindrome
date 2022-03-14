package core;

import cache.PalindromeCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * An application for checking if a string is a palindrome
 */
public class PalindromeApp {
    private PalindromeChecker checker;
    private PalindromeCache cache;
    private ExecutorService executor;

    public PalindromeApp(PalindromeCache cache) {
        this.cache = cache;
        this.executor = Executors.newSingleThreadExecutor();

        this.checker = new PalindromeChecker();
        this.checker = new NoNumbersPalindromeChecker(checker);
        this.checker = new NoSpacesPalindromeChecker(checker);
    }

    /**
     * Returns true is string is palindrome, false if not
     *
     * @param palindrome
     * @return
     */
    public boolean isPalindrome(String palindrome) {
        System.out.println("checking '" + palindrome + "'");

        // check if it already exists in cache
        boolean isPalindrome = cache.contains(palindrome);
        if (isPalindrome) {
            System.out.println("found '" + palindrome + "' in cache");
        } else {
            // if its not already in the cache then check it
            isPalindrome = checker.isPalindrome(palindrome);

            // add palindrome to the cache asynchronously
            if (isPalindrome) {
                executor.submit(() -> {
                    cache.add(palindrome);
                });
            }
        }

        return isPalindrome;
    }
}
