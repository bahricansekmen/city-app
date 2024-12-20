package com.example.sehirtanitimi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.sehirtanitimi.databinding.ActivityDetaylarBinding;
import com.example.sehirtanitimi.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Sehirsimgeleri> sehirsimgeleriArrayList;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding =ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sehirsimgeleriArrayList = new  ArrayList<>();

        Sehirsimgeleri uludag = new Sehirsimgeleri("Uludağ","Bursa",R.drawable.uludag);
        Sehirsimgeleri ulucami = new Sehirsimgeleri("Ulucami","Bursa",R.drawable.ulucami);
        Sehirsimgeleri kapalicarsi = new Sehirsimgeleri("Kapalı Çarşı","Bursa",R.drawable.kapalicarsi);

        sehirsimgeleriArrayList.add(uludag);
        sehirsimgeleriArrayList.add(ulucami);
        sehirsimgeleriArrayList.add(kapalicarsi);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdaptor recyclerViewAdaptor = new RecyclerViewAdaptor(sehirsimgeleriArrayList);
        binding.recyclerView.setAdapter(recyclerViewAdaptor);

 
    }
}
