package com.example.recyclerviewtest2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tv1, tv2, tv3, tv4, tv5, tv6;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        tv1 = itemView.findViewById(R.id.text1);
        tv2 = itemView.findViewById(R.id.text2);
        tv3 = itemView.findViewById(R.id.text3);
        tv4 = itemView.findViewById(R.id.text4);
        tv5 = itemView.findViewById(R.id.text5);
        tv6 = itemView.findViewById(R.id.text6);
    }

}
