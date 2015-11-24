package ipo.esxperience;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;

import ipo.esxperience.Logic.ListaUniversidades;
import ipo.esxperience.Logic.Universidad;

/**
 * Created by GigiLasVegas on 20/11/2015.
 */
public class Pais extends Activity{
    ListaUniversidades listaUniversidades;

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
        ArrayList<String> listapaises= new ArrayList<>();
        String text = null;
        //String[] listaunis;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String[] listaunis = bundle.getStringArray("listaunis");
        setContentView(R.layout.llistauniversitats);
        final String paisactual = bundle.getString("paisactual");
        //claselistauniv = (ListaUniversidades) intent.getSerializableExtra("listacompleta");


        final String[] listaop = new String[]{
                "Mubien","nicely", "su poia"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, listaunis);
        ListView unis = (ListView) findViewById(R.id.listView2);
        unis.setAdapter(adapter);
        leerTxt(listaUniversidades);
        unis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(Pais.this, Universitat.class);
                
                        i.putExtra("name", listaUniversidades.buscarPais(paisactual).getUniversidad(position).nombre);
                        i.putExtra("siglas", listaUniversidades.buscarPais(paisactual).getUniversidad(position).siglas);
                        i.putExtra("tlf", listaUniversidades.buscarPais(paisactual).getUniversidad(position).telefono);
                        i.putExtra("email", listaUniversidades.buscarPais(paisactual).getUniversidad(position).email);
                        i.putExtra("web", listaUniversidades.buscarPais(paisactual).getUniversidad(position).web);
                        i.putExtra("val", listaUniversidades.buscarPais(paisactual).getUniversidad(position).getValoracion());
                        i.putExtra("listaop", listaUniversidades.buscarPais(paisactual).getUniversidad(position).getTexto());
                        i.putExtra("listaopn", listaUniversidades.buscarPais(paisactual).getUniversidad(position).getUsuarios());



                startActivity(i);

            }
        });

    }

}
