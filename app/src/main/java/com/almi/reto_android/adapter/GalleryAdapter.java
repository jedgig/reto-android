package com.almi.reto_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.almi.reto_android.R;
import com.almi.reto_android.data.AlmiImages;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<AlmiImages> images = new ArrayList();

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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return CustomView(position, convertView, parent);
    }

    private View CustomView(int position, View convertView, ViewGroup parent) {
        LayoutInflater charger= LayoutInflater.from(context);
        View lines=charger.inflate(R.layout.item_gallery_adapter, null);

        ImageView image= lines.findViewById(R.id.ivAlmiImage);
        //image.setImageResource(images.get(position).getImage());
        Picasso.with(this.context).load(images.get(position).getImage()).into(image);

        return lines;
    }
}
