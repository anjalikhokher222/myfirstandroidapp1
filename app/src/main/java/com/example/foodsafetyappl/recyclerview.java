package com.example.foodsafetyappl;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;

import java.util.Collections;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;

public class  recyclerview extends AppCompatActivity  {
    List<products> firstProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        firstProduct = new ArrayList<>();
        firstProduct.add(new products(" MilkProducts", "1.Take 5 to 10 ml of sample with an equal amount of water.\n2.Shake the contents thoroughly.\n3.If milk is adulterated with detergent,it forms dense lather.\n4.Pure milk will form very thin foam layer due to agitation.\nDetection of water in milk\n\n" +
                "Testing method:\n" + "1.Put a drop of milk on a polished slanting surface.\n" + "2.Pure milk either stays or flows slowly leaving a white trail behind.\n" + "3.Milk adulterated with water will flow immediately without leaving a mark.\nDetection of starch in milk and milk products (khoya, chenna, paneer)\n\n" +
                "Testing method:\n" +
                "1.Boil 2-3 ml of sample with 5mI of water.\n" +
                "2.Cool and add 2-3 drops of tincture of iodine.\n" +
                "3.Formation of blue colour indicates the presence of starch.\n" +
                "(In the case of milk, addition of water and boiling is not required)\n\nSource:FSSAI", "Description products", R.drawable.milk,R.drawable.detergent,"Detection of detergent in milk"));

        firstProduct.add(new products("Vegetables", "1.Take little amount of green peas in a transparent glass.\n2.Add water to it and mix well.\n3.Let it stand for half an hour.\n4.Clear separation of color in water indicates adulteration.\n\n\n\n\n\n\nSource:FSSAI", "Description products", R.drawable.vegetables,R.drawable.matartest,"Detection of artificial colour on green peas"));
        firstProduct.add(new products("SugarProducts", "Method -1\n1.Take a transparent glass of water.\n2.Add a drop to the glass.\n3.Pure honey will not disperse in water,it indicates the presence of added sugar.\nMethod -2\n1.Take a cotton wick dipped in a pure honey and light with a match stick.\n2.Pure honey will burn.\n3.If adulterated,the presence of water will not allow the honey to burn if it does;it will produce a cracking sound.\n\n\n\n\n\n\nSource:FSSAI", "Description products", R.drawable.sugar,R.drawable.sugartest,"Detection of sugar solution in honey"));

        firstProduct.add(new products("Salts", "Stir a spoonful of sample of salt in a glass of water.\n2.The presence of chalk will make solution white and other insoluble impurities will settle down.\n\n\n\n\n\n\nSource:FSSAI", "Description products", R.drawable.salts,R.drawable.potatotest,"Detection of chalk in common salt"));
        firstProduct.add(new products("Oils", "1.Take coconut oil in a transparent glass.\n2.Place this glass in refrigerator for 30 minutes.(Do not keep in the freezer)\n3.After refrigeration,coconut oil solidifies.\nIf coconut oil is adulterated,then other oils remain as a separate layer.\n\n\n\n\n\n\nSource:FSSAI", "Description products", R.drawable.oils,R.drawable.coconutoil,"Detection of other oils in coconutoil"));

        firstProduct.add(new products("Foodgrains", "1.Take small quantity of sample in a glass plate.\n2.Examine the impurities visually.\n3.Pure food grains will not have any such impurities.\n4.Impurities are observed visually in adulterated food grains.\n\n\n\n\n\n\nSource:FSSAI", "Description products", R.drawable.foodgrains,R.drawable.foodgraintest,"Detection of extraneous matter(dust,pebble,stone,straw,weed seeds,damaged grain,weeviled grain,insects,rodent hair and excreta)in food grains"));

        firstProduct.add(new products("Spices", "1.Add a teaspoon of turmeric powder in a glass of water.\n2.Natural turmeric powder leaves light yellow colour while settling down.\n3.Adulterated turmeric powder will leave a strong yellow colour in water while settling down.\n\n\n\n\n\n\nSource:FSSAI", "Description products", R.drawable.spices,R.drawable.spicesturmerictest,"Detection of artificial colour in  turmeric powder"));
        firstProduct.add(new products("Tea", "1.Take a filter paper and spread few tea leaves.\n2.Sprinkle with water to wet the filter paper.\n3.Wash the filter paper under tap water and observe the stains against light.\n4.Pure tea leaves will not stain the filter paper.\n5.If coal tar is present,it will immediately stain the filter paper.\n\n\n\n\n\n\nSource:FSSAI", "Description products", R.drawable.tea,R.drawable.teatest,"Detection of exhausted tea in tea leaves"));
        firstProduct.add(new products("Beverages", "1.Add 1/2 teaspoon of coffee powder in a transparent glass of water.\n2.Stir for a minute and keep it aside for 5 minutes.Observe the glass at the bottom.\n3.Pure coffee will not leave any clay particles at the bottom.\n4.If coffee powder is adulterated,clay particles will settle at the bottom.\n\n\n\n\n\n\nSource:FSSAI", "Description products", R.drawable.beverages,R.drawable.beveragestest,"Detection of clay in coffee powder"));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerView);
        myrv.setHasFixedSize(true);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, firstProduct);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myAdapter);


    }

}
