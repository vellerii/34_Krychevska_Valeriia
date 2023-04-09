package ex02;

/**
 * Creator (Factory Method design pattern)<br>
 * Declares a method that "fabricates" objects
 *
 * @see Viewable#getView()
 */
public interface Viewable {

    /**
     * Creates an object that implements {@linkplain View}
     * @return 
     */
    public View getView();

}