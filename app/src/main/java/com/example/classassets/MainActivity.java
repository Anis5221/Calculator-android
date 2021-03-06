package com.example.classassets;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);







    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
//        String id = prefs.getString("id", "");
//        Menu m = (Menu) findViewById(R.id.login);
////        Log.d(id, "this id");
//        if(Integer.parseInt(id) > 0){
//
//
//

            switch (item.getItemId()){
                case R.id.login:
                    Intent account =new Intent(this,Login_Activity.class);
                    startActivity(account);
                    break;
                case R.id.signUp:
                    Intent i =new Intent(this,SignUp.class);
                    startActivity(i);
                    break;
                case R.id.logOut:
                    Intent in =new Intent(this,Login_Activity.class);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.clear();
                    editor.commit();
                    startActivity(in);
                default:
                    return super.onOptionsItemSelected(item);
            }
            return true;


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences  prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        boolean p = prefs.getBoolean("isLogged", false);
        String id = prefs.getString("idKey", "1525");
        getMenuInflater().inflate(R.menu.main, menu);

        if (p) {
            MenuItem item1 = menu.findItem(R.id.login);
            item1.setVisible(false);
            MenuItem item2 = menu.findItem(R.id.signUp);
            item2.setVisible(false);
        }else{
            MenuItem item2 = menu.findItem(R.id.logOut);
            item2.setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}