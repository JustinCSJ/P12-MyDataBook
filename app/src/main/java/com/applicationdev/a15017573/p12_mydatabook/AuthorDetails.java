package com.applicationdev.a15017573.p12_mydatabook;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AuthorDetails extends AppCompatActivity {

    ActionBar ab;
    String [] modules = {"C347 - Android Programming II Republic Polytechnic", "C349 iPAD Programming Republic Polytechnic"};
    TextView tvModule, tvName;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_details);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        tvModule = (TextView)findViewById(R.id.tvModule);
        tvName = (TextView)findViewById(R.id.tvName);
        iv = (ImageView)findViewById(R.id.iv);



        Intent intent = getIntent();
        int chosen = intent.getIntExtra("position",-1);
        String name = intent.getStringExtra("name");

        tvName.setText(name);
        tvModule.setText(modules[chosen]);

        if(chosen != -1){
            Picasso.with(AuthorDetails.this).load("https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg")
                    .fit().centerCrop()
                    .placeholder(R.drawable.ajax_loader)
                    .error(R.drawable.error)
                    .into(iv);
        } else {
            Picasso.with(this).load(R.drawable.error).into(iv);
        }


    }
}
