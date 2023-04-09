package ex02;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Item2d;

/**
 * This class use for testing purposes.
 */
public class MainTest {
    
    /**
     * Tests calculation logic of the Item2d class.
     */
    @Test
    public void testCalc() {
        Item2d item = new Item2d(720.8, 3, 5);
        
        assertEquals(720.8, item.getRandomNumber(), 0.001);
        assertEquals(3, item.getHex());
        assertEquals(5, item.getOctal());
        
        item.setRandomNumber(451.0);
        item.setHex(7);
        item.setOctal(6);
        
        assertEquals(451.0, item.getRandomNumber(), 0.001);
        assertEquals(7, item.getHex());
        assertEquals(6, item.getOctal());
    }
    
    /** 
     * Tests of serialization and correctness of data restoring.
     */
    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult(10);
        ViewResult view2 = new ViewResult();
        view1.init();

        try {
           view1.viewSave();
        } catch (IOException e) {
           Assert.fail(e.getMessage());
        }
        
        try {
           view2.viewRestore();
        } catch (Exception e) {
           Assert.fail(e.getMessage());
        }
        
        assertEquals(view1.getItems().size(), view2.getItems().size());
        
        for (int i = 0; i < view1.getItems().size(); i++) {
            assertEquals(
                    view1.getItems().get(i).getRandomNumber(), 
                    view2.getItems().get(i).getRandomNumber(), 
                    0.1
            );
        }
    }
}