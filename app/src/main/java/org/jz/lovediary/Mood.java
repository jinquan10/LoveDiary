package org.jz.lovediary;

/**
 * Created by JZ on 4/23/2016.
 */
public enum Mood {
    HAPPY(0);

    private int resourceId;

    Mood(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }
}
