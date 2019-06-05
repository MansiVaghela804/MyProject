package com.example.admin.myproject.Time_Date_Picker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.admin.myproject.R;

import java.util.Calendar;

public class Time_picker extends AppCompatActivity {
    EditText Time, Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

//       Timepicker

        Time = (EditText) findViewById(R.id.time_pic);
        Time.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    Calendar mcurrentTime = Calendar.getInstance();

                    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mcurrentTime.get(Calendar.MINUTE);


                    TimePickerDialog mTimePicker;

                    mTimePicker = new TimePickerDialog(Time_picker.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                            Time.setText(selectedHour + ":" + selectedMinute);
                        }
                    }, hour, minute, true);//Yes 24 hour time

                    mTimePicker.setTitle("Select Time");
                    mTimePicker.show();

                }

            }
        });

//        DatePicker

        Date = (EditText) findViewById(R.id.date_pic);
        Date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Calendar mcurrentDate = Calendar.getInstance();

                    int day = mcurrentDate.get(Calendar.DAY_OF_MONTH);
                    int year = mcurrentDate.get(Calendar.YEAR);
                    int month = mcurrentDate.get(Calendar.MONTH);

                    DatePickerDialog datePickerDialog;
                    datePickerDialog = new DatePickerDialog(Time_picker.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            month = month + 1;
                            Date.setText("" + dayOfMonth + "/" + month + "/" + year);

                        }
                    }, day, year, month);

                    datePickerDialog.setTitle("Select Date");
                    datePickerDialog.show();
                }


            }
        });
    }
}
