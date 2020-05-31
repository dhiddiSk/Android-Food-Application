package com.example.youcare.webservice;

import java.util.ArrayList;

public class StatusModel {

    private String status;
    private ArrayList<EmployeeModel> data;

    public StatusModel(String status, ArrayList<EmployeeModel> data) {
        this.status = status;
        this.data = data;
    }
}
