package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {

    private List<String> workoutList;

    public WorkAdapter(List<String> workoutList) {
        this.workoutList = workoutList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_workout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind your workout data here
        holder.workoutName.setText(workoutList.get(position));
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView workoutName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workoutName = itemView.findViewById(R.id.exercisetxt);
        }
    }
}
