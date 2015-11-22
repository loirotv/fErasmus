package ipo.esxperience;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.HashMap;

/**
 * Created by GigiLasVegas on 20/11/2015.
 */
public class BuscaUniversitat extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscauni);
        final String[] listapaises = new String[]{
                "España","Francia", "Rumania", "Italia", "Reino Unido"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, listapaises);
        ListView paises = (ListView) findViewById(R.id.listView);
        paises.setAdapter(adapter);
        final String[] listaunisEsp = new String[]{
                "URV","UPC", "UAB", "UOC", "UEM","UEX"
        };
        String[] listaunisFra = new String[]{
                "LaFont","Montpelliere", "Eiffel"
        };
        final HashMap<String, String[]> listapaisuniv = new HashMap();
        listapaisuniv.put("España", listaunisEsp);
        listapaisuniv.put("Francia",listaunisFra);
        listapaisuniv.put("España", listaunisEsp); // CHUS! aquí porque pones dos veces la lista de unis de España?? -Oriol
        paises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(BuscaUniversitat.this, Pais.class);
//AQUI NO ENTIENDO QUE ESTAS HACIENDO, HABRA Q HACER ESTO PARA CADA PAIS? DEBERIAMOS HACERLO MEJOR, CON HERENCIA O ALGO - Oriol
                switch (position){
                    case 0:
                        String[] string = listapaisuniv.get("España");
                        i.putExtra("listaunis",listaunisEsp);
                        startActivity(i);
                        break;
                    case 1:
                        //cargapais.putExtra("Universitat", "URV");
                        break;
                }


            }
        });

    }

}

