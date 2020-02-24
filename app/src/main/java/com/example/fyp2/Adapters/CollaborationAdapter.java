package com.example.fyp2.Adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyp2.Models.Collaboration;
import com.example.fyp2.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class CollaborationAdapter extends RecyclerView.Adapter<CollaborationAdapter.MyViewHolder>
        implements Filterable {

    // widgets and variables

    private List<Collaboration> ClassCollaboration;
    private List<Collaboration> ClassCollaborationFull;
    private Context mContext;

    public CollaborationAdapter(Context mContext,
                                  List<Collaboration> ClassCollaboration) {
        this.ClassCollaboration = ClassCollaboration;
        ClassCollaborationFull = new ArrayList<>(ClassCollaboration);
        this.mContext = mContext;

    }

    // class used to get data and set to list
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView UniversityName,ProjectName;


        MyViewHolder(View view) {
            super(view);
            UniversityName = view.findViewById(R.id.UniversityName);
            ProjectName = view.findViewById(R.id.ProjectName);



        }

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.collaboration_recycler_single_row, viewGroup, false);
        return new MyViewHolder(itemView);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Collaboration Collaboration = ClassCollaboration.get(i);
        myViewHolder.UniversityName.setText(Collaboration.getUniversityname());
        myViewHolder.ProjectName.setText(Collaboration.getProjectname());

    }

    @Override
    public int getItemCount() {
        return (null != ClassCollaboration ? ClassCollaboration.size() : 0);

    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Collaboration> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ClassCollaborationFull);
            } else {
                String filterPatern = constraint.toString().toLowerCase().trim();
                for (Collaboration name : ClassCollaborationFull) {
                    if (name.getProjectname().toLowerCase().contains(filterPatern)
                            || name.getUniversityname().toLowerCase().contains(filterPatern)) {
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
            ClassCollaboration.clear();
            if (results != null) {
                ClassCollaboration.addAll((Collection<? extends Collaboration>) results.values);
                notifyDataSetChanged();
            }
        }
    };

    public void removeItem(int position) {
        ClassCollaboration.remove(position);
        notifyItemRemoved(position);
    }
}
