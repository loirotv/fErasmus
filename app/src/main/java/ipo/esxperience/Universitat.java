package ipo.esxperience;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

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
        setContentView(R.layout.universidad);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, listaopiniones);
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
