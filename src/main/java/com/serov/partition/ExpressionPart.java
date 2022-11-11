package com.serov.partition;

/**
 * ExpressionPart class implementation
 * @author n.a.serov
 *
 */
public class ExpressionPart {
    private String expressionPart;

    /**
     * ExpressionPart constructor with given string
     * @param expressionPart string to set the expressionPart
     */
    public ExpressionPart(String expressionPart) {
        this.expressionPart = expressionPart;
    }

    /**
     * Returns the expression part
     * @return returns the expressionPart value
     */
    public String getExpressionPart() {
        return expressionPart;
    }

    /**
     * Sets the expression part
     * @param expressionPart the expression part to be set
     */
    public void setExpressionPart(String expressionPart) {
        this.expressionPart = expressionPart;
    }
}