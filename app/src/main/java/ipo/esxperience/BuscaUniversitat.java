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

import ipo.esxperience.Logic.ListaUniversidades;

/**
 * Created by GigiLasVegas on 20/11/2015.
 */
public class BuscaUniversitat extends Activity {
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
        setContentView(R.layout.buscauni);

        final String[] listapaises = new String[]{
                "España","Francia", "Rumania", "Italia", "Reino Unido"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, listapaises);
        ListView paises = (ListView) findViewById(R.id.listView);
        paises.setAdapter(adapter);

        leerTxt(listaUniversidades);

        paises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(BuscaUniversitat.this, Pais.class);

                switch (position){
                    case 0:
                        i.putExtra("listaunis", listaUniversidades.buscarPais("Espana").getNombresCompletos());
                        break;
                    case 1:
                        i.putExtra("listaunis", listaUniversidades.buscarPais("Francia").getNombresCompletos());
                        break;
                    case 2:
                        i.putExtra("listaunis", listaUniversidades.buscarPais("Rumania").getNombresCompletos());
                        break;
                    case 3:
                        i.putExtra("listaunis", listaUniversidades.buscarPais("Italia").getNombresCompletos());
                        break;
                    case 4:
                        i.putExtra("listaunis", listaUniversidades.buscarPais("Reino Unido").getNombresCompletos());
                        break;
                }

                startActivity(i);

            }
        });

    }

}

