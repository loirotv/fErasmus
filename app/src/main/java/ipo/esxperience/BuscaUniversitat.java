package ipo.esxperience;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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
        paises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Pais cargapais = new Pais();

                switch (position){
                    case 0:
                        cargapais.setText("URV");
                        cargapais.setText("URV");
                        cargapais.setText("URV");
                        cargapais.setText("URV");


                        break;
                    case 1:
                        //cargapais.putExtra("Universitat", "URV");
                        break;
                }
                //Intent i = new Intent(BuscaUniversitat.this, cargapais.getClass());
               // startActivity(i);
            }
        });

    }

}

