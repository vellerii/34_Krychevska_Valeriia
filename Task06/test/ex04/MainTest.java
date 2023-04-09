package ex04;

import static org.junit.Assert.*;
import org.junit.Test;
import ex01.Item2d;
import ex02.ViewResult;

/**
 * This class use for testing purposes.
 */
public class MainTest {

    /** 
     * Checks the {@linkplain ChangeItemCommand#execute()} method
     */
    @Test
    public void testExecute() {
        ChangeItemCommand cmd = new ChangeItemCommand();
        
        double randomNumber = 728.4;
        int hex = 5;
        int octal = 6;
        double offset = 2.0;
        
        Item2d item = new Item2d(randomNumber, hex, octal);
        
        cmd.setItem(item);
        cmd.setOffset(offset);
        cmd.execute();

        assertEquals(randomNumber * offset, item.getRandomNumber(), .1e-10);
        assertEquals(hex * offset, item.getHex(), .1e-10);
        assertEquals(octal * offset, item.getOctal(), .1e-10);
    }

    /**
     * Checks {@linkplain ChangeConsoleCommand}
     */
    @Test
    public void testChangeConsoleCommand() {
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(new ViewResult());
        cmd.getView().viewInit();
        cmd.execute();
        assertEquals("'c'hange", cmd.toString());
        assertEquals('c', cmd.getKey());
    }
}