package com.example.semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    private EditText nombre;
    private String nombreString;
    private Button continuar, config;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);


        nombre = findViewById(R.id.nombreEdit);
        config = findViewById(R.id.config);
        continuar = findViewById(R.id.continuar);
        layout = findViewById(R.id.nombreLayout);

        SharedPreferences  preferences = getSharedPreferences("preferencias",MODE_PRIVATE);
        preferences.edit().putString("color","#FFFFFF").apply();

        continuar.setOnClickListener(
                (view) -> {
                    if (!nombre.getText().toString().equals("")) {
                        nombreString = nombre.getText().toString();
                        Intent i = new Intent(this, NotasInputActivity.class);
                        Log.e("name", nombreString);

                        preferences.edit().putString("nombre",nombreString).apply();
                        startActivity(i);
                    } else {
                        Toast.makeText(this, "Ponga su nombre para continuar", Toast.LENGTH_SHORT).show();
                    }

                }
        );

        config.setOnClickListener(
                (view)->{

                    Intent iConf = new Intent(this, ConfiguracionActivity.class);
                    startActivity(iConf);
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