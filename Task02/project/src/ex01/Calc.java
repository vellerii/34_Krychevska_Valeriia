package ex01;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The Calc class that performs calculations based on random number and saves the results to a file.
 * It contains methods for setting and getting the result of a calculation, 
 * initializing the calculator with an input value, performing a calculation, displaying the result, 
 * and saving and restoring the result from a file.
 */
public class Calc {
    /**
     * This variable use for saving and restoring the result.
     */
    private static final String FILENAME = "Save.bin";
    
    /**
     * This variable use for storing result of a calculation.
     */
    private Item2d result;

    /**
     * Constructs a new Calc object with a default result of Item2d.
     */
    public Calc() {
        result = new Item2d();
    }

    /**
     * Sets the result of a calculation to a given Item2d object.
     * @param result The Item2d object to set as the result.
     */ 
    public void setResult(Item2d result) {
        this.result = result;
    }

    /**
     * Gets the result of a calculation.
     * @return The current result of a calculation.
     */ 
    public Item2d getResult() {
        return result;
    }

    /**
     * Calculates the number of hexadecimal and octal digits in the given value of the decimal number.
     * @param randomNumber The randomNumber value to calculate.
     * @return Item2d object containing the random number, hexadecimal count, and octal count.
     */
    public Item2d calc(double randomNumber) {
        String hexString = Double.toHexString(randomNumber);
        String octalString = Integer.toOctalString(Double.valueOf(randomNumber).intValue());
        
        int hexCount = hexString.replaceAll("\\.", "").length() - 2;
        int octCount = octalString.length();

        return new Item2d(randomNumber, hexCount, octCount);
    }

    /**
     * Initializes the calculator with a given random number value.
     * @param randomNumber The random number for calculate.
     */
    public void init(double randomNumber) {
        setResult(calc(randomNumber));
    }

    /**
     * Prints the result of the calculation to the console.
     */
    public void show() {
        System.out.println(getResult());
    }

    /**
     * Saves the current result of a calculation to a file.
     * @throws IOException, the error will occurs if there is an issue of saving the result to the file.
     */
    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME));
        os.writeObject(result);
        os.flush();
        os.close();
    }

    /**
     * Restores the result of a calculation from a file.
     * @throws Exception, the error will occurs if there is an issue of restoring the result to the file.
     */
    public void restore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME));
        result = (Item2d)is.readObject();
        is.close();
    }
}