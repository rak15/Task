package com.example.rakesh.task;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rakesh on 07-07-2017.
 */

public class MyAdapter extends PagerAdapter {       //for image slider
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Integer> images;
    private ArrayList<String> head,desc;
    public MyAdapter(Context context,ArrayList<Integer> images,ArrayList<String> head,ArrayList<String> desc){
        this.context=context;
        this.images=images;
        this.head=head;
        this.desc=desc;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.slide, view, false);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.image);
        myImage.setImageResource(images.get(position));
        ImageView play=(ImageView)myImageLayout.findViewById(R.id.play_icon);
        play.setImageResource(R.drawable.play);
        TextView tv1=(TextView)myImageLayout.findViewById(R.id.header);
        tv1.setText(head.get(position));
        TextView tv2=(TextView)myImageLayout.findViewById(R.id.des);
        tv2.setText(desc.get(position));
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }
}
