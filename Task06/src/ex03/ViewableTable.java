package ex03;

import ex02.ViewableResult;
import ex02.View;

/**
 * ConcreteCreator (Factory Method design pattern)<br>
 * Declares a method that "fabricates" objects
 *
 * @see ViewableResult
 * @see ViewableTable#getView()
 */
public class ViewableTable extends ViewableResult {
    /** 
     * Creates a viewable {@linkplain ViewTable}
     */
    @Override
    public View getView() {
        return new ViewTable();
    }
}
