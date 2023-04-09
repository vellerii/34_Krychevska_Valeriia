package ex03;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;

import ex01.Item2d;

/**
 * This class use for testing purposes.
 */
public class MainTest {
    /** 
     * Checks the main functionality of the {@linkplain ViewTable} class.
     */
    @Test
    public void testCalc() { 
        ViewTable tbl = new ViewTable(10, 5);
        
        assertEquals(10, tbl.getWidth());
        assertEquals(5, tbl.getItems().size());
        
        tbl.init(40, 90.0);
        Item2d item = new Item2d();
        item.setRandomNumber(tbl.getItem(0).getRandomNumber()); 
        item.setHex(tbl.getItem(0).getHex()); 
        item.setOctal(tbl.getItem(0).getOctal()); 
        
        assertEquals(tbl.getItems().get(0), item);
        assertTrue("expected:<" + item + "> but was:<" + tbl.getItems().get(0) + ">", tbl.getItems().get(0).equals(item));
    }
    
    /** 
     * Tests of serialization and correctness of data restoring.
     */
    @Test
    public void testRestore() { 
        ViewTable table1 = new ViewTable(10, 100);
        ViewTable table2 = new ViewTable();

        table1.init(30, Math.random() * 100.0);
        
        try {
            table1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }       

        try {
            table2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        
        assertEquals(table1.getItems().size(), table2.getItems().size());
        assertTrue("containsAll()", table1.getItems().containsAll(table2.getItems()));
    }
}
