package edu.csc1061.ch10;

public class Program10_RegularExpression {

	public static void main(String[] args) {

		String w = "Welcome";

		System.out.println(w.replace('e', 'A'));
		System.out.println(w.replaceFirst("e", "AB"));
		System.out.println(w.replace("e", "AB"));
		System.out.println(w.replace("el", "AB"));
		System.out.println();

		String[] tokens1 = "Java#HTML#Perl".split("#", 0);
		for (int i = 0; i < tokens1.length; i++)
			System.out.print(tokens1[i] + " ");
		System.out.println();

		System.out.println("Java".matches("Java") ? "TRUE" : "FALSE");
		System.out.println("Java".equals("Java") ? "TRUE" : "FALSE");

		// Regular Expressions (hover over for info)
		System.out.println("Java is fun".matches("Java.*") ? "TRUE" : "FALSE");
		System.out.println("Java is cool".matches("Java.*") ? "TRUE" : "FALSE");
		System.out.println("Cool is Java".matches("Java.*") ? "TRUE" : "FALSE");
		System.out.println();

		String s = "a+b$#c".replaceAll("[$+#]", "NNN");
		// Here the regular expression [$+#] specifies a pattern that matches $, +, or
		// #.
		System.out.println(s);
		System.out.println();

		String[] tokens2 = "Java,C?C#,C++".split("[.,:;?]");

		for (int i = 0; i < tokens2.length; i++)
			System.out.println(tokens2[i]);
		System.out.println();

		System.out.println("Java Java Java".replaceAll("v\\w", "wi"));
		System.out.println("Java Java Java".replaceFirst("v\\w", "wi"));

		String[] tokens3 = "Java1HTML2Perl".split("\\d");
		for (int i = 0; i < tokens3.length; i++)
			System.out.println(tokens3[i]);
		System.out.println();

	}
}
