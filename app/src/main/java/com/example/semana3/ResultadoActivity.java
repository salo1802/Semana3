package com.example.semana3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private Button recalcular;
    private TextView notatexto,saludo;
    private String nota,nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       nota = "" + getIntent().getExtras().getDouble("nota");
        nombre = getIntent().getExtras().getString("nombre");
        notatexto = findViewById(R.id.notaFinal);
        saludo = findViewById(R.id.saludoNombre);

        saludo.setText("Hola, "+ nombre + ". Tu nota final es de:");
        notatexto.setText(nota);

        recalcular = findViewById(R.id.calcularBtn);

        recalcular.setOnClickListener(
                (view)->{
                    Intent i =new Intent(this, NameActivity.class);
                }
        );

    }

}