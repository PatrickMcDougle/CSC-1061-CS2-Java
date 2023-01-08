package edu.csc1061.ch18;

// Recursive Palindrome Using Substring
public class Program18_003 {

  public static boolean isPalindrome(String s) {
    if (s.length() <= 1) return true; else if ( // Base case
      s.charAt(0) != s.charAt(s.length() - 1)
    ) return false; // Base case

    return isPalindrome(s.substring(1, s.length() - 1));
  }

  /** Main method */
  public static void main(String[] args) {
    System.out.println("Is moon a palindrome? " + isPalindrome("moon"));
    System.out.println("Is noon a palindrome? " + isPalindrome("noon"));
    System.out.println("Is a a palindrome? " + isPalindrome("a"));
    System.out.println("Is aba a palindrome? " + isPalindrome("aba"));
    System.out.println("Is ab a palindrome? " + isPalindrome("ab"));
    System.out.println("Is cat a palindrome? " + isPalindrome("cat"));
    System.out.println("Is taco a palindrome? " + isPalindrome("taco"));
    System.out.println("Is tacocat a palindrome? " + isPalindrome("tacocat"));
  }
}
