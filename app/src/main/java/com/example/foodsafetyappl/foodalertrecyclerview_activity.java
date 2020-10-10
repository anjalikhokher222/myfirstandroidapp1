package com.example.foodsafetyappl;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;

import java.util.Collections;

import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.M;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class foodalertrecyclerview_activity extends AppCompatActivity {
    List<products> firstProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodalertrecyclerview_activity);


firstProduct = new ArrayList<>();
        firstProduct.add(new products(" Government doctors to be trained in detecting adulterated food | Coimbatore News-Times of India", "COIMBATORE : The food safety department is all set to train government doctors in detecting food adulteration with a rapid test using easily available items. The move comes close on the heels of health minister Dr. C Vijayabaskar's recent announcement in the assembly that every primary health centre would be trained in detecting adulterated food products by the way of DART(DETECTION OF ADULTERATION USING RAPID TESTS). \n Now the food safety department will conduct a training programme for around 50 doctors on rapid tests available for food items such as milk, ghee oil, spices, sugar, and fruits at the public health office here on Thursday. \n \t Designated food safety officer K Tamilselvan said there were many simple methods to detect water adulteration in milk. Just put two small drops of milk on a polished slanting surface. If it is unadulterated milk, the droplet will be thick and flow down the surface very slowly. if it has water, it will flow down fast and when it falls won't retain the color of the milk. ", "Description products", R.drawable.doctor,R.drawable.doctor,"Detection of detergent in milk"));
        firstProduct.add(new products("Pune cops seize adulterated butter from shops near Sarasbaug |Pune News-Times of India", "PUNE : The Pune crime branch  on tuesday evening raided a shop located at Mtra Mandal Chowk near Sarasbaug and seized adulterated butter from the shop. \t \t Police received a tip off about the adulteration racket and  subsequently information was passed on to the Food and drug authority officials from the both the departments from a team and raided the shop. \t \t A team comprising of assistant inspector Ganesh Pawar and Constable Ganesh Salunkhe, Sunil Pawar, Rakesh khunave seized the 1410 Kg of Butter worth rupees 2.53 lakhs." , "Description products", R.drawable.police,R.drawable.police,"Testing adulterants in mater"));
        firstProduct.add(new products("40% of food samples in Noida fail quality test", "NOIDA : Nearly 40% of the food samples tested in the Gautam Budh Nagar over the past two years have been found unfit for the consumption reveals data of the UP food safety and drug administration. \t \t Out of 1,032 samples, 407 samples have failed the quality test so far. However as the results of 302 samples are still awaited, alarmed officials fear the final figure could be worse. most of the sub-standard samples were milk products,followed by fake spices in second spot.", "Description products", R.drawable.paneer,R.drawable.paneer,"Testing impurities in sugar"));
        firstProduct.add(new products("Campaign against food adulteration begins in Rajasthan", "JAIPUR : Ahead of diwali, health department has launched a campaign against food adulteration in the state which will continue October 31. \t The health Department's food safety officers have been directed to collect samples of ghee, edible oil, mawa, paneer, sweets with artificial and synthetic color and other products made of Milk, dry fruits, spices, ice creams, toffees and chocolates. There are always a higher risk of influx of adulterated food items in the markets during festive season. \t At a time when the demand increases for such products, the miscreants use it as an opportunity to make money through adulteration, said a letter issued by state food commissioner to all the chief medical health officers of the state.", "Description products", R.drawable.rajasthanifood,R.drawable.rajasthanifood,"Testing impurities in sugar"));
        firstProduct.add(new products("Rajasthan tops in food adulteration cases", "JAIPUR : Rajasthan tops cases registered under the Food Adulteration Act. While majority of the states and union territories have no such cases, the desert state has 14. The handful of states which have such cases are also not in double digits. \t\t In Rajasthan 14 cases were registered under the Prevention Of Adulteration Act, 1954 out of the total of 23 cases registered across the country, No other state even came closer to give a competition to the state in this category. Telangana ranked no.2 with just three cases of food adulteration. Although the figure is not high, it becomes relevant when other states and union territories have no such cases. \t\t The state was also in the top 5 with 261 cases registered under the Essential Commodities Act, 2006. Rajasthan was again in the top-5 in the total number of cases under the food, drugs and essential commodities acts with 275 cases.  ", "Description products", R.drawable.adulterationcases,R.drawable.adulterationcases,"Testing impurities in sugar"));
        firstProduct.add(new products("Food Safety and Standard Authority of India to set permissible limits for formaldehyde in fish by August", " PANAJI : The Food Safety and Standards Authority of India is expected to complete the process of setting standards for naturally occurring formaldehyde in fish by august this year. \t\t The authority's scientific panel on fish and and fisheries products has initiated a collaborative research project called Natural level of formaldehyde in freshly harvested fin fish and shell fish species with an estimated budget of Rs. 54 lakhs, following directions issued by the high court of bombay at goa last year. \t\t The exercise initiated on July 3 this year will cover 72 major commercial species of fish in different types of aquatic environment which represent around 90 percent of fish produced and consumed in India.  ", "Description products", R.drawable.ayush,R.drawable.ayush,"Testing impurities in sugar"));
        firstProduct.add(new products("25% of food samples from MP fail purity test ", "BHOPAL : Out of the 3,443 samples of food items sent for testing their purity from across the stste, 895 have been found substandard, 294 misbranded, 45 adulterated, 46 unsafe for consumption and 36 prohibited for sale. The reports were recently received  by the Food And Drug Administration (FDA). \t\t Over the last few months, food safety officials across Madhya Pradesh have been carrying out a drive against adulteration to ensure the sale of pure edibles in the market. The campaign, now christened Shudh Ke Liye Yudh by the FDA, was undertaken on july 19 after two factories manufacturing spurious milk and mawa were unearthed in the Chambal region. ", "Description products", R.drawable.bhopal,R.drawable.bhopal,"Testing impurities in sugar"));
        firstProduct.add(new products("13 sick from Salmonella in France linked to eating raw milk cheese", " Salmonella has affected 13 people in France with a link to cunsuming a brand of raw milk cheese. \t\t They have been infected with the same strain of Salmonella Dublin, according to the National Reference Center for Salmonella at the Institute Pasteur. \t\t Authorities advices the people that have the potentially affected products not to consume them and to take them back to the place of purchase.", "Description products", R.drawable.cheese,R.drawable.cheese,"Testing impurities in sugar"));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerVieww);
        myrv.setHasFixedSize(true);
        foodalertrecyclerviewadapter myAdapter = new foodalertrecyclerviewadapter(this, firstProduct);
        myrv.setLayoutManager(new LinearLayoutManager(this));

        myrv.setAdapter(myAdapter);


        }
        }

