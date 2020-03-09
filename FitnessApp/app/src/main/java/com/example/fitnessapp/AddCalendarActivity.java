package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;


import java.io.BufferedOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class AddCalendarActivity extends AppCompatActivity {
    CompactCalendarView compactCalendarView;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    Set<String> dayList = new HashSet<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_calendar);
//        SharedPreferences sharedPreferences = getSharedPreferences("chestDate", MODE_PRIVATE);
//        sharedPreferences.edit().clear().commit();

        compactCalendarView = findViewById(R.id.addCalendarView);
        compactCalendarView.setUseThreeLetterAbbreviation(true);
        loadDaylist();



        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
//        actionBar.setTitle(dateFormat.format());

        connectTo(actionBar);



    }


    private void connectTo(final ActionBar actionBar){

//        CalendarView calendar = findViewById(R.id.workOutcalendarView);
//        calendar.setMinDate(System.currentTimeMillis() - 1000);

        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Long datel = dateClicked.getTime();
                Context context = getApplicationContext();
                int month = dateClicked.getMonth();
                int dtime = dateClicked.getDate();
                String date = "" + (month+1) + "/" + dtime;
                alert(date, datel);
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(dateFormat.format(firstDayOfNewMonth));


            }
        });

    }

    private void getStatus(String date){

        // get to know which exercise are selected
        SharedPreferences sharedPreferences1 = getSharedPreferences("chest", MODE_PRIVATE);
        boolean benchPress = sharedPreferences1.getBoolean(getString(R.string.benchPress),true);
        boolean inclineDumbbellFlye = sharedPreferences1.getBoolean(getString(R.string.inclineDumbbellFlye), true);
        boolean cableCrossover = sharedPreferences1.getBoolean(getString(R.string.cableCrossover), true);
        boolean pushup = sharedPreferences1.getBoolean(getString(R.string.pushup),true);
        boolean chestPressMachine = sharedPreferences1.getBoolean(getString(R.string.chestPressMachine),true);
        boolean dumbbellFlye = sharedPreferences1.getBoolean(getString(R.string.dumbbellFlye), true);

        if(benchPress) addToCalendar(date, getString(R.string.benchPress));
        if(inclineDumbbellFlye) addToCalendar(date, getString(R.string.inclineDumbbellFlye));
        if(cableCrossover) addToCalendar(date, getString(R.string.cableCrossover));
        if(pushup) addToCalendar(date, getString(R.string.pushup));
        if(chestPressMachine) addToCalendar(date, getString(R.string.chestPressMachine));
        if(dumbbellFlye) addToCalendar(date, getString(R.string.dumbbellFlye));
        testing(date);


    }
    private void addToCalendar(String date, String exe){
        SharedPreferences sharedPreferences = getSharedPreferences("chestDate", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> result = sharedPreferences.getStringSet(date, new HashSet<String>());
        result.add(exe);
        editor.putStringSet(date, result);
        editor.apply();
    }

    private void testing(String date){
        SharedPreferences sharedPreferences = getSharedPreferences("chestDate", MODE_PRIVATE);
        Set<String> result = sharedPreferences.getStringSet(date, new HashSet<String>());
        String so = "";
        for(String str:result){
            so += str;
        }
        TextView textView = findViewById(R.id.test);
        textView.setText(so);

    }

    private void alert(final String date, final Long datel){
//        final Context context = getApplicationContext();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Are you sure you want add it to " + date);
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dayList.add(datel.toString());
                        getStatus(date);
                        addEvent(datel);
                        for(String str: dayList){
//                addEvent(Long.parseLong(str));
                            Log.v("daylist!!!!", str);
                        }
                        saveDayList();
                    }
                }
        );
        alertDialog.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );
        AlertDialog alertDialog1 = alertDialog.create();
        alertDialog1.show();

    }

    private void addEvent(Long datel){
        Event event = new Event(Color.RED, datel, "");
        compactCalendarView.addEvent(event);
    }

    private void saveDayList(){
        SharedPreferences sharedPreferences = getSharedPreferences("ExeDate", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(getString(R.string.execriseDay), dayList);
        editor.apply();
    }

    private void loadDaylist(){
        SharedPreferences sharedPreferences = this.getSharedPreferences("ExeDate", MODE_PRIVATE);
        dayList = sharedPreferences.getStringSet(getString(R.string.execriseDay), new HashSet<String>());
        for(String str: dayList){
            // may need to change later
            if(!str.equals("1583985600000"))
            addEvent(Long.parseLong(str));
        }

    }


}
