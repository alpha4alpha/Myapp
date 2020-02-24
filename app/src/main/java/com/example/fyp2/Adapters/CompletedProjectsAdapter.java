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

import com.example.fyp2.Models.CompletedProjects;
import com.example.fyp2.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompletedProjectsAdapter extends RecyclerView.Adapter<CompletedProjectsAdapter.MyViewHolder>
        implements Filterable {

    // widgets and variables

    private List<CompletedProjects> ClassCompletedProjects;
    private List<CompletedProjects> ClassCompletedProjectsFull;
    private Context mContext;

    public CompletedProjectsAdapter(Context mContext,
                                    List<CompletedProjects> ClassCompletedProjects) {
        this.ClassCompletedProjects = ClassCompletedProjects;
        ClassCompletedProjectsFull = new ArrayList<>(ClassCompletedProjects);
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
                .inflate(R.layout.completed_project_recycler_single_row, viewGroup, false);
        return new MyViewHolder(itemView);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        CompletedProjects CompletedProjects = ClassCompletedProjects.get(i);
        myViewHolder.ProjectName.setText(CompletedProjects.getProjectname());
        myViewHolder.ProjectDescription.setText(CompletedProjects.getProjectdescription());
        myViewHolder.ProjectRequirements.setText(CompletedProjects.getProjectrequirements());
        myViewHolder.ProjectBudget.setText(CompletedProjects.getProjectbudget());
        myViewHolder.ProjectCompletionDate.setText(CompletedProjects.getProjectcompletiondate());
        myViewHolder.ProjectUniversity.setText(CompletedProjects.getProjectuniversity());
        myViewHolder.ProjectStatus.setText(CompletedProjects.getProjectstatus());

    }

    @Override
    public int getItemCount() {
        return (null != ClassCompletedProjects ? ClassCompletedProjects.size() : 0);

    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<CompletedProjects> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ClassCompletedProjectsFull);
            } else {
                String filterPatern = constraint.toString().toLowerCase().trim();
                for (CompletedProjects name : ClassCompletedProjectsFull) {
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
            ClassCompletedProjects.clear();
            if (results != null) {
                ClassCompletedProjects.addAll((Collection<? extends CompletedProjects>) results.values);
                notifyDataSetChanged();
            }
        }
    };

    public void removeItem(int position) {
        ClassCompletedProjects.remove(position);
        notifyItemRemoved(position);
    }
}