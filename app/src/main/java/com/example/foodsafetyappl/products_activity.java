package com.example.foodsafetyappl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.ThumbnailUtils;
import android.nfc.Tag;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

public class products_activity extends AppCompatActivity {
    private TextView tvtitle;
    private ImageView img;
private  TextView tvCat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_activity);

Intent intent=getIntent();
                String Title=intent.getExtras().getString("Title");
                        String Titlee=intent.getExtras().getString("Titlee");
                int image=intent.getExtras().getInt("Thumbnail");
                        int imagee=intent.getExtras().getInt("Thumbnaill");
String Category=intent.getExtras().getString("Category");


                        tvCat=(TextView)findViewById(R.id.txtCat);
                        tvtitle=(TextView)findViewById(R.id.txttitle);
                        img=(ImageView) findViewById(R.id.bookthumbnail);
                             tvtitle.setText(Titlee);
                        img.setImageResource(imagee);
                        tvCat.setText(Category);



                    }
    }

