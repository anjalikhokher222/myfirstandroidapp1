package com.example.foodsafetyappl;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

 Context mContext;
 List<products> mData;

   public RecyclerViewAdapter(Context mcontext, List<products>  mdata){
       this.mContext=mcontext;
       this.mData=mdata;
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View view;

        /* INFLATE THE LAYOUT// */
        LayoutInflater mInflater=LayoutInflater.from(mContext);
        view=mInflater.inflate(R.layout.cardview_item_book,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( final MyViewHolder holder, final int position) {
        holder.tv_book_title.setText(mData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource((mData.get(position).getThumbnail()));
        holder.cardView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                        Intent intent = new Intent(mContext, products_activity.class);
                        //passing data to products activity
                        intent.putExtra("Titlee", mData.get(position).getTitlee());
                        intent.putExtra("Thumbnaill", mData.get(position).getThumbnaill());
                    intent.putExtra("Category", mData.get(position).getCategory());
                        mContext.startActivity(intent);
                    }







            });


        }


    @Override
    public int getItemCount() {

        return mData.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;
         RecyclerView myrv;


        public MyViewHolder(View itemView){
            super(itemView);
            tv_book_title=(TextView) itemView.findViewById(R.id.textview);
            img_book_thumbnail=(ImageView) itemView.findViewById(R.id.imageView);
            cardView=(CardView) itemView.findViewById(R.id.cardview_id);
            RecyclerView myrv = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }
}







