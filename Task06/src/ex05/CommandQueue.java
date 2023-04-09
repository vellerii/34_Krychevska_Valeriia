package ex05;

import java.util.Vector;
import ex04.Command;

/**
 * Creates a thread handler that executes objects with the Command interface; 
 * template Worker Thread
 * @seeCommand
 */
public class CommandQueue implements Queue {

    /**
     * Task Queue
     */
    private final Vector<Command> tasks;
    
    /**
     * Wait Flag
     */
    private boolean waiting;
    
    /**
     * Completion Flag
     */
    private boolean shutdown;

    /**
     * Sets the termination flag
     */
    public void shutdown() {
        shutdown = true;
    }

    /**
     * Initialization {@linkplain CommandQueue#tasks}
     * {@linkplain CommandQueue#waiting} {@linkplain CommandQueue#waiting};
     * creates a thread for the class {@linkplain CommandQueue.Worker}
     */
    public CommandQueue() {
        tasks = new Vector<Command>();
        waiting = false;
        new Thread(new Worker()).start();
    }

    @Override
    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try {
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return (Command) tasks.remove(0);
    }

    /**
     * Serves the task queue; 
     * template Worker Thread
     * @see Runnable
     */
    private class Worker implements Runnable {
        /**
         * Retrieves tasks ready for execution from the queue; 
         * template Worker Thread
         */
        public void run() {
            while (!shutdown) {
                Command r = take();
                r.execute();
            }
        }
    }
}