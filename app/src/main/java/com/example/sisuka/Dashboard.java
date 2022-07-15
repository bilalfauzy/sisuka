package com.example.sisuka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button btn_logout, d_button1, d_button2, d_button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawerL);
        btn_logout = findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });

        d_button1 = findViewById(R.id.d_button1);
        d_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.d_button1:
                        d_button1();
                        break;
                }
            }

            private void d_button1() {
                Intent intent = new Intent(Dashboard.this, SuratMasukActivity.class);
                startActivity(intent);
            }
        });

        d_button2 = findViewById(R.id.d_button2);
        d_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.d_button2:
                        d_button2();
                        break;
                }
            }

            private void d_button2() {
                Intent intent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);
            }
        });

        d_button3 = findViewById(R.id.d_button3);
        d_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.d_button3:
                        d_button3();
                        break;
                }
            }

            private void d_button3() {
                Intent intent = new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void ClickMenu(View view){
       openDrawer(drawerLayout);
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    private void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){

        recreate();
    }
    public void ClickNotification(View view){
        //redict act to profile
        redirectActivity(this,Notifikasi.class);
    }

    public void ClickProfile(View view){

        redirectActivity(this,Profil.class);
    }

    private static void redirectActivity(Dashboard dashboard, Class aClass) {
        Intent intent = new Intent(dashboard,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        dashboard.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}