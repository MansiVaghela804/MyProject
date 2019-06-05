package com.example.admin.myproject.UI_Widgets;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.admin.myproject.R;

public class SwitchActivity extends AppCompatActivity {
    TextView textView, toggleview, seektext;
    Switch switchbutton;
    ToggleButton toggleButton;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

//        Status bar color change.
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent));
        }


//        Switchbutton

        textView = (TextView) findViewById(R.id.text_switch);
        switchbutton = (Switch) findViewById(R.id.switchButton);

        switchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchbutton.isChecked()) {
                    textView.setText("Switch is On");
                } else {
                    textView.setText("Switch is Off");
                }
            }
        });

//        ToggleButton
        toggleview = (TextView) findViewById(R.id.toggle_text);
        toggleButton = (ToggleButton) findViewById(R.id.toggle_btn);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    toggleview.setText("Toggle is On");
                } else {
                    toggleview.setText("Toggle is Off");
                }

            }
        });
//        Seekbar

        seektext = (TextView) findViewById(R.id.seekbar_text);
        seekBar = (SeekBar) findViewById(R.id.seekbar);

        seektext.setText("Hello Im Seekbar");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                seektext.setTextSize(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
