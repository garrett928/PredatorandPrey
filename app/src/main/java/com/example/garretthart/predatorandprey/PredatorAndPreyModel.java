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

    int cellsPerRow = 38;
    int cellsPerCol = 55;

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



    void moveCell(int index){
        double value = Math.random();
            if (value <= .25) {
                moveUp(index);
            }
            if (value > .25 && value <= .50) {
                moveDown(index);
            }
            if (value > .50 && value <= 75) {
                moveLeft(index);
            }
            if (value > .75 && value <= 1) {
                moveRight(index);
            }
    }

    private  void moveDown(int index){
        index = index + cellsPerRow;
        cellArray[index].makeNothing();
    }

    private void moveUp(int index){
        index = index - cellsPerRow;
        cellArray[index].makeNothing();
    }

    private void moveLeft(int index){
        index = index - 1;
        cellArray[index].makeNothing();
    }
    private void moveRight(int index){
        index = index + 1;
        cellArray[index].makeNothing();
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
