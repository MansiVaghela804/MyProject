package com.example.admin.myproject.Listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.myproject.R;

public class Listview_one extends AppCompatActivity {
    ListView listView;
    String[] data = {"sunday", "Monday", "Tuseday", "Wednesday", "Thursday", "friday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_one);

        listView = (ListView) findViewById(R.id.listview);
//        make an array of the objects according to a layout design

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        listView.setAdapter(adapter);

//        listitem onclick

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                listview clicked item index
                int itemPosition = position;

//                Listview clicked item value
                String itemvalue = (String) listView.getItemAtPosition(position);

                Toast.makeText(Listview_one.this, "positon:"+itemPosition+  "itemClicked:" + itemvalue, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
