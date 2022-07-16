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

public class Profil extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        drawerLayout = findViewById(R.id.drawerL);
        btn_logout = findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), com.example.sisuka.appactivity.LoginActivity.class));
            finish();
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
        redirectActivity(this, com.example.sisuka.appactivity.Dashboard.class);
    }
    public void ClickNotification(View view){
        recreate();
    }

    public void ClickProfile(View view){
        redirectActivity(this,Profil.class);
    }

    private static void redirectActivity(Profil profil, Class aClass) {
        Intent intent = new Intent(profil,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        profil.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}