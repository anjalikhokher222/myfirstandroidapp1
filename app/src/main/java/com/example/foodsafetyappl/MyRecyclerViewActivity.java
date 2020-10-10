package com.example.foodsafetyappl;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewActivity extends AppCompatActivity{
    RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    ArrayList<uploadPDF> items=new ArrayList<uploadPDF>();



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_recycler_view);
         recyclerview=findViewById(R.id.recycler);

         DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("uploads");


           databaseReference.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   for (DataSnapshot postsnapshot : dataSnapshot.getChildren()) {
                       uploadPDF upload=postsnapshot.getValue(uploadPDF.class);
                       items.add(upload);

                   }
               }

               @Override
               public void onCancelled(@NonNull DatabaseError databaseError) {

               }
           });
        adapter=new myadapters(recyclerview,MyRecyclerViewActivity.this,items);
        recyclerview.setLayoutManager((new LinearLayoutManager((MyRecyclerViewActivity.this))));
        recyclerview.setAdapter(adapter);

    }

}
