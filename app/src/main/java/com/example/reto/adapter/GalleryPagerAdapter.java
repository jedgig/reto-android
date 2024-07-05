package com.example.reto.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.reto.fragments.ExteriorGalleryFragment;
import com.example.reto.fragments.InteriorGalleryFragment;

public class GalleryPagerAdapter extends FragmentStateAdapter {
    public GalleryPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new InteriorGalleryFragment();
            case 1:
                return new ExteriorGalleryFragment();
            default:
                return new InteriorGalleryFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Número de tabs
    }
}
