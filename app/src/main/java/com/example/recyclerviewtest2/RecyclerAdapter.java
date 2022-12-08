package com.example.recyclerviewtest2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {


    ArrayList<List<String>> list;

    public RecyclerAdapter(ArrayList<List<String>> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.tv1.setText(list.get(position).toString());


        for (int j = 0; j < list.get(position).size(); j++) {
                switch (j) {
                    case 0:
                        holder.tv1.setText(list.get(position).get(j));
                        break;
                    case 1:
                        holder.tv2.setText(list.get(position).get(j));
                        break;
                    case 2:
                        holder.tv3.setText(list.get(position).get(j));
                        break;
                    case 3:
                        holder.tv4.setText(list.get(position).get(j));
                        break;
                    case 4:
                        holder.tv5.setText(list.get(position).get(j));
                        break;
                    case 5:
                        holder.tv6.setText(list.get(position).get(j));
                        break;
                }
            }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
