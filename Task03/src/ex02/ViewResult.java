package ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ex01.Item2d;

/**
 * ViewResult class that implements the View interface and manages the
 * collection of Item2d objects.
 */
public class ViewResult implements View {
     /**
     * File name used for serialization.
     */
    private static final String FILENAME = "items.bin";

    /**
     * Default number of values to compute.
     */
    private static final int DEFAULT_NUM = 10;

    /**
     * Collection of argument and result items.
     */
    public ArrayList<Item2d> items = new ArrayList<>();
    
    /**
     * Constructs a ViewResult object with the default number of items to display.
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }
    
    /**
     * Constructor that creates the items collection with the given number of items.
     * @param n The number of items to create.
     */
    public ViewResult(int n) {
        for(int ctr = 0; ctr < n; ctr++) {
            items.add(new Item2d());
        }
    }
    
    /**
     * Returns the ArrayList of Item2d objects.
     * @return The ArrayList of Item2d objects.
     */
    public ArrayList<Item2d> getItems() {
        return items;
    }
    
    /**
     * Calculates the number of hex digits in the given value of the decimal number.
     * @param randomNumber The randomNumber value to calculate.
     * @return The number of hex digits in the given value of the decimal number.
     */
    public int calcHex(double randomNumber) {
        String hexString = Double.toHexString(randomNumber);
        int hexCount = hexString.replaceAll("\\.", "").length() - 2;
        return hexCount;
    }

    /**
     * Calculates the number of octal digits in the given value of the decimal number.
     * @param randomNumber The randomNumber value to calculate.
     * @return The number of octal digits in the given value of the decimal number.
     */
    public int calcOct(double randomNumber) {
        String octalString = Integer.toOctalString(Double.valueOf(randomNumber).intValue());
        int octCount = octalString.length();
        return octCount;
    }

    /**
     * Initializes the Item2d objects with input values and their corresponding hexadecimal and octal counts.
     */
    public void init() {
        for (Item2d item : items) {
            item.setRandomNumber(Math.random() * 1000);
            item.setHex(calcHex(item.getRandomNumber()));
            item.setOctal(calcOct(item.getRandomNumber()));
        }
    }
    
    /** Implementation of the {@linkplain View#viewInit()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewInit() {
        init();
    }
    
    /** Implementation of the {@linkplain View#viewSave()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FILENAME));
        os.writeObject(items);
        os.flush();
        os.close();
    }
   
    /** Implementation of the {@linkplain View#viewRestore()}<br>
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME));
        items = (ArrayList<Item2d>) is.readObject();
        is.close();
    }
   
    /** Implementation of the {@linkplain View#viewHeader()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }
    
    /** Implementation of the {@linkplain View#viewBody()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewBody() {
        for(Item2d item : items) {
            System.out.printf("<%.2f; %d; %d> ", item.getRandomNumber(), item.getHex(), item.getOctal());
        }
        System.out.println();
    }
    
    /** Implementation of the {@linkplain View#viewFooter()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewFooter() {
        System.out.println("End.");
    }
    
    /** Implementation of the {@linkplain View#viewShow()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
