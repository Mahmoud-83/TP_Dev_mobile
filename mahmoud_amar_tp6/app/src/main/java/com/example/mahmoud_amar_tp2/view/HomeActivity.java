package com.example.mahmoud_amar_tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mahmoud_amar_tp2.R;
import com.example.mahmoud_amar_tp2.controller.LoginController;

public class HomeActivity extends AppCompatActivity {
    private LoginController loginController;
    private EditText idlogin;
    private EditText idpass;

    private Button btnConsultation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       init();

        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void init(){
        loginController =LoginController.getInstance(this);
        btnConsultation = (Button) findViewById(R.id.btnConsultation);
        idlogin = (EditText) findViewById(R.id.etUserName);
        idpass = (EditText) findViewById(R.id.etPassword);
    }

}