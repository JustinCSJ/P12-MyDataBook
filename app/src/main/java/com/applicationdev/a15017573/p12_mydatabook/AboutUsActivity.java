package com.applicationdev.a15017573.p12_mydatabook;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AboutUsActivity extends AppCompatActivity {

    ActionBar ab;
    ListView lv;
    String [] authors = {"Ah Cheng", "Ah Jun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        lv = (ListView)findViewById(R.id.lv);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,authors);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AboutUsActivity.this, AuthorDetails.class);
                intent.putExtra("position",i);
                intent.putExtra("name",authors[i]);
                startActivity(intent);
            }
        });

    }
}
