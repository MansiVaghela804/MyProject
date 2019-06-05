package com.example.admin.myproject.RegistrationApi;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.admin.myproject.R;
import com.example.admin.myproject.RegistrationApi.APIInterface.APIinterface;
import com.example.admin.myproject.RegistrationApi.APIManager.APICilent;
import com.example.admin.myproject.RegistrationApi.Api_response.Registration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    EditText name, email, mobileno, password;
    RadioGroup radioGroup;
    RadioButton rb;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = (EditText) findViewById(R.id.edtext1);
        email = (EditText) findViewById(R.id.edtext2);
        mobileno = (EditText) findViewById(R.id.edtext3);
        password = (EditText) findViewById(R.id.edtext4);
        radioGroup = (RadioGroup) findViewById(R.id.radio_grp);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton) group.findViewById(checkedId);
                if (null != rb && checkedId > -1) {
                    Toast.makeText(RegistrationActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        save = (Button) findViewById(R.id.btn1);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loaddata();
            }
        });


    }

    public void Loaddata() {
        String name1 = name.getText().toString();
        String email1 = email.getText().toString();
        String mobile = mobileno.getText().toString();
        String pass = password.getText().toString();
        String rbText = rb.getText().toString();

        APIinterface apIinterface = APICilent.getClient().create(APIinterface.class);

        Call<Registration> getBrandResponseCall = apIinterface.GET_BRAND_RESPONSE_CALL(name1, email1, mobile
                , pass, rbText);

        getBrandResponseCall.enqueue(new Callback<Registration>() {
            @Override
            public void onResponse(Call<Registration> call, Response<Registration> response) {
                Toast.makeText(RegistrationActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Registration> call, Throwable t) {
                Log.e("##", t.getMessage());
            }
        });


    }
}

