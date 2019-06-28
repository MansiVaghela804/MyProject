package com.example.admin.myproject.Alertdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.myproject.R;

public class Main2Activity extends AppCompatActivity {
    Button btnalert;
AlertDialog alertDialog;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        context=this;

        btnalert=(Button)findViewById(R.id.btn_alert);

        btnalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(Main2Activity.this);
                builder.setMessage("Are you sure?");
                builder.setTitle("My One");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(Main2Activity.this, "done", Toast.LENGTH_SHORT).show();

                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Main2Activity.this, "no", Toast.LENGTH_SHORT).show();

                    }
                });

                alertDialog=builder.create();
                alertDialog.show();
            }
        });


    }

    public void customalert(View view) {
        LayoutInflater layoutInflater=(LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mview=layoutInflater.inflate(R.layout.customdialog_layout,null);

        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setView(mview);
        alertDialog=builder.create();
        alertDialog.show();
    }
}
