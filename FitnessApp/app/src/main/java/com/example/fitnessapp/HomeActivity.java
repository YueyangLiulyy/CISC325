package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setLogoutButton();
        setButtons();
    }

    private void setLogoutButton(){
        Button logoutBtn = findViewById(R.id.logoutButton);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBack();
            }
        });
    }

    private void setBack(){
        SharedPreferences sharedPreferences = getSharedPreferences("share", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(getString(R.string.login_status), false);
        editor.apply();
        Toast.makeText(this, "status saved", Toast.LENGTH_SHORT).show();
    }

    private void setButtons(){
        Button execriseBtn = findViewById(R.id.execriseButton);
        execriseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goExecrisePage();
            }
        });

        Button nutritionBtn = findViewById(R.id.nutritionButton);
        nutritionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNutritionPage();
            }
        });

        Button calendarBtn = findViewById(R.id.calendarButton);
        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCalendarPage();
            }
        });

        Button profileBtn = findViewById(R.id.profileButton);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goProfilePage();
            }
        });


    }

    private void goExecrisePage(){
        Intent intent = new Intent(this, ExecriseActivity.class);
        startActivity(intent);
    }

    private void goNutritionPage(){
        Intent intent = new Intent(this, NutritionActivity.class);
        startActivity(intent);
    }

    private void goCalendarPage(){
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    private void goProfilePage(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
