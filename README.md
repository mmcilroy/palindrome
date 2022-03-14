# palindrome

A REST API for checking palindromes.

To build...
```
mvn clean compile assembly:single
```

To run unit tests...
```
mvn test
```

To launch the application...
```
java -jar target/palindrome-1.0-SNAPSHOT-jar-with-dependencies.jar 
```

To issue a HTTP request to the application...
```
curl http://localhost:4567/palindrome/racecar
YES
curl http://localhost:4567/palindrome/nope    
NO
```