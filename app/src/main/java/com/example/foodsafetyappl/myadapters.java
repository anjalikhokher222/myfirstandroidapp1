package com.example.foodsafetyappl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapters extends RecyclerView.Adapter<myadapters.ViewHolder> {

    RecyclerView recyclerView;
    Context context;
    ArrayList<uploadPDF>items=new ArrayList<>();




    public myadapters(RecyclerView recyclerView,Context context,ArrayList<uploadPDF> items){
        this.recyclerView=recyclerView;
        this.context=context;
        this.items=items;

    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

        @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        uploadPDF upload=items.get(position);
holder.nameOfFile.setText(upload.getName());




    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView nameOfFile;

        public  ViewHolder(View itemView){
            super(itemView);
            nameOfFile=itemView.findViewById(R.id.nameOfFile);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position=recyclerView.getChildLayoutPosition(view);
                    Intent intent=new Intent();
                    intent.setType(Intent.ACTION_VIEW);

                    context.startActivity(intent);

                }
            });

        }

    }
}
