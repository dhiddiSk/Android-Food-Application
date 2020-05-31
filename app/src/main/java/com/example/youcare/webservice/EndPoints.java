package com.example.youcare.webservice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoints {

    // Karthik Api

    @GET("employees")
    Call<StatusModel> getAllEmployees();

    // SaiKrishna Apis Work
    @GET("/employee/1")
    Call<StatusModel> getAllEmployeeDetails();

    // murli
    @GET("/UpdateEmployee")
    Call<StatusModel> updateEmployeeDetail();



}
