package com.example.semana3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    private EditText nombre;
    private String nombreString;
    private Button continuar, config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);

        nombre = findViewById(R.id.nombreEdit);
        config = findViewById(R.id.config);
        continuar = findViewById(R.id.continuar);

        continuar.setOnClickListener(
                (view) -> {
                    Log.e("Boton","funciono");
                    if (!nombre.getText().toString().equals("")) {
                        nombreString = nombre.getText().toString();
                        Intent i = new Intent(this, NotasInputActivity.class);
                        Intent iN = new Intent(this, ResultadoActivity.class);
                        iN.putExtra("nombre", nombreString);
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
}