package com.example.admin.tourisguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Rachit on 10/29/2016.
 */
public class cinemas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.Bioscope),R.drawable.cinepolis, "286 Fox St,City and Suburban,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.sterkinkor), R.drawable.cinepolis,"Newtown Mall,Miriam Makeba St,Newtown,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.SABC), R.drawable.piccadily,"Henley Rd & Artillery Rd,Aukland Park,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.Maboneng), R.drawable.wavecinema,"286 Fox St & Kruger St,Jeppestown,Johannesburg,south africa"));
        InputAdapter adapter = new InputAdapter(this, words, R.color.cinemas);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Words pos = words.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+pos.getLocation()+"?q="+pos.getText() + "  Johannesburg"));
                startActivity(intent);
            }
        });
    }
}
