package ex04;

/**
 * Calculation and display of results; 
 * contains the implementation of the static method main()
 * @see Main#main
 */
public class Main {
    /**
    * Executed when the program starts; 
    * calls a method {@linkplain Application#run()}
    * @param args program launch parameters
    */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }
}