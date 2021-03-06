package com.example.garretthart.predatorandprey;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by garrett hart on 8/27/2017.
 */

public class Cell extends ImageView {

    boolean isNothing = false;
    boolean isPredator = false;
    boolean isPrey = false;
    int id;
    PredatorAndPreyModel predatorAndPreyModel;

    int index;


    public Cell(Context c,int index, PredatorAndPreyModel parrent){
        super(c);
        predatorAndPreyModel = parrent;
        this.index = index;
    }

    public void makeNothing(){
        this.isNothing = true;
        this.isPredator = false;
        this.isPrey = false;
        int id = 0;
        this.setBackgroundResource(R.drawable.nothing);
    }

    public void makePredator(){
        this.isNothing = false;
        this.isPredator = true;
        this.isPrey = false;
        int id = 1;
        this.setBackgroundResource(R.drawable.predator);
    }

    public void makePrey(){
        this.isNothing = false;
        this.isPredator = false;
        this.isPrey = true;
        int id = 2;
        this.setBackgroundResource(R.drawable.prey);
    }


}
