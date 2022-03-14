package core;

/**
 * A simple decorator that can be added to a PalindromeChecker to ensure palindromes containing
 * a space are invalid
 */
public class NoSpacesPalindromeChecker extends PalindromeChecker {
    private PalindromeChecker checker;

    public NoSpacesPalindromeChecker(PalindromeChecker checker) {
        this.checker = checker;
    }

    public boolean isPalindrome(String input) {
        if (input.contains(" ")) {
            return false;
        }
        return checker.isPalindrome(input);
    }
}
