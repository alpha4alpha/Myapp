package com.example.fyp2.Acitivities;

import android.os.Bundle;

import com.example.fyp2.R;
import com.example.fyp2.fragments.CompletedProjectsFragment;
import com.example.fyp2.fragments.DashboardFragment;
import com.example.fyp2.fragments.FragmentCollaboration;
import com.example.fyp2.fragments.FragmentMyAccounts;
import com.example.fyp2.fragments.FragmentUniversities;
import com.example.fyp2.fragments.OnGoingProjectsFragment;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class drawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    //Main drawer code from which program starts
    private AppBarConfiguration mAppBarConfiguration;
    NavigationView navigationView;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        FunFragmentTransaction();

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    private void FunFragmentTransaction() {

    DashboardFragment dashboardFragment = new DashboardFragment();

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.addToBackStack(null).replace(R.id.Main_Container,dashboardFragment).commit();
        setTitle("Dashboard");

    }

    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;
        int id = menuItem.getItemId();
        if (id == R.id.dashboard) {
            fragment = new DashboardFragment();
        } else if (id == R.id.Projects) {
            fragment = new CompletedProjectsFragment();
        } else if (id == R.id.Universities) {
            fragment = new FragmentUniversities();
        } else if (id == R.id.Collaboration) {
            fragment = new FragmentCollaboration();
        }/*else if (id == R.id.my_accounts) {
            fragment = new FragmentMyAccounts();
        }*//*else if (id == R.id.Settings) {
            fragment = new FragmentSettings();
        }*/else if (id == R.id.Logout) {
            //logout code


        }

        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.addToBackStack(null).replace(R.id.Main_Container, fragment).commit();

        }
        setTitle(menuItem.getTitle());
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }
}
