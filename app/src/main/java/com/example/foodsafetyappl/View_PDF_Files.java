package com.example.foodsafetyappl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.foodsafetyappl.R.*;


public class View_PDF_Files extends AppCompatActivity {
ListView myPDFListView;
DatabaseReference databaseReference;
List<uploadPDF> uploadPDFS;
String[] festivals={"diwali","holi","christmas","eid","baisakhi","halloween"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_view__pdf__files);
        myPDFListView=(ListView)findViewById(id.myListView);
       TextView textView=(TextView)findViewById(id.text1);
uploadPDFS=new ArrayList<>();

viewAllFiles();
             }
             private  void viewAllFiles(){
        databaseReference=FirebaseDatabase.getInstance().getReference("uploads/");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postsnapshot : dataSnapshot.getChildren()) {

                    uploadPDF uploadPDF = postsnapshot.getValue(com.example.foodsafetyappl.uploadPDF.class);
                    uploadPDFS.add(uploadPDF);
                }
                String[] uploads = new String[uploadPDFS.size()];
                for (int i = 0; i < uploads.length; i++) {
                    uploads[i]=uploadPDFS.get(i).getName();

                }

            final     ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_activated_1,android.R.id.text1,uploads);
                myPDFListView.setAdapter(adapter);
                myPDFListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                       uploadPDF uploadPDF=uploadPDFS.get(position);
                       Intent intent=new Intent();
                       intent.setData(Uri.parse(uploadPDF.getUrl()));
                       startActivity(intent);
                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
             }








}
