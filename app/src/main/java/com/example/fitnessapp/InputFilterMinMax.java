package com.example.fitnessapp;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.Toast;

public class InputFilterMinMax implements InputFilter {

    private int min, max;
    Context context;

    public InputFilterMinMax(int min, int max, Context context) {
        this.min = min;
        this.max = max;
        this.context = context;
    }

    public InputFilterMinMax(String min, String max) {
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int input = Integer.parseInt(dest.toString() + source.toString());
            if (isInRange(min, max, input))
                return null;
            else {
                Toast.makeText(context,"invalid input", Toast.LENGTH_SHORT).show();
            }

        } catch (NumberFormatException nfe) { }
        return "";
    }

    private boolean isInRange(int a, int b, int c) {


        return b > a ? c >= a && c <= b : c >= b && c <= a;

    }
}