package com.example.youcare.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.youcare.R;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeActivity extends AppCompatActivity {

    private EndPoints endPoints;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        textView = findViewById(R.id.tv);

        endPoints = RetrofitClient.getRetrofit().create(EndPoints.class);

        Call<StatusModel> call = endPoints.getAllEmployees();

        call.enqueue(new Callback<StatusModel>() {
            @Override
            public void onResponse(Call<StatusModel> call, Response<StatusModel> response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                    String status = jsonObject.getString("status");

                    textView.setText("Success "+status);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<StatusModel> call, Throwable t) {
                textView.setText( "Error " + t.getMessage());
            }
        });

    }
}
