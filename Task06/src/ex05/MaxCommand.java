package ex05;

import java.util.concurrent.TimeUnit;
import ex02.ViewResult;
import ex04.Command;

/**
 * The task used by the thread handler; 
 * Worker Thread pattern
 * @seeCommand
 * @seeCommandQueue
 */
public class MaxCommand implements Command /* , Runnable */ {
    /** Stores the hex result of processing the collection */
    private int hexResult = -1;
    /** Stores the octal result of processing the collection */
    private int octalResult = -1;
    /** Result ready flag */
    private int progress = 0;
    /** Serves a collection of objects {@linkplain ex01.Item2d} */
    private ViewResult viewResult;

    /**
     * Returns a field {@linkplain MaxCommand#viewResult}
     * @return value {@linkplain MaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * Sets the field {@linkplain MaxCommand#viewResult}
     * @param viewResult value for {@linkplain MaxCommand#viewResult}
     * @return new value {@linkplain MaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * Initializes the field {@linkplain MaxCommand#viewResult}
     * @param viewResult class object {@linkplain ViewResult}
     */
    public MaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Returns the hex result
     * @return field {@linkplain MaxCommand#hexResult}
     */
    public int getHexResult() {
        return hexResult;
    }
    
    /**
     * Returns the octal result
     * @return field {@linkplain MaxCommand#octalResult}
     */
    public int getOctalResult() {
        return octalResult;
    }

    /**
     * Checks the readiness of the result
     * @return false - if the result is found, otherwise - true
     * @see MaxCommand#result
     */
    public boolean running() {
        return progress < 100;
    }

    /**
     * Used by the thread handler {@linkplain CommandQueue}; 
     * Worker Thread pattern
     */
    @Override
    public void execute() {
        progress = 0;
        System.out.println("Max executed...");
        int size = viewResult.getItems().size();
        hexResult = 0;
        octalResult = 0;
        for (int idx = 1; idx < size; idx++) {
            if (viewResult.getItems().get(hexResult).getHex() < viewResult.getItems().get(idx).getHex()) {
                hexResult = idx;
            }
            
            if (viewResult.getItems().get(octalResult).getOctal() < viewResult.getItems().get(idx).getOctal()) {
                octalResult = idx;
            }
            
            progress = idx * 100 / size;
            if (idx % (size / 3) == 0) {
                System.out.println("Max " + progress + "%");
            }
            
            try {
                TimeUnit.MILLISECONDS.sleep(3000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        
        System.out.println(
                "Max done. Item #" + hexResult + 
                " Hex found: " + viewResult.getItems().get(hexResult)
        );
        
        System.out.println(
                "Max done. Item #" + octalResult +
                " Octal found: " + viewResult.getItems().get(octalResult)
        );
        
        progress = 100;
    }
}