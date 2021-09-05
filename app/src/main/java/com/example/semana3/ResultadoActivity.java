package com.example.semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.stream.IntStream;

public class ResultadoActivity extends AppCompatActivity {

    private Button recalcular;
    private TextView notatexto,saludo;
    private String nota,nombre;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        String nombre = getSharedPreferences("preferencias",MODE_PRIVATE).getString("nombre","NO_USER");
        nota = "" + getIntent().getExtras().getDouble("nota");
        
        notatexto = findViewById(R.id.notaFinal);
        saludo = findViewById(R.id.saludoNombre);
        saludo.setText("Hola, "+ nombre + ". Tu nota final es de:");
        //restricciones
        if(nota.length()>4){
        char[] ch = new char[nota.length()];
        for(int i=0;nota.length()>i;i++){
            ch[i] = nota.charAt(i);
        }
        String sum;
        sum = ""+ch[0]+ch[1]+ch[2]+ch[3];
            nota = sum;
            notatexto.setText(nota);
            }
        else{
        notatexto.setText(nota);}

        layout = findViewById(R.id.resultLayout);

        recalcular = findViewById(R.id.recalcular);

        recalcular.setOnClickListener(
                (view)->{
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