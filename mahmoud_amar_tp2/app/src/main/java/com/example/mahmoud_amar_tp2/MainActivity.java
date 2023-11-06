package com.example.mahmoud_amar_tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvAge;
    private SeekBar barage ;
    private RadioButton btnoui;
    private RadioButton btnnon;
    private EditText valeur;
    private Button btnConsulter;
    private TextView textresultat;



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

                calculer(view);
            }
        });

    }


    public void calculer(View v){
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
        if (isfasting) {
            if (age >= 13) {
                if (valeurMesuree < 5.0) {
                    textresultat.setText("Niveau de glycémie est trop bas");
                } else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2) {
                    textresultat.setText("Niveau de glycémie est normale");
                } else {
                    textresultat.setText("Niveau de glycémie est trop élevé");
                }
            } else if (age >= 6 && age <= 12) {
                if (valeurMesuree < 5.0) {
                    textresultat.setText("Niveau de glycémie est trop bas");
                } else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0) {
                    textresultat.setText("Niveau de glycémie est normale");
                } else {
                    textresultat.setText("Niveau de glycémie est trop élevé");
                }
            } else if (age <6){
                if (valeurMesuree < 5.5) {
                    textresultat.setText("Niveau de glycémie est trop bas");
                } else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0) {
                    textresultat.setText("Niveau de glycémie est normale");
                } else {
                    textresultat.setText("Niveau de glycémie est trop élevé");
                }
            }
        } else {
            if (valeurMesuree > 10.5) {
                textresultat.setText("Niveau de glycémie est trop élevé");
            } else {
                textresultat.setText("Niveau de glycémie est normale");
            }
        }
        }



    }


    private void init(){
        tvAge = (TextView) findViewById(R.id.idAge);
        barage = (SeekBar) findViewById(R.id.sbAge);
        btnoui = (RadioButton) findViewById(R.id.btnoui);
        btnnon = (RadioButton) findViewById(R.id.btnnon);
        valeur = (EditText) findViewById(R.id.valeur);
        btnConsulter = (Button) findViewById(R.id.btnConsulter);
        textresultat = (TextView) findViewById(R.id.textresultat);
    }

}