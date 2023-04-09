package ex05;

import ex04.Command;

/**
 * Represents methods for putting and retrieving tasks by a thread handler;
 * Worker Thread pattern
 * @seeCommand
 */
public interface Queue {
    /**
    * Adds a new task to the queue;
    * Worker Thread pattern
    * @param cmd task
    */
    void put(Command cmd);

    /**
    * Removes a task from the queue; 
    * Worker Thread pattern
    * @return task to be deleted
    */
    Command take();
}