package com.example.fyp2.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyp2.Models.Milestones;
import com.example.fyp2.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MilestonesAdapter extends RecyclerView.Adapter<MilestonesAdapter.MyViewHolder>
        implements Filterable {

    // widgets and variables

    private List<Milestones> ClassMilestones;
    private List<Milestones> ClassMilestonesFull;
    private Context mContext;

    public MilestonesAdapter(Context mContext,
                                    List<Milestones> ClassMilestones) {
        this.ClassMilestones = ClassMilestones;
        ClassMilestonesFull = new ArrayList<>(ClassMilestones);
        this.mContext = mContext;

    }

    // class used to get data and set to list
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView MilestoneName, MilestoneDescription,MilestoneTime, MileStoneStatus;


        MyViewHolder(View view) {
            super(view);
            MilestoneName = view.findViewById(R.id.MileStoneName);
            MilestoneDescription = view.findViewById(R.id.MileStoneDescription);
            MilestoneTime = view.findViewById(R.id.MileStoneTime);
            MileStoneStatus = view.findViewById(R.id.MileStoneStatus);

        }

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.milestones_recycler_single_row, viewGroup, false);
        return new MyViewHolder(itemView);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Milestones Milestones = ClassMilestones.get(i);
        myViewHolder.MilestoneName.setText(Milestones.getMilestonename());
        myViewHolder.MilestoneDescription.setText(Milestones.getMilestonedescription());
        myViewHolder.MilestoneTime.setText(Milestones.getMilestonetime());
        myViewHolder.MileStoneStatus.setText(Milestones.getMilestonestatus());

    }

    @Override
    public int getItemCount() {
        return (null != ClassMilestones ? ClassMilestones.size() : 0);

    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Milestones> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ClassMilestonesFull);
            } else {
                String filterPatern = constraint.toString().toLowerCase().trim();
                for (Milestones name : ClassMilestonesFull) {
                    if (name.getMilestonename().toLowerCase().contains(filterPatern)
                            || name.getMilestonedescription().toLowerCase().contains(filterPatern)) {
                        filteredList.add(name);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ClassMilestones.clear();
            if (results != null) {
                ClassMilestones.addAll((Collection<? extends Milestones>) results.values);
                notifyDataSetChanged();
            }
        }
    };

    public void removeItem(int position) {
        ClassMilestones.remove(position);
        notifyItemRemoved(position);
    }
}
