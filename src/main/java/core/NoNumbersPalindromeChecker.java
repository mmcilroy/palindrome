package core;

/**
 * A simple decorator that can be added to a PalindromeChecker to ensure palindromes containing
 * a digit are invalid
 */
public class NoNumbersPalindromeChecker extends PalindromeChecker {
    private PalindromeChecker checker;

    public NoNumbersPalindromeChecker(PalindromeChecker checker) {
        this.checker = checker;
    }

    public boolean isPalindrome(String input) {
        if (input.matches("[0-9]+")) {
            return false;
        }
        return checker.isPalindrome(input);
    }
}
