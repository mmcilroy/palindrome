package cache;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

/**
 * OnDiskPalindromeCache is a PalindromeCache implementation that reads cached
 * palindromes from a file during construction
 */
public class OnDiskPalindromeCache implements PalindromeCache {
    private String path;
    private Set<String> cache;

    /**
     * Loads cached palindromes from file
     *
     * @param path
     * @throws Exception
     */
    public OnDiskPalindromeCache(String path) throws Exception {
        this.path = path;
        this.cache = new HashSet<>();
        Files.lines(Path.of(path)).forEach(line -> {
            System.out.println("adding " + line + " to cache");
            cache.add(line);
        });
    }

    /**
     * Adds a new palindrome to the cache file
     *
     * @param palindrome
     */
    @Override
    public synchronized void add(String palindrome) {
        try {
            Path path = Paths.get(this.path);
            Files.write(path, palindrome.getBytes(), StandardOpenOption.APPEND);
            Files.write(path, "\n".getBytes(), StandardOpenOption.APPEND);
            this.cache.add(palindrome);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns true if the supplied palindrome is found in the cache
     *
     * @param palindrome
     * @return
     */
    @Override
    public boolean contains(String palindrome) {
        return this.cache.contains(palindrome);
    }
}
