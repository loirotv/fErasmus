package ipo.esxperience;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, listaunis);
        ListView unis = (ListView) findViewById(R.id.listView2);
        unis.setAdapter(adapter);
    }
    public void setText(String[] text){
        text=text;
    }

}
