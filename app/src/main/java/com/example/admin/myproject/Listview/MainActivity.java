package com.example.admin.myproject.Listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.myproject.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_item);
        ArrayList<item> itemList = new ArrayList<item>();

        adapter = new Adapter(this, R.layout.row_design, itemList);
        listView.setAdapter(adapter);

        for (int i = 0; i < 20; i++) {
            itemList.add(new item("hello", R.drawable.ic_group_black_24dp));

        }
        setUpListItemClickListener();

    }

    private void setUpListItemClickListener() {

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "item " + position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
