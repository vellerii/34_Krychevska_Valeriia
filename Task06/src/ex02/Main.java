package ex02;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Calculation and display of results.
 * Includes an implementation of the static method main()
 */
public class Main {
    /**
     * An object implementing the {@linkplain View} interface; maintains a collection of objects
     * {@linkplain ex01.Item2d}
     */
    private final View view;
    
    /** 
     * Initializes the {@linkplain Main#view view} field.
     * @param view 
     */
    public Main(View view) {
        this.view = view;
    }
    
    /**
     * Displays the menu.
     */
    public void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    System.out.println("View current.");
                    view.viewShow();
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    view.viewInit();
                    view.viewShow();
                    break;
                case 's':
                    System.out.println("Save current.");
                    try {
                        view.viewSave();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    try {
                        view.viewShow();
                    } catch (Exception e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'q');
    }
    
    /**
     * Executed when the program starts; 
     * calls the {@linkplain Main#menu() method menu()}
     * @param args - parameters of launching program.
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }
}