package com.example.sisuka.appactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sisuka.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

public class Notifikasi extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Button btn_logout;
    private Button btn_triger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        drawerLayout = findViewById(R.id.drawerL);
        btn_logout = findViewById(R.id.btn_logout);
        btn_triger = findViewById(R.id.btn_triger);

        btn_logout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), com.example.sisuka.appactivity.LoginActivity.class));
            finish();
        });

        btn_triger.setOnClickListener(view -> {
            FirebaseMessaging.getInstance().getToken()
                    .addOnCompleteListener(new OnCompleteListener<String>() {
                        @Override
                        public void onComplete(@NonNull Task<String> task) {
                            if (!task.isSuccessful()) {
                                Log.w("FCM", "Fetching FCM registration token failed", task.getException());
                                return;
                            }

                            // Get new FCM registration token
                            String token = task.getResult();

                            // Log and toast
                            Log.d("FCM", token);
                            Toast.makeText(Notifikasi.this, token, Toast.LENGTH_SHORT).show();
                        }
                    });
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

    private static void redirectActivity(Notifikasi notifikasi, Class aClass) {
        Intent intent = new Intent(notifikasi,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        notifikasi.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}