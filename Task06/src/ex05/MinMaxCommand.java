package ex05;

import java.util.concurrent.TimeUnit;
import ex01.Item2d;
import ex02.ViewResult;
import ex04.Command;

/**
 * The task used by the thread handler;
 * Worker Thread pattern
 * @seeCommand
 * @seeCommandQueue
 */
public class MinMaxCommand implements Command /* , Runnable */ {

    /**
     * Stores the min hex result of processing the collection
     */
    private int resultMinHex = -1;
    
    /**
     * Stores the max hex result of processing the collection
     */
    private int resultMaxHex = -1;
    
    /**
     * Stores the min octal result of processing the collection
     */
    private int resultMinOctal = -1;
    
    /**
     * Stores the max octal result of processing the collection
     */
    private int resultMaxOctal = -1;

    /**
     * Result ready flag
     */
    private int progress = 0;
    
    /**
     * Serves a collection of objects {@linkplain ex01.Item2d}
     */
    private ViewResult viewResult;

    /**
     * Return field {@linkplain MinMaxCommand#viewResult}
     * @return value {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }

    /**
     * Set field {@linkplain MinMaxCommand#viewResult}
     * @param viewResult value for {@linkplain MinMaxCommand#viewResult}
     * @return new value {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }

    /**
     * Initializes the field {@linkplain MinMaxCommand#viewResult}
     * @param viewResult class object {@linkplain ViewResult}
     */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }

    /**
     * Return min hex result 
     * @return field {@linkplain MinMaxCommand#resultMinHex}
     */
    public int getResultMinHex() {
        return resultMinHex;
    }

    /**
     * Return max hex result
     * @return field {@linkplain MinMaxCommand#resultMaxHex}
     */
    public int getResultMaxHex() {
        return resultMaxHex;
    }
    
    /**
     * Return min octal result 
     * @return field {@linkplain MinMaxCommand#resultMinOctal}
     */
    public int getResultMinOctal() {
        return resultMinOctal;
    }

    /**
     * Return max octal result
     * @return field {@linkplain MinMaxCommand#resultMaxOctal}
     */
    public int getResultMaxOctal() {
        return resultMaxOctal;
    }
    
    /**
     * Checks the readiness of the result
     * @return false - if the result is found, otherwise - true
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
        System.out.println("MinMax executed...");
        int idx = 0, size = viewResult.getItems().size();
        for (Item2d item : viewResult.getItems()) {
            if (item.getHex() < 0) {
                if ((resultMaxHex == -1) ||
                        (viewResult.getItems().get(resultMaxHex).getHex() <
                                item.getHex())) {
                    resultMaxHex = idx;
                }
            } else {
                if ((resultMinHex == -1) ||
                        (viewResult.getItems().get(resultMinHex).getHex() >
                                item.getHex())) {
                    resultMinHex = idx;
                }
            }
            if (item.getOctal() < 0) {
                if ((resultMaxOctal == -1) ||
                        (viewResult.getItems().get(resultMaxOctal).getOctal() <
                                item.getOctal())) {
                    resultMaxOctal = idx;
                }
            } else {
                if ((resultMinOctal == -1) ||
                        (viewResult.getItems().get(resultMinOctal).getOctal() >
                                item.getOctal())) {
                    resultMinOctal = idx;
                }
            }
            idx++;

            progress = idx * 100 / size;
            if (idx % (size / 5) == 0) {
                System.out.println("MinMax " + progress + "%");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(5000 / size);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.print("MinMax done. ");
        if (resultMinHex > -1) {
            System.out.print("Min positive hex #" + resultMinHex + " found: " +
                    String.format("%d.", viewResult.getItems().get(resultMinHex).getHex()));
        } else {
            System.out.print("Min positive hex not found.");
        }
        if (resultMaxHex > -1) {
            System.out.println(" Max negative hex #" + resultMaxHex + " found: " +
                    String.format("%d.", viewResult.getItems().get(resultMaxHex).getHex()));
        } else {
            System.out.println(" Max negative hex item not found.");
        }

        if (resultMinOctal > -1) {
            System.out.print("Min positive octal #" + resultMinOctal + " found: " +
                    String.format("%d.", viewResult.getItems().get(resultMinOctal).getOctal()));
        } else {
            System.out.print("Min positive octal not found.");
        }
        if (resultMaxOctal > -1) {
            System.out.println(" Max negative octal #" + resultMaxOctal + " found: " +
                    String.format("%d.", viewResult.getItems().get(resultMaxOctal).getOctal()));
        } else {
            System.out.println(" Max negative octal item not found.");
        }

        progress = 100;
    }
}