package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class ExecriseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execrise);
//        setSomething();
    }
    // testing you can delete it if you want 
//    private void setSomething(){
//        ScrollView chestScrollView = findViewById(R.id.chestScrollView);
//        chestScrollView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                addToCalendar();
//                return false;
//            }
//        });
//    }
//
//    private void addToCalendar(){
//        TextView addToCalendar = findViewById(R.id.trySomething);
//        addToCalendar.setText("add to calendar");
//    }
}
