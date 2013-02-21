package com.jacksay.matrix;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacksay
 */
public class MatrixTest {
    
    private Matrix<String, Double> diagonalMatrix;
    private Matrix<String, Double> manuelMatrix;
    
    public MatrixTest() {
        diagonalMatrix = new Matrix<String, Double>(new String[]{"A", "B", "C"}, Matrix.DIAGONAL);

        manuelMatrix = new Matrix<String, Double>(new String[]{"A", "B", "C"}, new Double[][]{{0.0, 0.1, 0.2},
                    {1.0, 1.1, 1.2},
                    {2.0, 2.1, 2.2}}, Matrix.FREE, .0);

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLine method, of class Matrix.
     */
    @Test
    public void testGetLine() {
    }

    /**
     * Test of setValue method, of class Matrix.
     */
    @Test
    public void testSetValue() {
        diagonalMatrix.setValue("A", "B", 1.0);
        
        // Test if diagonal is well mirror
        assertEquals(1.0, diagonalMatrix.getValue("A", "B"), 0.0);
        assertEquals(1.0, diagonalMatrix.getValue("B", "A"), 0.0);
        
    }

    /**
     * Test of getValue method, of class Matrix.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        
    }

    /**
     * Test of getColumnValues method, of class Matrix.
     */
    @Test
    public void testGetColumnValues() {
        System.out.println("getColumnValues");
        assertEquals(3, manuelMatrix.getColumnValues("A").size());
        assertEquals(3, manuelMatrix.getColumnValues("B").size());
        assertEquals(3, manuelMatrix.getColumnValues("C").size());
    }

    /**
     * Test of getLineValues method, of class Matrix.
     */
    @Test
    public void testGetLineValues() {
        System.out.println("getLineValues");
        assertEquals(3, manuelMatrix.getLineValues("A").size());
        assertEquals(3, manuelMatrix.getLineValues("B").size());
        assertEquals(3, manuelMatrix.getLineValues("C").size());
    }

    /**
     * Test of toString method, of class Matrix.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        String result = manuelMatrix.toString();
        System.out.println(result);
        //assertEquals(expResult, result);
    }

    /**
     * Test of iterator method, of class Matrix.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        String s = "";
        for( Double d : manuelMatrix ){
            s+= "-"+d;
        }
        assertEquals("-0.0-0.1-0.2-1.0-1.1-1.2-2.0-2.1-2.2", s);
    }
}
