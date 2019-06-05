package com.example.admin.myproject.ContactUs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.myproject.ContactUs.Apiresponse.Contactus;
import com.example.admin.myproject.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactusActivity extends AppCompatActivity {
    EditText name,email,mobileno,msg;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        name=(EditText)findViewById(R.id.edt1);
        email=(EditText)findViewById(R.id.edt2);
        mobileno=(EditText)findViewById(R.id.edt3);
        msg=(EditText)findViewById(R.id.edt4);

        save=(Button) findViewById(R.id.btn1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loaddata();
            }
        });


    }
    private void Loaddata() {
        APIInterface apiInterface= ApiClient.getClient().create(APIInterface.class);

        Call<Contactus> getBrandResponseCall=apiInterface.GET_BRAND_RESPONSE_CALL(name.getText().toString(),
                email.getText().toString(),
                mobileno.getText().toString(),
                msg.getText().toString());

        getBrandResponseCall.enqueue(new Callback<Contactus>() {
            @Override
            public void onResponse(Call<Contactus> call, Response<Contactus> response) {
                Toast.makeText(ContactusActivity.this,response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Contactus> call, Throwable t) {

            }
        });
    }
}
