package com.example.reto.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.reto.R;
import com.example.reto.adapter.GalleryAdapter;
import com.example.reto.data.AlmiImages;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ExteriorGalleryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exterior_galley, container, false);

        GridView gridView = view.findViewById(R.id.gvGallery);
        ArrayList<AlmiImages> images = new ArrayList<>();
        images.add(new AlmiImages("https://cdn.jedg.tech/Almi1.webp"));
        images.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/08-Aula-de-ordenadores-1024x576.jpg"));
        images.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/09-Clase-en-Almi-1024x576.jpg"));
        images.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/12-Comienzo-del-curso-1024x576.jpg"));
        images.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/11Trabajos-en-grupo-1024x576.jpg"));
        images.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/13-Charla-sobre-la-discapacidad-en-las-instalaciones-de-Almi-1024x576.jpg"));

        GalleryAdapter adapter = new GalleryAdapter(getContext(), images);
        gridView.setAdapter(adapter);

        return view;
    }
}
