package com.example.semana3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NotasInputActivity extends AppCompatActivity {

    private Button calcular;
    private Double nota;
    private EditText[] notas= new EditText[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notas[0] = findViewById(R.id.nota1);
        notas[1] = findViewById(R.id.nota2);
        notas[2] = findViewById(R.id.nota3);
        notas[3] = findViewById(R.id.nota4);
        notas[4] = findViewById(R.id.nota5);
        notas[5] = findViewById(R.id.nota6);

        calcular = findViewById(R.id.calcularBtn);

        calcular.setOnClickListener(
                (view) ->{
                    calcularNotas();
                   Intent icalculado = new Intent(this, ResultadoActivity.class);
                    icalculado.putExtra("nota", nota);
                    startActivity(icalculado);
                }
        );

    }

    private void calcularNotas() {

        Double[] notasNumeros = new Double[6];
        for (int i=0;i<6;i++){

            notasNumeros[i] = Double.parseDouble(notas[i].getText().toString());
        }

        nota = (((notasNumeros[0]*15)/100) + ((notasNumeros[1]*15)/100)+
                ((notasNumeros[2]*15)/100) + ((notasNumeros[3]*25)/100) +
                ((notasNumeros[4]*25)/100) + ((notasNumeros[5]*5)/100));



    }
}