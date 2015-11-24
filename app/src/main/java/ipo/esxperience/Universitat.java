package ipo.esxperience;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import ipo.esxperience.Logic.ListaUniversidades;

/**
 * Created by OriolGarcia on 22/11/15.
 */


public class Universitat extends Activity {
    String tlf;
    String email;
    String web;
    String name;
    String siglas;
    float val;
    int numVal = 0;

    // AÑADIR COMENTARIO
/*
    private void writeToFile(String usuario, int estrella, String opinion) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("opiniones.txt", Context.MODE_PRIVATE));
            //outputStreamWriter.write(data);
            // El sergio lo que quiere es que AQUI le hagamos universidad.addOpinion(usuario, estrella, opinion)
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }*/

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] listaopiniones;
        String text = null;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        name = intent.getStringExtra("name");
        siglas =intent.getStringExtra("siglas");
        email = intent.getStringExtra("email");
        tlf = intent.getStringExtra("tlf");
        web =intent.getStringExtra("web");
        val =bundle.getInt("val");
        listaopiniones = bundle.getStringArray("listaop");
        String [] listaopinionesnombres = bundle.getStringArray("listaopn");
        setContentView(R.layout.universidad);
        int i = 0;
        String[] opiniones= new String[listaopiniones.length];
        while(i<listaopiniones.length){
            opiniones[i] = listaopinionesnombres[i] + "\n" + listaopiniones[i];
            i++;
        }

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, opiniones);
        ListView coments = (ListView) findViewById(R.id.listViewUni);
        coments.setAdapter(adapter);

        ImageView img = (ImageView) findViewById(R.id.imageView);
        TextView nom = (TextView) findViewById(R.id.TextViewUni);
        RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
        nom.setText(name);
        rating.setRating(val);
        img.setImageResource(R.drawable.campus);

    }


    public void setText(String[] text){
        text=text;
    }
}
