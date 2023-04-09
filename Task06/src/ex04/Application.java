package ex04;

import ex02.View;
import ex03.ViewableTable;

/**
 * Forms and displays the menu; 
 * implements the Singleton pattern
 */
public class Application {
    /**
     * Reference to an instance of the Application class; singleton pattern
     * @see Application
     */
    private static final Application instance = new Application();

    /**
     * Private constructor; singleton pattern
     * @see Application
     */
    private Application() {
    }

    /**
     * Returns a reference to an instance of the Application class; singleton pattern
     * @return Application
     * @see Application
     */
    public static Application getInstance() {
        return instance;
    }

    /**
     * An object that implements the {@linkplain View} interface; 
     * serves the collection objects {@linkplain ex01.Item2d}; 
     * initialized with Factory Method
    */
    private final View view = new ViewableTable().getView();
    
    /**
     * Class object {@linkplain Menu}; 
     * macro command (Command template)
     */
    private final Menu menu = new Menu();

    /**
     * Handling user commands
     * @see Application
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.execute();
    }
}