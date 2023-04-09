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
     * Tests calcHex and calcOct methods of the Calc class.
     */
    @Test
    public void testCalcHexAndOctal() {
        Calc calc = new Calc();
        int resultHex = calc.calcHex(28.8);
        int resultOctal = calc.calcOct(28.8);
        
        assertEquals(16, resultHex);
        assertEquals(2, resultOctal);
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
