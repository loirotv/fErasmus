package ipo.esxperience;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import ipo.esxperience.Logic.ListaUniversidades;
import ipo.esxperience.Logic.Universidad;

/**
 * Created by OriolGarcia on 22/11/15.
 */


public class Universitat extends Activity {
    String tlf;
    String email;
    String web;
    String name;
    String siglas;
    String opinion;
    float val,valoracion;
    ListView coments;
    Universidad uni;
    int numVal = 0;
    ArrayAdapter<String> adapter;
    int i = 0;
    ListaUniversidades listaUniversidades;
    RatingBar rating;
    EditText et,et2;
    // AÑADIR COMENTARIO

    private void writeToFile(String iduni, String usuario, float estrella, String opinion) {
        if(usuario == null){
            usuario = "Anonimo";
        }
        String data = iduni+","+usuario+","+estrella+","+opinion+"\n";
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("opiniones.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            leerTxt(listaUniversidades);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    public void leerTxt(ListaUniversidades lista) {
        try {
            InputStream raw = getResources().openRawResource(R.raw.universidades);
            BufferedReader is = null;
            is = new BufferedReader(new InputStreamReader(raw, "UTF8"));
            InputStream raw2 = getResources().openRawResource(R.raw.opiniones);
            BufferedReader is2 = new BufferedReader(new InputStreamReader(raw2, "UTF8"));
            listaUniversidades = new ListaUniversidades(is, is2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

        final ArrayList<String> opiniones= new ArrayList<String>();
        while(i<listaopiniones.length){
            opiniones.add(listaopinionesnombres[i] + "\n" + listaopiniones[i]);
            i++;
        }


        adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, opiniones);
        coments = (ListView) findViewById(R.id.listViewUni);
        coments.setAdapter(adapter);
        leerTxt(listaUniversidades);
        ImageView img = (ImageView) findViewById(R.id.imageView);
        TextView nom = (TextView) findViewById(R.id.TextViewUni);
        TextView correo = (TextView) findViewById(R.id.textView2);
        TextView tel = (TextView) findViewById(R.id.textView3);
        TextView webid = (TextView) findViewById(R.id.textView4);
        rating = (RatingBar) findViewById(R.id.ratingBar);
        nom.setText(name);
        tel.setText(tlf);
        webid.setText(web);
        correo.setText(email);
        uni = listaUniversidades.getUniversidad(name);
        rating.setRating(uni.getValoracion());
        img.setImageResource(R.drawable.campus);
        Button enviar = (Button) findViewById(R.id.button);
       // et = (EditText) findViewById(R.id.editText);
       // et2 = (EditText) findViewById(R.id.editText3);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  opinion = et.getText().toString();
                valoracion =Float.parseFloat(et2.getText().toString());
                uni.addOpinion("Anonimo", valoracion, opinion);
                coments = (ListView) findViewById(R.id.listViewUni);
                opiniones.add(opinion);
                coments.setAdapter(adapter);
                et.setText("");
                et2.setText("");
                rating.setRating(uni.getValoracion());*/
                //writeToFile(name,null,3,opinion);


            }
        });

        }
}
