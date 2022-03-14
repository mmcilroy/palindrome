package core;

/**
 * Simple class to check palindromes
 */
public class PalindromeChecker {
    /**
     * Returns true is string is palindrome, false if not
     *
     * @param input
     * @return
     */
    public boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.compareTo(reversed) == 0;
    }
}
