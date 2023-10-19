/**
 * Code for Class.
 *
 * <p>CSC 1061 - Computer Science II - Java
 *
 * @author Patrick McDougle
 * @version %I%, %G%
 * @since 1.0
 */
package edu.csc1061.ch20;

import java.util.Stack;

public class Ch20Program07 {
  private static final String EXPRESSION_IS = "Expression is: ";
  private static final String DEFAULT_OPERATOR_MESSAGER = "An Invalid Operator was detected!";

  public static void main(String[] args) {
    try {
      Ch20Program07 seven = new Ch20Program07();

      String expression = "51 + (54 * (3 + 2))";
      System.out.println(EXPRESSION_IS + expression);
      System.out.println(seven.evaluateExpression(expression));

      expression = "(1 + 3 * 3 - 2) * (12 / 6 * 5)";
      System.out.println(EXPRESSION_IS + expression);
      System.out.println(seven.evaluateExpression(expression));

      expression = "(1 + 2 * 4) - 3";
      System.out.println(EXPRESSION_IS + expression);
      System.out.println(seven.evaluateExpression(expression));

      // is the answer 1 or 9???
      expression = "6/2*(2+1)";
      System.out.println(EXPRESSION_IS + expression);
      System.out.println(EXPRESSION_IS + seven.insertBlanks(expression));
      System.out.println(seven.evaluateExpression(expression));
    } catch (Exception ex) {
      System.out.println("Wrong expression!" + ex.getMessage());
    }
  }

  /** Evaluate an expression */
  public int evaluateExpression(String expression) {

    // In JDK 10 and later, you can declare local variables with non-null initializers with the var
    // identifier, which can help you write code that’s easier to read.

    // Create operandStack to store operands
    var operandStack = new Stack<Integer>();

    // Create operatorStack to store operators
    var operatorStack = new Stack<Character>();

    // Insert blanks around (, ), +, -, /, and *
    expression = insertBlanks(expression);

    // Extract operands and operators
    var tokens = expression.split(" ");

    // Phase 1: Scanning the expression
    // The program scans the expression from left to right to extract operands,
    // operators, and the parentheses.
    // 1.1. If the extracted item is an operand, push it to operandStack.
    // 1.2. If the extracted item is a + or - operator, process all the operators at
    // the top of operatorStack and push the extracted operator to operatorStack.
    // 1.3. If the extracted item is a * or / operator, process the * or / operators
    // at the top of operatorStack and push the extracted operator to operatorStack.
    // 1.4. If the extracted item is a ( symbol, push it to operatorStack.
    // 1.5. If the extracted item is a ) symbol, repeatedly process the operators
    // from the top of operatorStack until seeing the ( symbol on the stack.

    // Phase 1: Scan tokens
    for (String token : tokens) {
      if (token.length() == 0) { // Blank space
        continue; // Back to the for loop to extract the next token
      }

      if (token.charAt(0) == '+' || token.charAt(0) == '-') {
        // Process all +, -, *, / in the top of the operator stack
        while (!operatorStack.isEmpty()
            && (operatorStack.peek() == '+'
                || operatorStack.peek() == '-'
                || operatorStack.peek() == '*'
                || operatorStack.peek() == '/')) {
          processAnOperator(operandStack, operatorStack);
        }

        // Push the + or - operator into the operator stack
        operatorStack.push(token.charAt(0));
      } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
        // Process all *, / in the top of the operator stack
        while (!operatorStack.isEmpty()
            && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
          processAnOperator(operandStack, operatorStack);
        }

        // Push the * or / operator into the operator stack
        operatorStack.push(token.charAt(0));
      } else if (token.trim().charAt(0) == '(') {
        operatorStack.push('('); // Push '(' to stack
      } else if (token.trim().charAt(0) == ')') {
        // Process all the operators in the stack until seeing '('
        while (operatorStack.peek() != '(') {
          processAnOperator(operandStack, operatorStack);
        }

        operatorStack.pop(); // Pop the '(' symbol from the stack
      } else { // An operand scanned
        // Push an operand to the stack
        operandStack.push(Integer.valueOf(token));
      }
    }

    // Phase 2: Clearing the stack
    // Repeatedly process the operators from the top of operatorStack until
    // operatorStack is empty.

    // Phase 2: process all the remaining operators in the stack
    while (!operatorStack.isEmpty()) {
      processAnOperator(operandStack, operatorStack);
    }

    // Return the result
    return operandStack.pop();
  }

  /**
   * Process one operator: Take an operator from operatorStack and apply it on the operands in the
   * operandStack
   */
  private void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
    char operator = operatorStack.pop();
    int operand1 = operandStack.pop();
    int operand2 = operandStack.pop();

    switch (operator) {
      case '+':
        operandStack.push(operand2 + operand1);
        break;
      case '-':
        operandStack.push(operand2 - operand1);
        break;
      case '*':
        operandStack.push(operand2 * operand1);
        break;
      case '/':
        operandStack.push(operand2 / operand1);
        break;
      default:
        throw new IllegalArgumentException(DEFAULT_OPERATOR_MESSAGER);
    }
  }

  public String insertBlanks(String s) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '('
          || s.charAt(i) == ')'
          || s.charAt(i) == '+'
          || s.charAt(i) == '-'
          || s.charAt(i) == '*'
          || s.charAt(i) == '/') {
        result.append(' ');
        result.append(s.charAt(i));
        result.append(' ');

      } else if (s.charAt(i) == ' ') {
        // ignore original blanks.
      } else {
        result.append(s.charAt(i));
      }
    }

    return result.toString();
  }
}
