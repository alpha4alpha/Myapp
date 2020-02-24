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
import com.example.fyp2.Models.University;
import com.example.fyp2.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.MyViewHolder>
        implements Filterable {

    // widgets and variables

    private List<University> ClassUniversity;
    private List<University> ClassUniversityFull;
    private Context mContext;

    public UniversityAdapter(Context mContext,
                                  List<University> ClassUniversity) {
        this.ClassUniversity = ClassUniversity;
        ClassUniversityFull = new ArrayList<>(ClassUniversity);
        this.mContext = mContext;

    }

    // class used to get data and set to list
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView UniversityName,UniversityVision,UniversityAddress,UniversityContact,UniversityUrl
        ,UniversityExpertise,UniversityReviews;
        RatingBar UniversityRating;
        ImageView UniversityImage;



        MyViewHolder(View view) {
            super(view);
            UniversityName = view.findViewById(R.id.UniversityName);
            UniversityVision = view.findViewById(R.id.UniversityVision);
            UniversityAddress = view.findViewById(R.id.UniversityAddress);
            UniversityContact = view.findViewById(R.id.UniversityContact);
            UniversityUrl = view.findViewById(R.id.UniversityURL);
            UniversityExpertise = view.findViewById(R.id.UniversityExpertise);
            UniversityRating = view.findViewById(R.id.simpleRatingBar);
            UniversityReviews = view.findViewById(R.id.UniversityReviews);
            UniversityImage = view.findViewById(R.id.UniversityImage);

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

        University University = ClassUniversity.get(i);
        myViewHolder.UniversityName.setText(University.getUniversityname());
        myViewHolder.UniversityVision.setText(University.getUniversityvision());
        myViewHolder.UniversityAddress.setText(University.getUniversityaddress());
        myViewHolder.UniversityContact.setText(University.getUniversitycontact());
        myViewHolder.UniversityUrl.setText(University.getUniversityurl());
        myViewHolder.UniversityExpertise.setText(University.getUniversityexpertise());
        myViewHolder.UniversityRating.setRating(University.getUniversityrating());
        myViewHolder.UniversityReviews.setText(University.getUniversityreviews());
        Glide
                .with(Objects.requireNonNull(mContext))
                .load(University.getUniversityimage())
                .centerCrop()

                .placeholder(R.drawable.profile_pic_icon)
                .into(myViewHolder.UniversityImage);
    }

    @Override
    public int getItemCount() {
        return (null != ClassUniversity ? ClassUniversity.size() : 0);

    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<University> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ClassUniversityFull);
            } else {
                String filterPatern = constraint.toString().toLowerCase().trim();
                for (University name : ClassUniversityFull) {
                    if (name.getUniversityname().toLowerCase().contains(filterPatern)
                            || name.getUniversityaddress().toLowerCase().contains(filterPatern)) {
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
            ClassUniversity.clear();
            if (results != null) {
                ClassUniversity.addAll((Collection<? extends University>) results.values);
                notifyDataSetChanged();
            }
        }
    };

    public void removeItem(int position) {
        ClassUniversity.remove(position);
        notifyItemRemoved(position);
    }
}
