package ex05;

import ex02.View;
import ex02.ViewableResult;
import ex04.ChangeConsoleCommand;
import ex04.GenerateConsoleCommand;
import ex04.Menu;
import ex04.ViewConsoleCommand;

/**
 * Calculation and display of results; 
 * contains the implementation of the static method main()
 * @see Main#main
 */
public class Main {
    /**
     * An object that implements the {@linkplain View} interface; 
     * serves the collection objects {@linkplain ex01.Item2d}; 
     * initializes with Factory Method
     */
    private final View view = new ViewableResult().getView();
    
    /**
     * Object of class {@linkplain Menu}; 
     * macro command (Command template)
     */
    private final Menu menu = new Menu();

    /** 
     * Handling user commands 
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }

    /**
     * Executed when the program starts
     * @param args program launch parameters
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}