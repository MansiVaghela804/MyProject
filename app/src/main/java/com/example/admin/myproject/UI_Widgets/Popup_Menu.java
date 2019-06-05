package com.example.admin.myproject.UI_Widgets;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.admin.myproject.R;

public class Popup_Menu extends AppCompatActivity {
    Button button;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup__menu);

        button = (Button) findViewById(R.id.popup_btn);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
    }

    public void changeBackground(View view) {
        PopupMenu popupMenu = new PopupMenu(Popup_Menu.this, button);

        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.white) {
                    linearLayout.setBackgroundResource(R.drawable.ic_car);
                } else if (id == R.id.blue) {
                    linearLayout.setBackgroundColor(Color.BLUE);

                } else if (id == R.id.cyan) {
                    linearLayout.setBackgroundColor(Color.CYAN);
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
