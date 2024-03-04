package com.example.androidfinalproject.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidfinalproject.R;
import com.example.androidfinalproject.ui.Pojo.Budget;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private Context context;

    private final ArrayList<Budget> budgets;

    public CustomAdapter(ArrayList<Budget> budgets, Context context) {
        this.budgets = budgets;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_recycler_view, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    //TODO: add code here for the recyclerView layout
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Budget budget = budgets.get(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
