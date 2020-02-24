package com.example.fyp2.fragments;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fyp2.Adapters.CompletedProjectsAdapter;
import com.example.fyp2.Models.CompletedProjects;
import com.example.fyp2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompletedProjectsFragment extends Fragment {

    private CompletedProjectsAdapter completedProjectsAdapter;
    private List<CompletedProjects> completedProjectsList;

    private RecyclerView recyclerView;
    private String tripid;
    private View mEmptyView;

    private ProgressDialog progressDialog;

    public CompletedProjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed_projects, container, false);

        init(view);
        completedProjectsList = new ArrayList<>();
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));

        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));
        completedProjectsList.add(new CompletedProjects("Android", "XYZ Description"
                , "XYZ Requirements", "200$", "20/02/2020", "UMT"
                , "In Progress"));

        completedProjectsAdapter = new CompletedProjectsAdapter(getContext(),
                completedProjectsList);
        completedProjectsAdapter.notifyDataSetChanged();
        @SuppressLint("WrongConstant") RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(completedProjectsAdapter);


        return view;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.CompletedProjectsRecyclerView);
        progressDialog = new ProgressDialog(getContext());

    }

}
