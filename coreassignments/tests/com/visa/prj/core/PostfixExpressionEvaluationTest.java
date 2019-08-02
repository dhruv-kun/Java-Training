package com.visa.prj.core;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PostfixExpressionEvaluationTest {

	@Test
	public void UTC04_01() {
		String[] input = new String[] { "7", "3", "-", "5", "8", "+", "*" };
		int expected = 52;
		PostfixExpressionEvaluation object = new PostfixExpressionEvaluation();
		int actual = object.evalPostfixExpression(input);
		assertEquals(expected, actual);
	}

	@Test
	public void UTC04_02() {
		String[] input = new String[] { "12", "3", "/", "4", "+" };
		int expected = 8;
		PostfixExpressionEvaluation object = new PostfixExpressionEvaluation();
		int actual = object.evalPostfixExpression(input);
		assertEquals(expected, actual);
	}

	@Test
	public void UTC04_03() {
		String[] input = new String[] { "5", "28", "14", "-", "*", "2", "/",
				"49", "7", "/", "+" };
		int expected = 42;
		PostfixExpressionEvaluation object = new PostfixExpressionEvaluation();
		int actual = object.evalPostfixExpression(input);
		assertEquals(expected, actual);
	}

}

