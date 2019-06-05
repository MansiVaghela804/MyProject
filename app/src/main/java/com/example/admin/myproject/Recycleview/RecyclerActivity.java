package com.example.admin.myproject.Recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.myproject.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ItemData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        list = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ItemData itemsData[] = {new ItemData("Help", R.drawable.ic_car),
                new ItemData("Delete", R.drawable.ic_menu_gallery),
                new ItemData("send", R.drawable.ic_menu_send),
                new ItemData("share", R.drawable.ic_menu_share)};

        for (int j=0;j<10;j++) {
            for (int i = 0; i < itemsData.length; i++) {
                list.add(itemsData[i]);
            }
        }
// 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
// 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(list);
// 4. set adapter
        recyclerView.setAdapter(mAdapter);

    }
}
