package ex03;

import ex02.View;

/**
 * Calculates and displays the results<br>
 * Includes an implementation of the static method main()
 * @see Main#main
 */
public class Main extends ex02.Main {
    /** 
     * Initializes field {@linkplain ex02.Main#view view}
     * @param view 
     */
    public Main(View view) {
        super(view);
    }

    /**
    * Executed when the program is launched; 
    * calls method {@linkplain ex02.Main#menu menu()}
    * @param args - parameters when starting the program.
    */
    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}