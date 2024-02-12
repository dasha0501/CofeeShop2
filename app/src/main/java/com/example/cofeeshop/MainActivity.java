package com.example.cofeeshop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cofeeshop.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vxod);
        start = findViewById(R.id.start);
        start.setOnClickListener(this::GetStarted);







    }
    private void GetStarted(View view)
    {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        final int[] TAB_TITLES = new
                int[]{R.string.title_home, R.string.title_dashboard,
                R.string.title_notifications, R.string.title_order };




    }
    public Fragment getItem(int position)
    {

        if(position == 0)
        {
            Home tab1 = new Home();
            return tab1;
        }
        if(position == 1)
        {
            Favorite tab2 = new Favorite();
            return tab2;
        }
        if(position == 2)
        {
            Order tab3 = new Order();
            return tab3;
        }
        if(position == 3)
        {
            Notifications tab4 = new Notifications();
            return tab4;
        }
        return null;
    }





}