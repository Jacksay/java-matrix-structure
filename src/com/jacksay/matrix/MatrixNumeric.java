package com.jacksay.matrix;

import java.util.Collection;
import java.util.Iterator;

/**
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

    public MatrixNumeric(E[] rowsCols, Double[][] values, boolean isDiagonal, Double defaultValue) {
        super(rowsCols, values, isDiagonal, defaultValue);
    }
    
    

    @Override
    public void setValue(E x, E y, Double value) {
        super.setValue(x, y, value); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    public double getTotalLine( E line )
    {
        double tmpTotalLine = 0.0;
        for(Double d : getLineValues(line)){
            tmpTotalLine += d;
        }
        return tmpTotalLine;
    }
    
    public double getTotalColunm( E column )
    {
        double tmpTotalColumn = 0.0;
        for(Double d : getColumnValues(column)){
            tmpTotalColumn += d;
        }
        return tmpTotalColumn;
    } 
    
    public double getTotal()
    {
        double tmpTotalColumn = 0.0;
        for (double d : this) {
            tmpTotalColumn += d;
        }
        return tmpTotalColumn;
    }  
}
