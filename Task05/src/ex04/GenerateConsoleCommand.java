package ex04;

import ex02.View;

/**
 * Console command Generate;
 * command pattern
 */
public class GenerateConsoleCommand implements ConsoleCommand {

    /**
     * An object that implements the {@linkplain View} interface; 
     * serves the collection objects {@linkplain ex01.Item2d}
     */
    private final View view;

    /**
     * Initializes {@linkplain GenerateConsoleCommand#view} field
     * @param view object that implements {@linkplain View} interface
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'g';
    }

    @Override
    public String toString() {
        return "'g'enerate";
    }

    @Override
    public void execute() {
        System.out.println("Random generation.");
        view.viewInit();
        view.viewShow();
    }
}