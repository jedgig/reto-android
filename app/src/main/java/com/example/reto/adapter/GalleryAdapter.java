package com.example.reto.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.reto.R;
import com.example.reto.data.AlmiImages;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class GalleryAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<AlmiImages> images;

    public GalleryAdapter(Context context, ArrayList<AlmiImages> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);



        Picasso
                .with(context)
                .load(images.get(position).getLink())
                .into(imageView);


        return convertView;
    }
}
