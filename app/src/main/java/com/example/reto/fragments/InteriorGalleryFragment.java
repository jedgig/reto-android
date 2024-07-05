package com.example.reto.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.reto.R;
import com.example.reto.adapter.GalleryAdapter;
import com.example.reto.data.AlmiImages;

import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class InteriorGalleryFragment extends Fragment {
    private GridView gridView;
    private ArrayList<AlmiImages> images;
    private GalleryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interior_gallery, container, false);

        gridView = view.findViewById(R.id.gvGallery);
        images = new ArrayList<>();
        adapter = new GalleryAdapter(getContext(), images);
        gridView.setAdapter(adapter);

        fetchImages();

        return view;
    }

    private void fetchImages() {
        String url = "http://44.212.134.185:8000/ws/photos"; // Reemplaza con la URL de tu API

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject imageObject = response.getJSONObject(i);
                                String link = imageObject.getString("link");
                                images.add(new AlmiImages(link));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        requestQueue.add(jsonArrayRequest);
    }
}
