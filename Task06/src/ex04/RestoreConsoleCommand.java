package ex04;

import ex02.View;

/**
 * Console command Restore; 
 * Command pattern
 */
public class RestoreConsoleCommand implements ConsoleCommand {

    /**
     * An object that implements the {@linkplain View} interface; serves the collection
     * objects {@linkplain ex01.Item2d}
     */
    private final View view;

    /**
     * Initializes the field {@linkplain RestoreConsoleCommand#view}
     * @param view object that implements {@linkplain View} interface
     */
    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'r';
    }

    @Override
    public String toString() {
        return "'r'estore";
    }

    @Override
    public void execute() {
        System.out.println("Restore last saved.");
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }
}