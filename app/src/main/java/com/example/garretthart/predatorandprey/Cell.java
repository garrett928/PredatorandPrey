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


    public Cell(Context c){
        super(c);
    }

    public void makeNothing(){
        this.isNothing = true;
        this.isPredator = false;
        this.isPrey = false;
        this.setBackgroundResource(R.drawable.nothing);
    }

    public void makePredator(){
        this.isNothing = false;
        this.isPredator = true;
        this.isPrey = false;
        this.setBackgroundResource(R.drawable.predator);
    }

    public void makePrey(){
        this.isNothing = false;
        this.isPredator = false;
        this.isPrey = true;
        this.setBackgroundResource(R.drawable.prey);
    }

}
