package com.example.appsiot_lab2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textViewColor;
    private int numeroColor = 0;
    private EditText editText;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewColor = findViewById(R.id.textViewColor);

        editText = findViewById(R.id.editTextText);
        button = findViewById(R.id.button);

        //Se hizo uso de chatgpt para saber como saber el estado del texto en el edit text (cuando hay o no hay texto), para ello usó el textwatcher

        editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().isEmpty()) {
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }

            public void afterTextChanged(Editable s) {
            }
        });

    }

    public void cambiarColor(View view){
        if(numeroColor == 0){
            textViewColor.setTextColor(Color.GREEN);
            numeroColor = 1;
        }
        else if(numeroColor == 1){
            textViewColor.setTextColor(Color.RED);
            numeroColor = 2;
        }
        else if (numeroColor == 2) {
            textViewColor.setTextColor(Color.MAGENTA);
            numeroColor = 0;
        }
    }


    public void abrirJuego(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra()
        startActivity(intent);
    }




}