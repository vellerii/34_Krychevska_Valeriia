package ex04;

/**
 * Command or task interface; 
 * template Command
 */
public interface ConsoleCommand extends Command {
    
    /**
     * Hotkey commands; 
     * command pattern
     * @return hotkey character
     */
    public char getKey();

}