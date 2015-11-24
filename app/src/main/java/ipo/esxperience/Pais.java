package ipo.esxperience;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by GigiLasVegas on 20/11/2015.
 */
public class Pais extends Activity{


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> listapaises= new ArrayList<>();
        String text = null;
        //String[] listaunis;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String[] listaunis = bundle.getStringArray("listaunis");
        setContentView(R.layout.llistauniversitats);


        final String[] listaop = new String[]{
                "Mubien","nicely", "su poia"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, listaunis);
        ListView unis = (ListView) findViewById(R.id.listView2);
        unis.setAdapter(adapter);
        unis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(Pais.this, Universitat.class);

                switch (position) {
                    case 0:
                        i.putExtra("name", "Universitat Rovira Y mi POYA");
                        i.putExtra("siglas", "URV");
                        i.putExtra("tlf", "977652354");
                        i.putExtra("email", "chaushdua@dsad");
                        i.putExtra("web", "www.asdasd.com");
                        i.putExtra("val", 3.0);
                        i.putExtra("listaop", listaop);
                        //i.putExtra("listaunis", listapaisuniv.get("España"));
                        break;
                    case 1:
                        i.putExtra("name", "Universitat Rovira Y mi POYA");
                        i.putExtra("siglas", "URV");
                        i.putExtra("tlf", "977652354");
                        i.putExtra("email", "chaushdua@dsad");
                        i.putExtra("web", "www.asdasd.com");
                        i.putExtra("val", 3.0);
                        i.putExtra("listaop", listaop);
                        break;
                }

                startActivity(i);

            }
        });

    }

}
