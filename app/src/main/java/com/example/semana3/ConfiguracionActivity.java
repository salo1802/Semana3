package com.example.semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class ConfiguracionActivity extends AppCompatActivity {
    private Button botonA, botonB, botonN;
    private String azul,blanco, gris;
    private ConstraintLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        azul = "#A9EFF3";
        blanco = "#FFFFFF";
        gris = "#999999";
        botonA = findViewById(R.id.colorAzul);
        botonB = findViewById(R.id.colorBlanco);
        botonN = findViewById(R.id.colorGris);
        layout = findViewById(R.id.configLayout);

        SharedPreferences preferences = getSharedPreferences("preferencias",MODE_PRIVATE);


        botonA.setOnClickListener(
                (view)->{

                    preferences.edit().putString("color",azul).apply();

                    finish();
                }
        );

        botonB.setOnClickListener(
                (view)->{
                    preferences.edit().putString("color",blanco).apply();

                    finish();
                }
        );

        botonN.setOnClickListener(
                (view)->{
                    preferences.edit().putString("color", gris).apply();

                    finish();
                }
        );


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences =getSharedPreferences ("preferencias",MODE_PRIVATE);
        String fondo = preferences.getString("color", "#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(fondo));
    }
}