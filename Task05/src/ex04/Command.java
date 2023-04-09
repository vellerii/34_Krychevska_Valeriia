package ex04;

/**
 * Command or task interface; 
 * templates: Command, Worker Thread
 */
public interface Command {
    /** 
     * Command execution; 
     * patterns: Command, Worker Thread 
     */
    public void execute();
}