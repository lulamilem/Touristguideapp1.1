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
public class clubs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words(getString(R.string.haze), R.drawable.haze,"110 Claim St,Hillbrow,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.paara), R.drawable.paara,"94 Juta St,Johannesburg,south africa"));
        words.add(new Words(getString(R.string.score), R.drawable.score,"Newtown Mall,Newtown,Johannesburg,south africa"));
        InputAdapter adapter = new InputAdapter(this, words, R.color.clubs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Words pos = words.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+pos.getLocation()+"?q="+pos.getText() + " in Johannesburg"));
            }
        });
    }
}
