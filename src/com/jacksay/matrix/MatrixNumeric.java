package com.jacksay.matrix;

import java.util.Collection;

/**
 * Specific matrix for numeric data. Provide functionalities for calculate 
 * sum of lines, columns and global sum.
 * 
 * @author jacksay
 */
public class MatrixNumeric<E> extends Matrix<E, Double> {
    
    
    public MatrixNumeric(E[] rowsCols) {
        super(rowsCols);
    }

    public MatrixNumeric(Collection<E> rowsCols, Double defaultValue) {
        super(rowsCols, FREE, defaultValue);
    }
    
    public MatrixNumeric(Collection<E> rowsCols, boolean isDiagonal, Double defaultValue) {
        super(rowsCols, isDiagonal, defaultValue);
    }

    public MatrixNumeric(E[] rowsCols, Double[][] values, boolean isDiagonal, Double defaultValue) {
        super(rowsCols, values, isDiagonal, defaultValue);
    }
    
    /**
     * Return sum of all cells for line specified.
     * 
     * @param line
     * @return double
     */
    public double getTotalLine( E line )
    {
        double tmpTotalLine = 0.0;
        for(Double d : getLineValues(line)){
            tmpTotalLine += d;
        }
        return tmpTotalLine;
    }
    
    /**
     * Return sum of all cells for column specified.
     * 
     * @param column
     * @return double
     */
    public double getTotalColunm( E column )
    {
        double tmpTotalColumn = 0.0;
        for(Double d : getColumnValues(column)){
            tmpTotalColumn += d;
        }
        return tmpTotalColumn;
    } 
    
    /**
     * Return sum of all cells.
     * 
     * @return double
     */
    public double getTotal()
    {
        double tmpTotalColumn = 0.0;
        for (double d : this) {
            tmpTotalColumn += d;
        }
        return tmpTotalColumn;
    }  
}
