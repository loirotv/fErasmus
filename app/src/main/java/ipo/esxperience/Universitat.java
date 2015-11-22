package ipo.esxperience;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by OriolGarcia on 22/11/15.
 */

class Leaker //Clase para poder usar infoUni, de static a non-static, sacado de StackOverflow
{
    public static Object leakedObj;
}

public class Universitat extends Activity {

    public class infoUni {
        String tlf, email, web;
        int val; // Valoracion en estrellas, de 1 a 5

        public infoUni(String tlf, String email, String web, int val){
            this.tlf = tlf;
            this.email = email;
            this.web=web;
            this.val=val;
            int numVal = 0; //contador de valoraciones para calcular la media
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> listaUnivesidades= new ArrayList<>();
        String text = null;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String[] listaComentarios = bundle.getStringArray("listaComentarios");
       // setContentView(R.layout.llistaComentaris); ARREGLAR ERROR, tengo q crear el layout

       // Leaker.leakedObj = new infoUni(); // Tenemos que pasarle por parametro la infoUni que deseemos

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, listaComentarios);
        ListView comentarios = (ListView) findViewById(R.id.listView2);
        comentarios.setAdapter(adapter);
    }
    public void setText(String[] text){
        text=text;
    }
}
