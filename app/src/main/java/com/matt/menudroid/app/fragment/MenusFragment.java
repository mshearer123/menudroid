package com.matt.menudroid.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.matt.menudroid.app.R;
import com.matt.menudroid.app.model.Menu;

import java.util.List;

public class MenusFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menus, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 3. create an adapter
        MenusAdapter adapter = new MenusAdapter(Menu.getAll());
        // 4. set adapter
        recyclerView.setAdapter(adapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;

    }



    public final static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;

        public MenuViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_title);
            description = (TextView) itemView.findViewById(R.id.item_description);
        }
    }



    public class MenusAdapter extends RecyclerView.Adapter<MenuViewHolder> {


        List<Menu> menus;

        public MenusAdapter(List<Menu> menus) {
            this.menus = menus;
        }

        @Override
        public MenuViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_item_layout, viewGroup, false);
            MenuViewHolder viewHolder = new MenuViewHolder(itemLayoutView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MenuViewHolder menuViewHolder, int i) {
            menuViewHolder.name.setText(menus.get(i).getName());
            menuViewHolder.description.setText(menus.get(i).getDescription());
        }

        @Override
        public int getItemCount() {
            return this.menus.size();
        }
    }
}
