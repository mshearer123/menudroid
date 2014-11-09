package com.matt.menudroid.app;

import com.matt.menudroid.app.model.Menu;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mshearer123 on 9/11/14.
 */
public class DatabaseHelper {


    private static DatabaseHelper dbHelper = null;

    protected DatabaseHelper() {
    }

    public static DatabaseHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new DatabaseHelper();
        }
        return dbHelper;
    }

    public void setupSampleTables() {
        if (Menu.getAll().isEmpty()) {
            for (int i = 0; i < 10; i++) {
                Menu menu = new Menu("name " + i, "description:" + i);
                menu.save();
            }
        }
    }

}
