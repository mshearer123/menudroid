package com.matt.menudroid.app.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.matt.menudroid.app.R;
import com.matt.menudroid.app.fragment.MenusFragment;
import com.matt.menudroid.app.fragment.TablesFragment;

import java.util.HashMap;

public class MainActivity extends FragmentActivity {

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private FrameLayout contentFrame;

    private HashMap<String, Fragment> fragmentMap = new HashMap<String, Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentFrame = (FrameLayout) findViewById(R.id.content_frame);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        TablesFragment tablesFragment = new TablesFragment();
        MenusFragment menusFragment = new MenusFragment();
        fragmentMap.put("Tables", tablesFragment);
        fragmentMap.put("Menus", menusFragment);

        drawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, fragmentMap.keySet().toArray(new String[fragmentMap.keySet().size()])));


        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    setFragment(fragmentMap.get("Menus"));
                    setTitle("Menus");

                } else if (position == 1) {
                    setFragment(fragmentMap.get("Tables"));
                    setTitle("Tables");
                }
                drawerLayout.closeDrawer(contentFrame);
            }
        });

        setFragment(fragmentMap.get("Menus"));
        setTitle("Menus");

    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }
}
