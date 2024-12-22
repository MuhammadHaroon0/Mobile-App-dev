package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SingleProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);
        Intent intent=getIntent();
        TextView ntv= findViewById(R.id.pname);
        TextView ptv= findViewById(R.id.pprice);
        TextView atv= findViewById(R.id.pavail);
        ImageView itv= findViewById(R.id.pimage);
        String pname= intent.getStringExtra("pname");
        int pimage= intent.getIntExtra("pimage",0);
        String pprice= intent.getStringExtra("pprice");
        String pavail= intent.getStringExtra("pavail");
        Log.d("helo",pname+"/n"+"/n"+pprice+"/"+pavail);
        ntv.setText(pname);
        ptv.setText(pprice);
        atv.setText(pavail);
        itv.setImageResource(pimage);


    }
}