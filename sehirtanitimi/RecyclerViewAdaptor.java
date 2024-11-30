package com.example.sehirtanitimi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sehirtanitimi.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.SehirHolder> {

    ArrayList<Sehirsimgeleri> sehirsimgeleriArrayList;

    public RecyclerViewAdaptor(ArrayList<Sehirsimgeleri> sehirsimgeleriArrayList) {
        this.sehirsimgeleriArrayList = sehirsimgeleriArrayList;
    }

    @NonNull
    @Override
    public SehirHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new SehirHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SehirHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.binding.recyclerViewTextView.setText(sehirsimgeleriArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),Detaylar.class);
                intent.putExtra("sehirsimgeleri",sehirsimgeleriArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sehirsimgeleriArrayList.size();
    }

    public class SehirHolder extends RecyclerView.ViewHolder{


       private RecyclerRowBinding binding;

        public SehirHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
