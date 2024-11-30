package com.example.sehirtanitimi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sehirtanitimi.databinding.ActivityDetaylarBinding;

public class Detaylar extends AppCompatActivity {

    private ActivityDetaylarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityDetaylarBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        //Casting
        Sehirsimgeleri sehirsimgeleri = (Sehirsimgeleri) intent.getSerializableExtra("sehirsimgeleri");

        binding.Name.setText(sehirsimgeleri.name);
        binding.Country.setText(sehirsimgeleri.country);
        binding.imageView.setImageResource(sehirsimgeleri.image);

    }
}