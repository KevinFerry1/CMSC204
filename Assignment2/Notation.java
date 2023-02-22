/*
 * Class: CMSC204 
 * Instructor: Dr. Kuijt
 * Description: Utility class that has methods to convert from infix to postfix, postfix to infix, or evaluate a postfix expression into its double value answer.
 * Due: 2/24/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kevin Ferry
*/

public class Notation {
	public Notation() {
		
	}
	
	public static double evaluatePostfixExpression(java.lang.String postfixExpr) throws InvalidNotationFormatException {
		MyStack<String> valueStack = new MyStack<String>();
		char currentChar;
		int operand1 = 0, operand2 = 0, result = 0;
		double returnValue = 0.0;
		
		try {
			for (int i = 0; i < postfixExpr.length(); i++) {
				currentChar = postfixExpr.charAt(i);
				
				if (currentChar == ' ') {
					continue;
				}
				
				if (Character.isDigit(currentChar)) {
					valueStack.push(String.valueOf(currentChar));
					continue;
				}
				
				if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
					operand2 = Integer.parseInt(valueStack.pop());
					operand1 = Integer.parseInt(valueStack.pop());
				}
				
				switch (currentChar) {
					case '+': 
					result = operand1 + operand2;
					break;
					
					case '-': 
					result = operand1 - operand2;
					break;
					
					case '*': 
					result = operand1 * operand2;
					break;
					
					case '/':
					result = operand1 / operand2;
					break;
					
					default: 
						continue;
				}
				
				valueStack.push(String.valueOf(result));
			}
			returnValue = Double.parseDouble(valueStack.top());
		}
		catch (Exception x) {
			throw new InvalidNotationFormatException();
		}
		
		return returnValue;
	}
	
	public static java.lang.String convertPostfixToInfix(java.lang.String postfix) throws InvalidNotationFormatException {
		MyStack<String> stack = new MyStack<String>();
		char currentChar;
		String operand1, operand2, tempConcat;
		
		try {
			for (int i = 0; i < postfix.length(); i++) {
				currentChar = postfix.charAt(i);
				
				if (currentChar == ' ') {
					continue;
				}
				
				if (Character.isDigit(currentChar)) {
					stack.push(String.valueOf(currentChar));
					continue;
				}
				
				if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
					//gets two operands 
					operand2 = stack.pop();
					operand1 = stack.pop();
					
					tempConcat = "(" + operand1 + currentChar + operand2 + ")"; //puts the first operand and then the operator and then the second operand encased with paranthesis
					stack.push(tempConcat);
				}
			}
		}
		catch (Exception x) {
			throw new InvalidNotationFormatException();
		}
		
		return stack.toString();
	}
	
	public static java.lang.String convertInfixToPostfix(java.lang.String infix) throws InvalidNotationFormatException {
		MyStack<Character> operatorStack = new MyStack<Character>();
		MyQueue<Character> postfix = new MyQueue<Character>();
		char currentChar, topOperator;
		boolean isStartParen = false;
		int startParenCount = 0;
		
		try {
			for (int i = 0; i < infix.length(); i++) {
				currentChar = infix.charAt(i);
				
				if (currentChar == ' ') {
					continue;
				}
				
				if (Character.isDigit(currentChar)) {
					postfix.enqueue(currentChar); //appends to postfix
					continue;
				}
				
				if (currentChar == '+' || currentChar == '-') {
					while (!operatorStack.isEmpty() && !isStartParen && operatorStack.top().charValue() != '(') {
						postfix.enqueue(operatorStack.pop().charValue());
					}
					operatorStack.push(currentChar);
					continue;
				}
					
				if (currentChar == '*' || currentChar == '/') {
					while (!operatorStack.isEmpty() && (operatorStack.top().charValue() == '*' && operatorStack.top().charValue() == '/') && !isStartParen && operatorStack.top().charValue() != '(') {
						postfix.enqueue(operatorStack.pop().charValue());
					}
					operatorStack.push(currentChar);
					continue;
				}
				
				if (currentChar == '(') {
					operatorStack.push(currentChar);
					startParenCount++;
					isStartParen = true;
					continue;
				}
				
				if (currentChar == ')') {
					if (startParenCount == 0 && !isStartParen) { //operatorStack.isEmpty() || 
						throw new InvalidNotationFormatException();
					}
					
					topOperator = operatorStack.pop().charValue();
					while (topOperator != '(') {
						postfix.enqueue(topOperator);
						topOperator = operatorStack.pop().charValue();
					}
					
					isStartParen = false;
					startParenCount = startParenCount - 1;
				}
			}
			
			while (!operatorStack.isEmpty()) {
				postfix.enqueue(operatorStack.pop().charValue());
			}
		}
		catch (InvalidNotationFormatException y) {
			System.out.println("hey");
			throw new InvalidNotationFormatException();
		}
		catch (Exception x) {
			System.out.println("bruh");
			//System.out.println(x.getMessage());
			//throw new InvalidNotationFormatException();
		}
		
		return postfix.toString();
	}
}
