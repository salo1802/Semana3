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
import android.widget.TextView;
import android.widget.Toast;

public class NotasInputActivity extends AppCompatActivity {

    private Button calcular;
    private Double nota;
    private EditText[] notas= new EditText[6];
    private boolean ok = false;
    private ConstraintLayout layout;

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

        layout = findViewById(R.id.notasLayout);

        SharedPreferences  preferences = getSharedPreferences("preferencias",MODE_PRIVATE);

        calcular.setOnClickListener(
                (view) ->{
                    calcularNotas();
                    if(ok==true){
                   Intent icalculado = new Intent(this, ResultadoActivity.class);
                    icalculado.putExtra("nota", nota);

                    startActivity(icalculado);}
                }
        );

    }

    private void calcularNotas() {



        Double[] notasNumeros = new Double[6];



        //limitadores
        char[] ch = new char[1];

        for (int i=0;i<6;i++){
            notas[i].setText(notas[i].getText().toString().replace(',','.'));
            if(notas[i].getText().toString().equals("")){
            Toast.makeText(this, "Por favor rellene todos  los campos", Toast.LENGTH_SHORT).show();
            }
            else{
                ok=true;}

        }
        if(ok==true) {

            for (int i=0;i<6;i++){

            notasNumeros[i] = Double.parseDouble(notas[i].getText().toString());}

            nota = (((notasNumeros[0] * 15) / 100) + ((notasNumeros[1] * 15) / 100) +
                    ((notasNumeros[2] * 15) / 100) + ((notasNumeros[3] * 25) / 100) +
                    ((notasNumeros[4] * 25) / 100) + ((notasNumeros[5] * 5) / 100));
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences =getSharedPreferences ("preferencias",MODE_PRIVATE);
        String fondo = preferences.getString("color", "#FFFFFF");
        layout.setBackgroundColor(Color.parseColor(fondo));
    }
}