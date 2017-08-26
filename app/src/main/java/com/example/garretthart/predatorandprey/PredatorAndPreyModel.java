package com.example.garretthart.predatorandprey;

import android.widget.TextView;

import java.lang.reflect.Array;

/**
 * Created by garrett hart on 8/25/2017.
 */

public class PredatorAndPreyModel {
    public int numberOfCells;

    public TextView[] cell1dArray;
    public TextView[][] cell2dArray;

    PredatorAndPreyModel(){
        numberOfCells = 50;
        cell1dArray = new TextView[numberOfCells];
    }


}
