package ex01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class use for testing purposes.
 */
public class MainTest {
    private static final double DELTA = 0.001;
    
    /**
     * Tests init method of the Calc class.
     */
    @Test
    public void testInit() {
        Calc calc = new Calc();
        calc.init(140.7);
        Item2d result = calc.getResult();
        
        assertEquals(140.7, result.getRandomNumber(), DELTA);
    }

    /**
     * Tests calc method of the Calc class.
     */
    @Test
    public void testCalc() {
        Calc calc = new Calc();
        Item2d result = calc.calc(28.8);
        
        assertEquals(16, result.getHex());
        assertEquals(2, result.getOctal());
    }

    /**
     * Tests save and restore methods of the Calc class.
     */
    @Test
    public void testSaveAndRestore() {
        Calc calc = new Calc();
        calc.init(1345.07666);
        
        try {
            calc.save();
            calc.restore();
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
        
        Item2d result = calc.getResult();
        
        assertEquals(17, result.getHex());
        assertEquals(4, result.getOctal());
    }
}