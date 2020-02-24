package com.example.fyp2.Adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fyp2.Models.UniversityMain;
import com.example.fyp2.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UniversityMainAdapter extends RecyclerView.Adapter<UniversityMainAdapter.MyViewHolder>
        implements Filterable {

    // widgets and variables

    private List<UniversityMain> ClassUniversityMain;
    private List<UniversityMain> ClassUniversityMainFull;
    private Context mContext;

    public UniversityMainAdapter(Context mContext,
                             List<UniversityMain> ClassUniversityMain) {
        this.ClassUniversityMain = ClassUniversityMain;
        ClassUniversityMainFull = new ArrayList<>(ClassUniversityMain);
        this.mContext = mContext;

    }

    // class used to get data and set to list
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView UniversityMainName,UniversityMainVision,UniversityMainAddress,UniversityMainContact,UniversityMainUrl
                ,UniversityMainExpertise,UniversityMainReviews;
        RatingBar UniversityMainRating;
        ImageView UniversityImage;



        MyViewHolder(View view) {
            super(view);
            UniversityMainName = view.findViewById(R.id.UniversityMainName);
            UniversityMainRating = view.findViewById(R.id.simpleRatingBarMain);
            UniversityImage = view.findViewById(R.id.UniversityMainImage);

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

        UniversityMain UniversityMain = ClassUniversityMain.get(i);
        myViewHolder.UniversityMainName.setText(UniversityMain.getUniversityname());
        myViewHolder.UniversityMainRating.setRating(UniversityMain.getUniversityrating());
        Glide
                .with(Objects.requireNonNull(mContext))
                .load(UniversityMain.getUniversityimage())
                .centerCrop()

                .placeholder(R.drawable.profile_pic_icon)
                .into(myViewHolder.UniversityImage);
    }

    @Override
    public int getItemCount() {
        return (null != ClassUniversityMain ? ClassUniversityMain.size() : 0);

    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<UniversityMain> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ClassUniversityMainFull);
            } else {
                String filterPatern = constraint.toString().toLowerCase().trim();
                for (UniversityMain name : ClassUniversityMainFull) {
                    if (name.getUniversityname().toLowerCase().contains(filterPatern)) {
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
            ClassUniversityMain.clear();
            if (results != null) {
                ClassUniversityMain.addAll((Collection<? extends UniversityMain>) results.values);
                notifyDataSetChanged();
            }
        }
    };

    public void removeItem(int position) {
        ClassUniversityMain.remove(position);
        notifyItemRemoved(position);
    }
}

