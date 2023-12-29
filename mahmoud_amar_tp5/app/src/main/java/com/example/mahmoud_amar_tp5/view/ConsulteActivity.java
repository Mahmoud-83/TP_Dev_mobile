package com.example.mahmoud_amar_tp2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mahmoud_amar_tp2.R;

public class ConsulteActivity extends AppCompatActivity {

    private TextView tvResulate;
    private Button btnretour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulte);
        init();
        Intent intent = getIntent();
        String reponse = intent.getStringExtra("reponse");
        tvResulate.setText(reponse);

        btnretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(reponse!= null)
                    setResult(RESULT_OK,intent);

               else
                   setResult(RESULT_CANCELED,intent);
               finish();
            }
        });
    }

    private void init(){
        tvResulate = (TextView) findViewById(R.id.tvReponse);
        btnretour = (Button) findViewById(R.id.btnReturn);
    }

}