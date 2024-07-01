package com.almi.reto_android.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.almi.reto_android.adapter.GalleryAdapter;
import com.almi.reto_android.data.AlmiImages;
import com.almi.reto_android.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel dashboardViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        GridView galleryGridView = binding.gvGallery;

        ArrayList<AlmiImages> imagesArrayList = new ArrayList<>();
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/01-Almi-1024x576.jpg"));
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/02-Entrada-Almi-1024x576.jpg"));
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/03-Entrada-Almi-1024x576.jpg"));
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/04-Entrada-Almi-1024x576.jpg"));
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/06-Aula-Ordenadores-1024x576.jpg"));
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/07-Aula-de-ordenadores-1024x576.jpg"));
        imagesArrayList.add(new AlmiImages("https://cdn.jedg.tech/Almi1.webp"));
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/08-Aula-de-ordenadores-1024x576.jpg"));
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/09-Clase-en-Almi-1024x576.jpg"));
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/12-Comienzo-del-curso-1024x576.jpg"));
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/11Trabajos-en-grupo-1024x576.jpg"));
        imagesArrayList.add(new AlmiImages("https://almi.eus/wp-content/uploads/2016/09/13-Charla-sobre-la-discapacidad-en-las-instalaciones-de-Almi-1024x576.jpg"));

        GalleryAdapter adapter = new GalleryAdapter(getContext(), imagesArrayList);
        galleryGridView.setAdapter(adapter);

        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}