package com.github.yangsanity.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjie
 */
public class Chrell extends AbsChrell {

    private final int shredderCount;

    private final List<UtromShredder> shredders;

    public Chrell(int shredderCount) {
        this.shredderCount = shredderCount;
        this.shredders = new ArrayList<>();
    }

    @Override
    void createShredder() {

    }

    @Override
    void splitAndAssign(Task task) {

    }

    @Override
    void waitFinished() {

    }
}
