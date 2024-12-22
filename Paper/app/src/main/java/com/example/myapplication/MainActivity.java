package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onCategoryClick(View v){
        LinearLayout ly=(LinearLayout)v;
        int id=ly.getId();
        Intent intent=new Intent(MainActivity.this, ProductDetails.class);
        if(id==R.id.men)
        {
            intent.putExtra("category","Men's Clothing");
            Toast.makeText(this, "You clicked men", Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.women)
        {
            intent.putExtra("category","Women's Clothing");
            Toast.makeText(this, "You clicked women", Toast.LENGTH_SHORT).show();

        }
        else{
            intent.putExtra("category","Kid's Clothing");
            Toast.makeText(this, "You clicked kids", Toast.LENGTH_SHORT).show();
        }
        startActivity(intent);
    }
}

