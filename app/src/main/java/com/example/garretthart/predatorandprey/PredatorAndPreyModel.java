package com.example.garretthart.predatorandprey;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by garrett hart on 8/25/2017.
 */

public class PredatorAndPreyModel {
    public int numberOfCells;

    public Cell[] cellArray;
    private CELL_STATES[] cellStatesArray;

    private  enum CELL_STATES{
        nothing(0),
        predator(1),
        prey(2);
        public int value;

        CELL_STATES(int value){
            this.value = value;
        }

    }

    PredatorAndPreyModel(){
        numberOfCells = 2090;
        cellArray = new Cell[numberOfCells];
        cellStatesArray = new CELL_STATES[numberOfCells];
    }




    public void randomizeCells() {
        double value = Math.random();
        for (int i = 0; i < numberOfCells; i++) {
            if (value <= .9) {
                cellArray[i].makeNothing();
            }
            if (value > .9 && value <= .95) {
                cellArray[i].makePredator();
            }
            if (value > .95 && value <= 1) {
                cellArray[i].makePrey();
            }
            value = Math.random();
        }
    }
}
