package com.example.admin.myproject.ContactUs;

import com.example.admin.myproject.ContactUs.Apiresponse.Contactus;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIInterface {

    @FormUrlEncoded
    @POST("contactus.php")
    Call<Contactus> GET_BRAND_RESPONSE_CALL(
            @Field("user_name") String user_name,
            @Field("user_email") String user_email,
            @Field("user_mobileno") String user_mobileno,
            @Field("user_msg") String user_msg);
}