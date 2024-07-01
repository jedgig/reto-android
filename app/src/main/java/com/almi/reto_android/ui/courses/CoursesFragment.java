package com.almi.reto_android.ui.courses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.almi.reto_android.adapter.CoursesAdapter;
import com.almi.reto_android.data.Courses;
import com.almi.reto_android.databinding.FragmentCoursesBinding;

import java.util.ArrayList;

public class CoursesFragment extends Fragment {

    private FragmentCoursesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CoursesViewModel homeViewModel =
                new ViewModelProvider(this).get(CoursesViewModel.class);

        binding = FragmentCoursesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView coursesListView = binding.lvAlmiCourse;


        ArrayList<Courses> coursesArrayList = new ArrayList<>();
        coursesArrayList.add(new Courses("Day", "SMR1", 990));
        coursesArrayList.add(new Courses("Day", "SMR2", 20));
        coursesArrayList.add(new Courses("Day", "ASIR1", 30));
        coursesArrayList.add(new Courses("Day", "ASIR2", 10));
        coursesArrayList.add(new Courses("Day", "DAM1", 20));
        coursesArrayList.add(new Courses("Day", "DAM2", 30));
        coursesArrayList.add(new Courses("Day", "AF1", 10));
        coursesArrayList.add(new Courses("Day", "AF2", 20));
        coursesArrayList.add(new Courses("Day", "FPB1", 30));
        coursesArrayList.add(new Courses("Day", "FPB2", 10));
        coursesArrayList.add(new Courses("Evening", "Cae1", 20));
        coursesArrayList.add(new Courses("Evening", "Cae2", 30));


        CoursesAdapter adapter = new CoursesAdapter(getContext(), coursesArrayList);
        coursesListView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}