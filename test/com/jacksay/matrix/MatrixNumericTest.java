package com.jacksay.matrix;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacksay
 */
public class MatrixNumericTest {
    
    public MatrixNumericTest() {
    }

    @Test
    public void testSomeMethod() {
        List<String> keys = new ArrayList<String>();
        keys.add("Ko");
        keys.add("Mo");
        keys.add("Do");
        
        MatrixNumeric<String> data = new MatrixNumeric<String>(keys, 2.0);
        data.setValue("Do", "Ko", 4.0);
        data.setValue("Do", "Mo", 6.0);
        
        data.setValue("Ko", "Ko", 20.0);
        data.setValue("Ko", "Mo", 200.0);
        
        data.setValue("Mo", "Ko", 1.0);
        data.setValue("Mo", "Mo", .5);
        System.out.print(data);
        
        assertEquals(12.0, data.getTotalLine("Do"), 0.0);
        assertEquals(222.0, data.getTotalLine("Ko"), 0.0);
        assertEquals(3.5, data.getTotalLine("Mo"), 0.0);
        
        assertEquals(6.0, data.getTotalColunm("Do"), 0.0);
        assertEquals(25.0, data.getTotalColunm("Ko"), 0.0);
        assertEquals(206.5, data.getTotalColunm("Mo"), 0.0);
        
        assertEquals(237.5, data.getTotal(), 0.0);
        //assertEquals(6.0, data.("Mo"), 0.0);
    }
}
