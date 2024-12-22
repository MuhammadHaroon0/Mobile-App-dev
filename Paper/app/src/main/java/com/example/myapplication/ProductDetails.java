package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ProductDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        Intent intent=getIntent();
        String category=intent.getStringExtra("category");
        TextView showCat=findViewById(R.id.selectedCat);
        showCat.setText(category);
        ArrayList<Product>men=new ArrayList<>();
        men.add(new Product(23.4,"Pant",R.drawable.img));
        men.add(new Product(23.4,"Pant",R.drawable.img));
        men.add(new Product(23.4,"Pant",R.drawable.img));
        men.add(new Product(23.4,"Pant",R.drawable.img));
        men.add(new Product(23.4,"Pant",R.drawable.img));
        men.add(new Product(23.4,"Pant",R.drawable.img));


        ArrayList<Product>women=new ArrayList<>();
        women.add(new Product(23.4,"Pant",R.drawable.img,false));
        women.add(new Product(23.4,"Pant",R.drawable.img,false));
        women.add(new Product(23.4,"Pant",R.drawable.img,false));
        women.add(new Product(23.4,"Pant",R.drawable.img,false));
        women.add(new Product(23.4,"Pant",R.drawable.img,false));
        women.add(new Product(23.4,"Pant",R.drawable.img,false));

        ArrayList<Product>kids=new ArrayList<>();
        kids.add(new Product(23.4,"Pant",R.drawable.img,false));
        kids.add(new Product(23.4,"Pant",R.drawable.img,false));
        kids.add(new Product(23.4,"Pant",R.drawable.img,false));
        kids.add(new Product(23.4,"Pant",R.drawable.img,false));
        kids.add(new Product(23.4,"Pant",R.drawable.img,false));
        kids.add(new Product(23.4,"Pant",R.drawable.img,false));


        if(category.equals("Men's Clothing"))
        {
            showContent(men);
        }
        else if (category.equals("Women's Clothing")) {
            showContent(women);

        }
        else {
            showContent(kids);
        }

    }
    private void showContent(ArrayList<Product>data)
    {
        Adapter adapter=new Adapter(ProductDetails.this,data);
        ListView listView=findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(ProductDetails.this, SingleProduct.class);
                intent.putExtra("pname",(String)data.get(position).name);
                intent.putExtra("pprice",String.valueOf((double)data.get(position).price));
                intent.putExtra("pavail",(boolean)data.get(position).stock);
                intent.putExtra("pimage",(int)data.get(position).imageUrl);
                Toast.makeText(ProductDetails.this, "You clicked", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}

class Product{
    double price;
    String name;
    int imageUrl;
    boolean stock;
    Product(double price,String name,int imageUrl,boolean stock)
    {
        this.price=price;
        this.name=name;
        this.imageUrl=imageUrl;
        this.stock=stock;
    }
    Product(double price,String name,int imageUrl)
    {
        this.price=price;
        this.name=name;
        this.imageUrl=imageUrl;
        this.stock=true;
    }
}