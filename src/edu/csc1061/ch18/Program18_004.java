package edu.csc1061.ch18;

public class Program18_004 {

	public static boolean isPalindrome(String s) {
		return isPalindrome(s, 0, s.length() - 1);
	}

	public static boolean isPalindrome(String s, int low, int high) {
		if (high <= low) // Base case
			return true;
		if (s.charAt(low) != s.charAt(high)) // Base case
			return false;

		return isPalindrome(s, low + 1, high - 1);
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
