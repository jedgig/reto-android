package com.example.reto.ui.courses;

import static com.example.reto.MainActivity.courseList;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto.MainActivity;
import com.example.reto.adapter.CoursesAdapter;
import com.example.reto.data.Courses;
import com.example.reto.databinding.ActivityMainBinding;
import com.example.reto.databinding.FragmentCoursesBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CoursesFragment extends Fragment {
    private FragmentCoursesBinding binding;
    private CoursesAdapter adapter;
    private ArrayList<Courses> coursesArrayList;
    private String host_ip = "44.212.134.185:8000";
    String consultacursos = "http://" + host_ip + "/ws/almi";

    private Context context;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CoursesViewModel homeViewModel = new ViewModelProvider(this).get(CoursesViewModel.class);
        binding = FragmentCoursesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView coursesListView = binding.lvAlmiCourse;

        coursesArrayList = new ArrayList<>();
        adapter = new CoursesAdapter(getContext(), coursesArrayList);
        coursesListView.setAdapter(adapter);
        ApiData();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void ApiData() {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, consultacursos,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("ApiData Response", response);
                        try {
                            JSONArray jsonResponse = new JSONArray(response);
                            coursesArrayList.clear();
                            for (int i = 0; i < jsonResponse.length(); i++) {
                                JSONObject courseObject = jsonResponse.getJSONObject(i);
                                String modality = courseObject.getString("Modality");
                                String course = courseObject.getString("Course");
                                int hours = courseObject.getInt("Hours");
                                Courses newCourse = new Courses(modality, course, hours);
                                coursesArrayList.add(newCourse);
                            }
                            adapter.setCoursesList(coursesArrayList);
                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("ApiData Error", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ApiData Error", error.toString());
            }
        });

        queue.add(stringRequest);
    }

}
