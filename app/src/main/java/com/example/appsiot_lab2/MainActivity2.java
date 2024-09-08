package com.example.appsiot_lab2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;


public class MainActivity2 extends AppCompatActivity {

    private String[] palabras;
    private Random random;
    private String palabraActual;
    private TextView[] letras;
    private LinearLayout wordLayout;
    private LetterAdapter adapter;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        palabras=getResources().getStringArray(R.array.palabras);
        wordLayout=findViewById(R.id.palabras);
        gridView = findViewById(R.id.letras);
        random = new Random();
        elegirPalabra();
    }


    private void elegirPalabra(){
        String nuevaPalabra=palabras[random.nextInt(palabras.length)];

        while (nuevaPalabra.equals(palabraActual)) nuevaPalabra=palabras[random.nextInt(palabras.length)];

        palabraActual = nuevaPalabra;

        letras = new  TextView[palabraActual.length()];
        for (int i=0; i<palabraActual.length();i++){
            letras[i] = new TextView(this);
            letras[i].setText(String.format("%s", palabraActual.charAt(i)));
            letras[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            letras[i].setGravity(Gravity.CENTER);
            letras[i].setTextColor(Color.WHITE);
            letras[i].setBackgroundResource(R.drawable.letras_base);
            wordLayout.addView(letras[i]);
        }
        adapter=new LetterAdapter(this);
        gridView.setAdapter(adapter);
    }

}
