package ipo.esxperience;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by GigiLasVegas on 20/11/2015.
 */
public class Pais extends Activity {
    ArrayList<String> listapaises= new ArrayList<>();
    String text;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.llistauniversitats);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, listapaises);
        ListView paises = (ListView) findViewById(R.id.listView);
        paises.setAdapter(adapter);
    }
    public void setText(String text){
        listapaises.add(text);
    }

}
