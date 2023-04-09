package ex04;

import ex02.View;

/**
 * Console command View; 
 * Command pattern
 */
public class ViewConsoleCommand implements ConsoleCommand {

    /**
     * An object that implements the {@linkplain View} interface; 
     * serves the collection objects {@linkplain ex01.Item2d}
     */
    private final View view;

    /**
     * Initializes the field {@linkplain SaveConsoleCommand#view}
     * @param view object that implements {@linkplain View} interface
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'v';
    }

    @Override
    public String toString() {
        return "'v'iew";
    }

    @Override
    public void execute() {
        System.out.println("View current.");
        view.viewShow();
    }
}
