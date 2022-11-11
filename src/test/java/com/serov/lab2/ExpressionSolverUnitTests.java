package com.serov.lab2;

import org.junit.jupiter.api.TestInstance;

import com.serov.exceptions.DivisionByZeroException;
import com.serov.exceptions.InvalidCharacterException;
import com.serov.exceptions.InvalidOperandException;
import com.serov.exceptions.NullOperatorException;
import com.serov.solver.ExpressionSolver;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Testing the Container implementation
 * @author n.a.serov
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ExpressionSolverUnitTests {

	private ExpressionSolver exprSolver;
	
	@Test
	public void testUnaryOperators() {
		exprSolver = new ExpressionSolver("sin45");
		String solverResult = exprSolver.solve();
		String result = Double.toString(Math.sin(Math.toRadians(45)));
		assertEquals(solverResult,result);
		exprSolver = new ExpressionSolver("cos45");
		solverResult = exprSolver.solve();
		result = Double.toString(Math.cos(Math.toRadians(45)));
		assertEquals(solverResult,result);
		exprSolver = new ExpressionSolver("tan100");
		solverResult = exprSolver.solve();
		result = Double.toString(Math.tan(Math.toRadians(100)));
		assertEquals(solverResult,result);
	}
	
	@Test
	public void testBinaryOperators() {
		exprSolver = new ExpressionSolver("10+5");
		String solverResult = exprSolver.solve();
		String result = "15.0";
		assertEquals(solverResult,result);
		exprSolver = new ExpressionSolver("10-5");
		solverResult = exprSolver.solve();
		result = "5.0";
		assertEquals(solverResult,result);
		exprSolver = new ExpressionSolver("10*5");
		solverResult = exprSolver.solve();
		result = "50.0";
		assertEquals(solverResult,result);
		exprSolver = new ExpressionSolver("10/5");
		solverResult = exprSolver.solve();
		result = "2.0";
		assertEquals(solverResult,result);
	}
	
	@Test
	public void testNoOperators() {
		exprSolver = new ExpressionSolver("10");
		String solverResult = exprSolver.solve();
		String result = "10.0";
		assertEquals(solverResult, result);
	}
	
	@Test
	public void testNoOperands() {
		exprSolver = new ExpressionSolver("+");
		 assertThrows(InvalidCharacterException.class, () -> {
	            exprSolver.solve();
	     });
	}
	
	@Test
	public void testDivideByZero() {
		exprSolver = new ExpressionSolver("1/0");
		 assertThrows(DivisionByZeroException.class, () -> {
	            exprSolver.solve();
	     });
	}
	
	@Test
	public void testParenthesesMismatch() {
		exprSolver = new ExpressionSolver("(34+1");
		 assertThrows(InvalidCharacterException.class, () -> {
	            exprSolver.solve();
	     });
	}
	
	@Test
	public void testMultipleOperators() {
		exprSolver = new ExpressionSolver("3*/5");
		 assertThrows(NullOperatorException.class, () -> {
	            exprSolver.solve();
	     });
	}
	
	@Test
	public void testNoDigitsAfterPoint() {
		exprSolver = new ExpressionSolver("3.+1");
		 assertThrows(InvalidCharacterException.class, () -> {
	            exprSolver.solve();
	     });
	}
	
	@Test
	public void testTwoPointsAfterDigit() {
		exprSolver = new ExpressionSolver("3..1+1");
		 assertThrows(InvalidCharacterException.class, () -> {
	            exprSolver.solve();
	     });
	}
}