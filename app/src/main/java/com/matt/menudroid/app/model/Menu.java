package com.matt.menudroid.app.model;


import com.orm.SugarRecord;

import java.util.List;

public class Menu extends SugarRecord<Menu> {
    private String name;
    private String description;

    public Menu() {

    }

    public Menu(String name, String description) {
        this.description = description;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static List<Menu> getAll() {
        List<Menu> menus = Menu.listAll(Menu.class);
        return menus;
    }
}
