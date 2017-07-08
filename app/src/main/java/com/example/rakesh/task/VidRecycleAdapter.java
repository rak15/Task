package com.example.rakesh.task;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rakesh on 08-07-2017.
 */

public class VidRecycleAdapter extends RecyclerView.Adapter<VidRecycleAdapter.ViewHolder> {
    private String[] names,descriptions;
    private int[] imageIds;

    VidRecycleAdapter(String[] names,String[] descriptions,int[] imageIds){
        this.names=names;
        this.descriptions=descriptions;
        this.imageIds=imageIds;
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        ViewHolder(CardView v){
            super(v);
            cardView=v;
        }
    }
    @Override
    public VidRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        CardView cv=(CardView) inflater.inflate(R.layout.card,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(VidRecycleAdapter.ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.img);
        Drawable drawable = cardView.getResources().getDrawable(imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(names[position]);
        TextView textView = (TextView)cardView.findViewById(R.id.title);
        textView.setText(names[position]);
        TextView textView1=(TextView)cardView.findViewById(R.id.description);
        textView1.setText(descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
}
