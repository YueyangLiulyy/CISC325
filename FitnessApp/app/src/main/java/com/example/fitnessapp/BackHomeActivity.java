package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class BackHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_home);
        getSetBackDefault();
        userChoice();
    }

    private void getSetBackDefault(){
        SharedPreferences sharedPreferences = getSharedPreferences("back", MODE_PRIVATE);
        boolean pullup = sharedPreferences.getBoolean(getString(R.string.pullup),true);
        boolean latpulldown = sharedPreferences.getBoolean(getString(R.string.latPulldown), true);
        boolean dumbbellsinglearmrow = sharedPreferences.getBoolean(getString(R.string.dumbBellSingleArmRow), true);
        boolean bentoverbarbellrow = sharedPreferences.getBoolean(getString(R.string.bentOverBarbellRow),false);

        setChestDefault(pullup, latpulldown, dumbbellsinglearmrow, bentoverbarbellrow);


    }

    private void setChestDefault(boolean pullup, boolean latpulldown, boolean dumbbellsinglearmrow,
                                 boolean bentoverbarbellrow){
        CheckBox checkBox1 = findViewById(R.id.pullupCheckBox);
        CheckBox checkBox2 = findViewById(R.id.latPulldownCheckBox);
        CheckBox checkBox3 = findViewById(R.id.dumbbellSingleArmRowCheckBox);
        CheckBox checkBox4 = findViewById(R.id.bentoverBarbellRowCheckBox);
        if(pullup) checkBox1.setChecked(true);
        if(latpulldown) checkBox2.setChecked(true);
        if(dumbbellsinglearmrow) checkBox3.setChecked(true);
        if(bentoverbarbellrow) checkBox4.setChecked(true);
    }



    private void userChoice(){
        final CheckBox checkBox1 = findViewById(R.id.benchPressCheckBox);

        final CheckBox checkBox2 = findViewById(R.id.inclinedDumbbellFlyeCheckBox);
        final CheckBox checkBox3 = findViewById(R.id.cableCrossoverCheckBox);
        final CheckBox checkBox4 = findViewById(R.id.pushupCheckBox);
        final CheckBox checkBox5 = findViewById(R.id.chestPressMachineCheckBox);
        final CheckBox checkBox6 = findViewById(R.id.dumbbellFlyeCheckBox);
        final Context context = getApplicationContext();
        SharedPreferences sharedPreferences = getSharedPreferences("chest", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when click it makes it checked
                if(checkBox1.isChecked()){
                    editor.putBoolean(getString(R.string.benchPress), true);
                    editor.apply();
                }
                else {
                    editor.putBoolean(getString(R.string.benchPress), false);
                    editor.apply();
                }
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox2.isChecked()){
                    editor.putBoolean(getString(R.string.inclineDumbbellFlye), true);
                    editor.apply();
                }
                else{
                    editor.putBoolean(getString(R.string.inclineDumbbellFlye), false);
                    editor.apply();
                }
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox3.isChecked()){
                    editor.putBoolean(getString(R.string.cableCrossover), true);
                    editor.apply();
                }
                else{
                    editor.putBoolean(getString(R.string.cableCrossover), false);
                    editor.apply();
                }
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox4.isChecked()){
                    editor.putBoolean(getString(R.string.pushup), true);
                    editor.apply();
                }
                else{
                    editor.putBoolean(getString(R.string.pushup), false);
                    editor.apply();
                }
            }
        });
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox5.isChecked()){
                    editor.putBoolean(getString(R.string.chestPressMachine), true);
                    editor.apply();
                }
                else{
                    editor.putBoolean(getString(R.string.chestPressMachine), false);
                    editor.apply();
                }
            }
        });
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox6.isChecked()){
                    editor.putBoolean(getString(R.string.dumbbellFlye), true);
                    editor.apply();
                }
                else{
                    editor.putBoolean(getString(R.string.dumbbellFlye), false);
                    editor.apply();
                }
            }
        });




    }

}
