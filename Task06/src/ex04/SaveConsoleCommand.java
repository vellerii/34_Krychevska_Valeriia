package ex04;

import java.io.IOException;
import ex02.View;

/**
 * Console command Save; 
 * Command pattern
 */
public class SaveConsoleCommand implements ConsoleCommand {

    /**
     * An object that implements the {@linkplain View} interface; 
     * serves the collection objects {@linkplain ex01.Item2d}
    */
    private final View view;

    /**
     * Initializes the field {@linkplain SaveConsoleCommand#view}
     * @param view object that implements {@linkplain View} interface
    */
    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 's';
    }

    @Override
    public String toString() {
        return "'s'ave";
    }

    @Override
    public void execute() {
        System.out.println("Save current.");
        try {
            view.viewSave();
        } catch (IOException e) {
            System.err.println("Serialization error: " + e);
        }
        view.viewShow();
    }

}
