package com.example.tugas_uas_10118336_if8.maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.tugas_uas_10118336_if8.R;

public class MapsWisata4Activity extends FragmentActivity implements OnMapReadyCallback {
    // 12 Agustus 2021 - 10118369 - Josep Victor Rajadoli - IF 9

    private GoogleMap mMap;
    TextView tvDetailNamaWisata4, tvDetailBiayaMasukWisata4, tvDetailAlamatTempatWisata4;
    ImageView ivDetailMaps4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_wisata4);

        tvDetailNamaWisata4 = findViewById(R.id.tvDetailNamaWisata4);
        tvDetailNamaWisata4.setText(getIntent().getStringExtra("nama_tempat"));

        tvDetailBiayaMasukWisata4 = findViewById(R.id.tvDetailBiayaMasukWisata4);
        tvDetailBiayaMasukWisata4.setText("Biaya Masuk : " + getIntent().getStringExtra("biaya_masuk"));

        tvDetailAlamatTempatWisata4 = findViewById(R.id.tvDetailAlamatTempatWisata4);
        tvDetailAlamatTempatWisata4.setText("Alamat : " + getIntent().getStringExtra("alamat_tempat"));

        ivDetailMaps4 = findViewById(R.id.ivDetailMaps4);
        Glide.with(this)
                .load(getIntent().getStringExtra("gambar_tempat"))
                .into(ivDetailMaps4);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        Double longitude = getIntent().getDoubleExtra("longitude", 0.0);

        // Add a marker in Sydney and move the camera
        LatLng wisata4 = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(wisata4).title(getIntent().getStringExtra("nama_tempat").toString()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wisata4));
    }
}