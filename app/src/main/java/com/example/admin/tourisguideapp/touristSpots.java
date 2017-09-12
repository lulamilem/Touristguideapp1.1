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
public class touristSpots extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words(getString(R.string.lake), R.drawable.subway,"Miriam Makeba St & Helen Joseph Street,Newtown,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.Airport), R.drawable.subway,"O R Tambo Airport Rd,O.R. Tambo,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.rock), R.drawable.subway,"11 Kotze St,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.elante), R.drawable.subway,"S Park Ln,New Doornfontein,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.zoo), R.drawable.subway,"Jan Smuts Avenue & Upper Park Dr,Parkview,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.rose), R.drawable.subway,"A 41,Park Station,Rissik St,CBD,Johannesburg,south africa"));
        InputAdapter adapter = new InputAdapter(this, words, R.color.tourists);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Words pos = words.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+pos.getLocation()+"?q="+pos.getText() + " in Johannesburg"));
                startActivity(intent);
            }
        });
    }
}
