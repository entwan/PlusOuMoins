package com.dam.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /** Var globales */
    private Button btnJouer, btnRejouer, btnQuitter;

    private EditText etNombre;

    private TextView tvResult, tvConsigne;

    private int nbUser, nbRandom;

    private static final int MAX = 20;

    private static final String TAG = "MainActivity";

    /** Methode d'initialisation des widgets // lien Java et design */
    private void initUI(){
        btnJouer = findViewById(R.id.btnJouer);
        btnRejouer = findViewById(R.id.btnRejouer);
        btnQuitter = findViewById(R.id.btnQuitter);

        etNombre = findViewById(R.id.etNombre);
        tvConsigne = findViewById(R.id.tvConsigne);
        tvResult = findViewById(R.id.tvResult);
        tvConsigne.setText("Devine un nombre entre 0 et " + MAX);
    }

    public void devine(View view){
        // La récupération du texte
        String strNbUser = etNombre.getText().toString().trim();
        nbUser = Integer.parseInt(strNbUser);

        //Affichage dans le log
        Log.i(TAG, "Le nombre random est : " + nbRandom + " Le nombre de l'utilisateur est : " + nbUser);
        if (nbUser > MAX) {
            tvResult.setText("Veuillez entrer un nombre entre 0 et " + MAX + ".");
        }
        else {
            if (nbUser == nbRandom) {
                tvResult.setText("Bravo EKT! ;)");
                afficherRejouerouQuitter();
                //generateRandomNumber();
            } else {
                if (nbUser < nbRandom) {
                    tvResult.setText("+");
                } else {
                    tvResult.setText("-");
                }
            }
        }
        //tvResult.setText(strNbUser);
        tvResult.setVisibility(View.VISIBLE);
    }

    public void rejouer(View view) {
        generateRandomNumber();
        tvResult.setVisibility(View.GONE);
        cacherRejouerouQuitter();
        btnJouer.setEnabled(true);

    }

    public void quitter(View view) {
        finish();
        System.exit(0);
    }
    private void afficherRejouerouQuitter(){
        btnJouer.setEnabled(false);
        btnRejouer.setVisibility(View.VISIBLE);
        btnQuitter.setVisibility(View.VISIBLE);
    }

    private void cacherRejouerouQuitter(){
        btnRejouer.setVisibility(View.GONE);
        btnQuitter.setVisibility(View.GONE);
    }

    private void generateRandomNumber(){
        Random rand = new Random();
        // pour avoir un nombre entre 0 et MAX inclus
        nbRandom = rand.nextInt(MAX + 1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO à faire demain
        initUI();
        generateRandomNumber();

    }
}