package com.junadhi.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.fr_home:
                fragment = new HomeFragment();
                break;

            case R.id.fr_dashboard:
                fragment = new DashboardFragment();
                break;

            case R.id.fr_notification:
                fragment = new NotificationFragment();
                break;

            case R.id.fr_account:
                fragment = new AccountFragment();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return  false;
    }
}