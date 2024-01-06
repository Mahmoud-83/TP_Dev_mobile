package com.example.mahmoud_amar_tp2.model;


public class Patient {
   private int age ;
   private boolean Isjune;
   private float valeur;
   private String resultat;


   // Notify controller --> model
   public Patient(int age , boolean june , float valeur ){
       this.age = age;
       this.Isjune = june ;
       this. valeur = valeur;
       // appel de calculer dans le constructeur ...
       String resultat =  calculer();

   }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isJune() {
        return Isjune;
    }

    public void setJune(boolean june) {
        this.Isjune = june;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                ", june=" + Isjune +
                ", valeur=" + valeur +
                ", resultat='" + resultat + '\'' +
                '}';
    }


    private String calculer(){
        if (Isjune) {
            if (age >= 13) {
                if (valeur < 5.0) {
                    resultat = ("Niveau de glycémie est trop bas");
                } else if (valeur >= 5.0 && valeur <= 7.2) {
                    resultat=("Niveau de glycémie est normale");
                } else {
                    resultat=("Niveau de glycémie est trop élevé");
                }
            } else if (age >= 6 && age <= 12) {
                if (valeur < 5.0) {
                    resultat=("Niveau de glycémie est trop bas");
                } else if (valeur >= 5.0 && valeur <= 10.0) {
                    resultat=("Niveau de glycémie est normale");
                } else {
                    resultat=("Niveau de glycémie est trop élevé");
                }
            } else if (age <6){
                if (valeur < 5.5) {
                    resultat=("Niveau de glycémie est trop bas");
                } else if (valeur >= 5.5 && valeur <= 10.0) {
                    resultat=("Niveau de glycémie est normale");
                } else {
                    resultat=("Niveau de glycémie est trop élevé");
                }
            }
        } else {
            if (valeur > 10.5) {
                resultat=("Niveau de glycémie est trop élevé");
            } else {
                resultat=("Niveau de glycémie est normale");
            }
        }
        return  resultat;
    }
}
