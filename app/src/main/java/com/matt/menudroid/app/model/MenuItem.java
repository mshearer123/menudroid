package com.matt.menudroid.app.model;


public class MenuItem {
    private String name;
    private String description;
    private float price;


    public static enum Type {
        Starter,
        Main,
        Dessert
    }

}
