package com.matt.menudroid.app;

import android.app.Application;

import com.orm.SugarApp;

/**
 * Created by mshearer123 on 9/11/14.
 */
public class MenuDroidApplication  extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseHelper.getInstance().setupSampleTables();

    }
}
