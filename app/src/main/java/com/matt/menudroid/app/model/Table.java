package com.matt.menudroid.app.model;


public class Table {
    private int size;
    private boolean serviceComplete;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setServiceComplete(boolean serviceComplete) {
        this.serviceComplete = serviceComplete;
    }

    public boolean isServiceComplete() {
        return this.serviceComplete;
    }
}
