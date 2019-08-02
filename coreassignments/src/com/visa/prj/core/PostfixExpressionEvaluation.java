package com.visa.prj.core;


import java.util.Stack;

/**
 * 
 * Postfix expression evaluation
 * 
 * @author banu 
 * 
 */
public class PostfixExpressionEvaluation {

	/**
	 * Evaluates a given postfix expression
	 * 
	 * @param input
	 *            A postfix string where the operands and operators are
	 *            available as a sequence of parsed tokens
	 * @return an integer corresponding to the value of the postfix expression.
	 */
	public int evalPostfixExpression(String[] input) {
		Stack<Integer> result = new Stack<Integer>();
		int num = 0;
		for (String s: input) {
			try {
				num = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				int y = result.pop();
				int x = result.pop();
				if (s.equals("+"))
					num = x + y;
				else if (s.equals("-"))
					num = x - y;
				else if (s.equals("*"))
					num = x * y;
				else if (s.equals("/"))
					num = x / y;
			}
			result.push(num);
		}
		return result.pop();
	}
}
