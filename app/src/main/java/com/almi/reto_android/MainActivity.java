package com.almi.reto_android;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.almi.reto_android.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private ActivityMainBinding binding;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.coursesNav, R.id.navigation_dashboard, R.id.galleryNav)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng almi = new LatLng(43.2814487, -2.947576);
        mMap.addMarker(new MarkerOptions().position(almi).title("Almi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(almi));
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        mMap.clear();
        LatLng almi = new LatLng(latLng.latitude, latLng.longitude);
        mMap.addMarker(new MarkerOptions().position(almi).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(almi));
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        mMap.clear();
        LatLng almi = new LatLng(latLng.latitude, latLng.longitude);
        mMap.addMarker(new MarkerOptions().position(almi).title(""));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(almi));
    }
}
