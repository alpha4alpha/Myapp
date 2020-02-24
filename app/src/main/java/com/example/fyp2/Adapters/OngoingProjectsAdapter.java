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

import com.example.fyp2.Models.OngoingProjects;
import com.example.fyp2.Models.OngoingProjects;
import com.example.fyp2.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OngoingProjectsAdapter extends RecyclerView.Adapter<OngoingProjectsAdapter.MyViewHolder>
        implements Filterable {

    // widgets and variables

    private List<OngoingProjects> ClassOngoingProjects;
    private List<OngoingProjects> ClassOngoingProjectsFull;
    private Context mContext;

    public OngoingProjectsAdapter(Context mContext,
                                    List<OngoingProjects> ClassOngoingProjects) {
        this.ClassOngoingProjects = ClassOngoingProjects;
        ClassOngoingProjectsFull = new ArrayList<>(ClassOngoingProjects);
        this.mContext = mContext;

    }

    // class used to get data and set to list
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ProjectName, ProjectDescription, ProjectRequirements, ProjectBudget, ProjectCompletionDate,
                ProjectUniversity, ProjectStatus;


        MyViewHolder(View view) {
            super(view);
            ProjectName = view.findViewById(R.id.ProjectName);
            ProjectDescription = view.findViewById(R.id.ProjectDescription);
            ProjectRequirements = view.findViewById(R.id.ProjectRequirements);
            ProjectBudget = view.findViewById(R.id.ProjectBudget);
            ProjectCompletionDate = view.findViewById(R.id.ProjectCompletionDate);
            ProjectUniversity = view.findViewById(R.id.ProjectUniversity);
            ProjectStatus = view.findViewById(R.id.ProjectStatus);

        }

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ongoing_projects_recycler_single_row, viewGroup, false);
        return new MyViewHolder(itemView);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        OngoingProjects OngoingProjects = ClassOngoingProjects.get(i);
        myViewHolder.ProjectName.setText(OngoingProjects.getProjectname());
        myViewHolder.ProjectDescription.setText(OngoingProjects.getProjectdescription());
        myViewHolder.ProjectRequirements.setText(OngoingProjects.getProjectrequirements());
        myViewHolder.ProjectBudget.setText(OngoingProjects.getProjectbudget());
        myViewHolder.ProjectCompletionDate.setText(OngoingProjects.getProjectcompletiondate());
        myViewHolder.ProjectUniversity.setText(OngoingProjects.getProjectuniversity());
        myViewHolder.ProjectStatus.setText(OngoingProjects.getProjectstatus());

    }

    @Override
    public int getItemCount() {
        return (null != ClassOngoingProjects ? ClassOngoingProjects.size() : 0);

    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<OngoingProjects> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ClassOngoingProjectsFull);
            } else {
                String filterPatern = constraint.toString().toLowerCase().trim();
                for (OngoingProjects name : ClassOngoingProjectsFull) {
                    if (name.getProjectname().toLowerCase().contains(filterPatern)
                            || name.getProjectbudget().toLowerCase().contains(filterPatern)) {
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
            ClassOngoingProjects.clear();
            if (results != null) {
                ClassOngoingProjects.addAll((Collection<? extends OngoingProjects>) results.values);
                notifyDataSetChanged();
            }
        }
    };

    public void removeItem(int position) {
        ClassOngoingProjects.remove(position);
        notifyItemRemoved(position);
    }
}