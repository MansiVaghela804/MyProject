package com.example.admin.myproject.RegistrationApi.APIInterface;

import com.example.admin.myproject.RegistrationApi.Api_response.Registration;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIinterface {

    @FormUrlEncoded
    @POST("registration.php")
    Call<Registration> GET_BRAND_RESPONSE_CALL(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("mobileno") String mobileno,
            @Field("gender") String gender);
}
