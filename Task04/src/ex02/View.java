package ex02;

import java.io.IOException;

/**
 * Product (Factory Method Design Pattern).
 * Interface of "fabricated" objects
 * Declares object rendering methods
 */
public interface View {

    /**
     * Displays title.
     */
    public void viewHeader();

    /**
     * Displays the main part.
     */
    public void viewBody();

    /**
     * Displays ending.
     */
    public void viewFooter();

    /**
     * Displays the entire object.
     */
    public void viewShow();

    /**
     * Performs initialization.
     */
    public void viewInit();

    /**
     * Saves data for later recovery.
     * @throws java.io.IOException
     */
    public void viewSave() throws IOException;

    /**
     * Restores previously saved data.
     * @throws java.lang.Exception
     */
    public void viewRestore() throws Exception;
}