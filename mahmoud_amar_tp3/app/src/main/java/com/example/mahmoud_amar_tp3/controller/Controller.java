package com.example.mahmoud_amar_tp2.controller;

import com.example.mahmoud_amar_tp2.model.Patient;

public class Controller {

    private static Controller instance =null; // pour singleton
    private static  Patient patient;
    private Controller(){
        super();
    } // et on return le Controller private 

    public void createPatient(int age , boolean isfating , float valeur){
        patient = new Patient(age,isfating,valeur);

    }

    //  methode singleton pour tester si le controller a deja creer  si non il le creer
    public static Controller getInstance(){
        if(instance == null)
            return instance = new Controller();
        return instance;
    }


    public String getReponse(){
        return patient.getResultat();
    }





}
