package com.example.appsiot_lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class LetterAdapter extends BaseAdapter {
    private String[]letras;
    private LayoutInflater letterInf;

    public LetterAdapter(Context context){
        letras = new String[26];
        for (int i=0; i<letras.length;i++){
            letras[i] = ""+(char)(i+'A');
        }
        letterInf=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return letras.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Button botonLetra;
        if(view==null){
            botonLetra=(Button) letterInf.inflate(R.layout.letras,viewGroup,false);
        }else {
            botonLetra=(Button) view;
        }
        botonLetra.setText(letras[i]);
        return botonLetra;
    }
}
