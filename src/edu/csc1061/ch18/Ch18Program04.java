package edu.csc1061.ch18;

public class Ch18Program04 {

  public static boolean isPalindrome(String s) {
    return isPalindrome(s, 0, s.length() - 1);
  }

  public static boolean isPalindrome(String s, int low, int high) {
    // Base case
    if (high <= low) {
      return true;
    }
    // Base case
    if (s.charAt(low) != s.charAt(high)) {
      return false;
    }

    return isPalindrome(s, low + 1, high - 1);
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