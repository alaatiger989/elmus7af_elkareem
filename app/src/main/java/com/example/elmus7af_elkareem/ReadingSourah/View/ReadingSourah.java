package com.example.elmus7af_elkareem.ReadingSourah.View;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.example.elmus7af_elkareem.MainView.View.MainViews;
import com.example.elmus7af_elkareem.R;
import com.example.elmus7af_elkareem.ReadingSourah.Model.ReadingSourahModel;
import com.example.elmus7af_elkareem.ReadingSourah.Presenter.ReadingSourahPresenter;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;



public class ReadingSourah extends AppCompatActivity implements IReadingSourah {

    private AppBarConfiguration mAppBarConfiguration;
    private NavController navController;
    private NavigationView navigationView;
    private ReadingSourahPresenter readingSourahPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_sourah);

        initializingNavigationDrawer();

    }

    public void initializingNavigationDrawer() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_download ,R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();





        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        new ReadingSourahModel(drawer);
        readingSourahPresenter = new ReadingSourahPresenter(this);
        readingSourahPresenter.showDownloadMenuItemNav(ReadingSourah.this);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.reading_sourah, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void hideDownloadItem(boolean b) {
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_download).setVisible(b);
    }

    @Override
    public void activateDownloadItem(boolean b) {
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_download).setVisible(b);
        nav_Menu.findItem(R.id.nav_download).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                readingSourahPresenter.showNotificationDownloadManager();
                return false;
            }
        });
    }
}
