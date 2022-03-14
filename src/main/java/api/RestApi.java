package api;

import cache.OnDiskPalindromeCache;
import core.PalindromeApp;

import static spark.Spark.get;

/**
 * Bootstraps a REST API for checking if a string is a palindrome
 * Once the app is launched you can test it like so...
 *
 * curl http://localhost:4567/palindrome/racecar
 * YES
 */
public class RestApi {
    public static void main(String[] args) throws Exception {
        PalindromeApp app = new PalindromeApp(new OnDiskPalindromeCache("cache"));

        get("/palindrome/:input", (req, res) -> {
            String palindrome = req.params(":input");
            return app.isPalindrome(palindrome) ? "YES\n" : "NO\n";
        });
    }
}
