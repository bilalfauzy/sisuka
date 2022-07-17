package com.example.sisuka.appactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sisuka.R;
import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    Button btn_logout, d_button1, d_button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawerLayout = findViewById(R.id.drawerL);
        btn_logout = findViewById(R.id.btn_logout);
        d_button1 = findViewById(R.id.d_button1);
        d_button2 = findViewById(R.id.d_button2);

        btn_logout.setOnClickListener(this);
        d_button1.setOnClickListener(this);
        d_button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.d_button1:
                Intent intent = new Intent(Dashboard.this, SuratMasukActivity.class);
                startActivity(intent);
                break;
            case R.id.d_button2:
                Intent intent1 = new Intent(Dashboard.this, SuratKeluarActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), com.example.sisuka.appactivity.LoginActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
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