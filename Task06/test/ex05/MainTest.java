package ex05;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ex02.ViewResult;

/**
 * This class use for testing purposes.
 *
 * @seeCommandQueue
 * @see MaxCommand
 * @see AvgCommand
 * @see MinMaxCommand
 */
public class MainTest {
    private final static int N = 1000;
    private static final ViewResult view = new ViewResult(N);
    private static final MaxCommand max1 = new MaxCommand(view);
    private static final MaxCommand max2 = new MaxCommand(view);
    private static final AvgCommand avg1 = new AvgCommand(view);
    private static final AvgCommand avg2 = new AvgCommand(view);
    private static final MinMaxCommand min1 = new MinMaxCommand(view);
    private static final MinMaxCommand min2 = new MinMaxCommand(view);
    private final CommandQueue queue = new CommandQueue();

    /** Runs First */
    @BeforeClass
    public static void setUpBeforeClass() {
        view.viewInit();
        assertEquals(N, view.getItems().size());
    }

    /** Runs last */
    @AfterClass
    public static void tearDownAfterClass() {
        assertEquals(max1.getHexResult(), max2.getHexResult());
        assertEquals(max1.getOctalResult(), max2.getOctalResult());
        assertEquals(avg1.getHexResult(), avg2.getHexResult(), .1e-10);
        assertEquals(avg1.getOctalResult(), avg2.getOctalResult(), .1e-10);
        assertEquals(min1.getResultMaxHex(), min2.getResultMaxHex());
        assertEquals(min1.getResultMinHex(), min2.getResultMinHex());
        assertEquals(min1.getResultMaxOctal(), min2.getResultMaxOctal());
        assertEquals(min1.getResultMinOctal(), min2.getResultMinOctal());
    }

    /** Checking the core functionality of a class {@linkplain MaxCommand} */
    @Test
    public void testMax() {
        max1.execute();
        assertTrue(max1.getHexResult() > -1);
        assertTrue(max1.getOctalResult() > -1);
    }

    /** Checking the core functionality of a class {@linkplain AvgCommand} */
    @Test
    public void testAvg() {
        avg1.execute();
        assertTrue(avg1.getHexResult() != 0.0);
        assertTrue(avg1.getOctalResult() != 0.0);
    }

    /** Checking the core functionality of a class {@linkplain MinMaxCommand} */
    @Test
    public void testMin() {
        min1.execute();
        assertTrue(min1.getResultMinHex() > -1);
        assertTrue(min1.getResultMinOctal() > -1);
    }

    /**
     * Checking the core functionality of a class {@linkplain CommandQueue}
     * {@linkplain MaxCommand}
     */
    @Test
    public void testMaxQueue() {
        queue.put(max2);
        try {
            while (max2.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            fail(e.toString());
        }
    }

    /**
     * Checking the core functionality of a class {@linkplain CommandQueue}
     * {@linkplain AvgCommand}
     */
    @Test
    public void testAvgQueue() {
        queue.put(avg2);
        try {
            while (avg2.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            fail(e.toString());
        }
    }

    /**
     * Checking the core functionality of a class {@linkplain CommandQueue}
     * {@linkplain MinMaxCommand}
     */
    @Test
    public void testMinQueue() {
        queue.put(min2);
        try {
            while (min2.running()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            queue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            fail(e.toString());
        }
    }
}