package com.github.yangsanity.framework;

/**
 * @author yangjie
 */
public abstract class AbsChrell {

    public void start(Task task) {
        createShredder();
        splitAndAssign(task);
        waitFinished();
    }

    abstract void createShredder();

    abstract void splitAndAssign(Task task);

    abstract void waitFinished();
}
