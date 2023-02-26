package edu.csc1061.ch18;

// Recursive Palindrome Using Substring
public class Ch18Program03 {

  public static boolean isPalindrome(String s) {
    // Base case
    if (s.length() <= 1) {
      return true;
    }

    // Base case
    if (s.charAt(0) != s.charAt(s.length() - 1)) {
      return false;
    }

    return isPalindrome(s.substring(1, s.length() - 1));
  }

  /** Main method */
  public static void main(String[] args) {

    // Punctuation, capitalization, and spaces are usually ignored.
    String[] wordList =
        {"a", "aba", "ab", "kayak", "level", "madam", "radar", "cat", "taco", "tacocat", "tacoCat",
            "TacOcaT", "was it a car or a cat i saw", "live on time emit no evil"};

    for (String word : wordList) {
      System.out.println("Is \"" + word + "\" a palindrome? " + isPalindrome(word));
    }
  }
}
