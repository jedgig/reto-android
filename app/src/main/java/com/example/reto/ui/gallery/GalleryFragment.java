package com.example.reto.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.reto.R;
import com.example.reto.adapter.GalleryPagerAdapter;
import com.example.reto.databinding.FragmentGalleryBinding;
import com.example.reto.fragments.ExteriorGalleryFragment;
import com.example.reto.fragments.InteriorGalleryFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.Nullable;


public class GalleryFragment extends Fragment {
    private ViewPager2 vpGallery;
    private TabLayout tabLayout;
    private FragmentGalleryBinding binding;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery,container,false);

        vpGallery= root.findViewById(R.id.vpGallery);
        vpGallery.setAdapter(new GalleryPagerAdapter(requireActivity()));


        tabLayout = root.findViewById(R.id.tbGallery);


        new TabLayoutMediator(tabLayout, vpGallery,
                (tab, position) -> tab.setText("Item " + (position + 1))
        ).attach();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}