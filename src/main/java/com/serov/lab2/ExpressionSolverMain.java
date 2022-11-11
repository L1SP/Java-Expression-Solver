/**
 * 
 */
package com.serov.lab2;

import java.io.*;

import com.serov.solver.ExpressionSolver;

/**
 * The main application class
 * @author n.a.serov
 */
public class ExpressionSolverMain {

	/**
	 * Default constructor without parameters
	 */
	public ExpressionSolverMain() {}
	
    /**
     * The main function of the Expression solver program
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args) {
        String expression = "";
        if (args.length == 0) {
            System.out.println("Enter Expression ");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                expression = reader.readLine();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        if (args.length == 1) {
            expression = args[0];
        }
        if (args.length > 1) {
            System.out.println("Proper Usage is: java com.serov.lab2 your_expression_here");
            System.exit(0);
        }
        ExpressionSolver expr = new ExpressionSolver(expression);
        expr.solve();
    }
}