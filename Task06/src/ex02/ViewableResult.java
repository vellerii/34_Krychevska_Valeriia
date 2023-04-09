package ex02;

/**
 * ConcreteCreator (Factory Method design pattern)<br>
 * Declares a method that "fabricates" objects
 *
 * @see Viewable
 * @see ViewableResult#getView()
 */
public class ViewableResult implements Viewable {

    /**
     * Creates a display of the {@linkplain ViewResult} object
     *
     * @return
     */
    @Override
    public View getView() {
        return new ViewResult();
    }
}