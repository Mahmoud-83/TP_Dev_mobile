package com.example.mahmoud_amar_tp2.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoud_amar_tp2.R;
import com.example.mahmoud_amar_tp2.controller.Controller;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE=1;
    private TextView tvAge;
    private SeekBar barage ;
    private RadioButton btnoui;
    private RadioButton btnnon;
    private EditText valeur;
    private Button btnConsulter;
//    private TextView textresultat;

    // sans singilton
    // public Controller controller = new Controller();


    // en utilisent singelton
    private  Controller controller = Controller.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        // create a  listener for Seekbar
        barage.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                        tvAge.setText("votre age : "+progress);
                        Log.i("INFORMATION","onProgressChanged : "+progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("Information","Button clique");
                int age =barage.getProgress();
                float valeurMesuree = Float.parseFloat(valeur.getText().toString());
                boolean isfasting=btnoui.isChecked();
                boolean verifier_age= false;
                boolean verifier_valeur=false;
                if(age!=0)
                    verifier_age =true ;
                else
                    Toast.makeText(MainActivity.this,"Veuillez verfier votre age",Toast.LENGTH_SHORT).show();

                if(!valeur.getText().toString().equals(""))
                    verifier_valeur =true ;
                else
                    Toast.makeText(MainActivity.this,"Veuillez verfier votre valeur a mesure",Toast.LENGTH_LONG).show();
                if(verifier_age && verifier_valeur){
                    controller.createPatient(age,isfasting,valeurMesuree);
//                    textresultat.setText(controller.getReponse());
                    Intent intent = new Intent(MainActivity.this, ConsulteActivity.class);
                    // has 5 element  (action , extra, data ,type, categerio )
                    intent.putExtra("reponse",controller.getReponse());
                    startActivityForResult(intent,REQUEST_CODE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CANCELED)
                Toast.makeText(MainActivity.this, "Erreur : resultat null", Toast.LENGTH_SHORT).show();
        }
    }

    private void init(){
        tvAge = (TextView) findViewById(R.id.idAge);
        barage = (SeekBar) findViewById(R.id.sbAge);
        btnoui = (RadioButton) findViewById(R.id.btnoui);
        btnnon = (RadioButton) findViewById(R.id.btnnon);
        valeur = (EditText) findViewById(R.id.valeur);
        btnConsulter = (Button) findViewById(R.id.btnConsulter);
//        textresultat = (TextView) findViewById(R.id.textresultat);
    }

}