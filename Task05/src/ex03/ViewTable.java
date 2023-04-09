package ex03;

import java.util.Formatter;
import ex01.Item2d;
import ex02.ViewResult;

/**
 * ConcreteCreator (Factory Method design template)<br>
 * Output in the form of a table
 * @see ViewResult
 */
public class ViewTable extends ViewResult {

    /**
     * Specifies the default table width
     */
    private static final int DEFAULT_WIDTH = 32;

    /**
     * Current table width
     */
    private int width;

    /**
     * Sets {@linkplain ViewTable#width width} value
     * {@linkplain ViewTable#DEFAULT_WIDTH DEFAULT_WIDTH}<br>
     * The superclass constructor is called {@linkplain ViewResult#ViewResult() ViewResult()}
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    /**
     * Sets {@linkplain ViewTable#width} value <b>width</b><br>
     * The superclass constructor is called {@linkplain ViewResult#ViewResult() ViewResult()}
     * @param width defines the width of the table
     */
    public ViewTable(int width) {
        this.width = width;
    }

    /**
     * Sets {@linkplain ViewTable#width} value <b>width</b><br>
     * The superclass constructor is called {@linkplain ViewResult#ViewResult(int n)
     * ViewResult(int n)}
     *
     * @param width defines the width of the table
     * @param n quantity of elements in collection; pass to super constructor
     */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }

    /**
     * Sets the field {@linkplain ViewTable#width} value <b>width</b>
     * @param width new table width
     * @return set by parameter <b>width</b> table width
     */
    public int setWidth(int width) {
        return this.width = width;
    }

    /**
     * Returns the field value {@linkplain ViewTable#width}
     * @return current table width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Outputs a vertical separator width {@linkplain ViewTable#width} symbols
     */
    void outLine() {
        for (int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    /**
     * Calls {@linkplain ViewTable#outLine()}; 
     * terminates the output with a delimiter lines
     */
    private void outLineLn() {
        outLine();
        System.out.println();
    }

    /**
     * Displays the title of the table with a width of {@linkplain ViewTable#width} characters
     */
    private void outHeader() {
        Formatter formatter = new Formatter();
        formatter.format("%" + ((width)/3) + "s|%" + ((width)/3) + "s|%" + ((width)/3) + "s\n", "Number", "Hex", "Octal");
        System.out.print(formatter.toString());
    }
    
    /** 
     * Displays the body of the table with a width of {@linkplain ViewTable#width} characters 
     */
    private void outBody() {
        for (Item2d item : getItems()) {
            Formatter formatter = new Formatter();
            formatter.format(
                    "%" + ((width)/3) + ".2f|%" + ((width)/3) + "s|%" + ((width)/3) + "s\n", 
                    item.getRandomNumber(), item.getHex(), item.getOctal()
            );
            System.out.print(formatter.toString());
        }
    }

    /**
     * Reloading (combination, overloading) of the superclass method; establishes
     * field {@linkplain ViewTable#width} with value <b>width</b><br>
     * Calls the {@linkplain ViewResult#viewInit() viewInit()} method
     *
     * @param width new table width 9
     */
    public final void init(int width) { // method overloading
        this.width = width;
        viewInit();
    }

    /**
     * Superclass method overload; sets the field
     * {@linkplain ViewTable#width} with <b>width</b><br>
     * For object {@linkplain ViewTable} calls method
     * {@linkplainViewTable#init(double stepX)}
     *
     * @param width new table width.
     * @param stepX is passed to the <b>init(double)</b> method
     */
    public final void init(int width, double stepX) { // method overloading
        this.width = width;
        init();
    }

    /**
     * Redefining (replacing, overriding) superclass method; 
     * displays informational message and calls the superclass method
     * {@linkplain ViewResult#init(double stepX) init(double stepX)}<br>
     * {@inheritDoc}
     */
    @Override
    public void init() { // method overriding
        System.out.print("Initialization... ");
        super.init();
        System.out.println("done. ");
    }

    /**
     * Table element output<br> {@inheritDoc}
     */
    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }

    /**
     * Table element output<br> {@inheritDoc}
     */
    @Override
    public void viewBody() {
        outBody();
    }
    
    /**
     * Table element output<br> {@inheritDoc}
     */
    @Override
    public void viewFooter() {
        outLineLn();
    }
    
    /**
     * Returns the Item2d object at the specified index.
     * @param index
     * @return Item2d
     */
    public Item2d getItem(int index) {
       return items.get(index);
    }
    
}