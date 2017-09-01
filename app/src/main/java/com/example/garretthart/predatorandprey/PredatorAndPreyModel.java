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
        else if (value > .25 && value <= .50) {
            moveDown(index);
        }
        else if (value > .50 && value <= 75) {
            moveLeft(index);
        }
       else if (value > .75 && value <= 1){
            moveRight(index);
        }

    }

    private  void moveDown(int index){
        int newIndex = index + cellsPerRow;
        if(newIndex < 0 || newIndex >= 2090){
            return;
        }
        if(!areTheSame(cellArray[index], cellArray[newIndex])){
            makeCellSame(cellArray[index], cellArray[newIndex]);
        }
    }

    private void moveUp(int index){
        int newIndex = index - cellsPerRow;
        if(newIndex < 0 || newIndex >= 2090){
            return;
        }
        if(!areTheSame(cellArray[index], cellArray[newIndex])){
            makeCellSame(cellArray[index], cellArray[newIndex]);
        }
    }

    private void moveLeft(int index){
        int newIndex = index - 1;
        if(newIndex < 0 || newIndex >= 2090){
            return;
        }
        if(!areTheSame(cellArray[index], cellArray[newIndex])){
            makeCellSame(cellArray[index], cellArray[newIndex]);
        }
    }
    private void moveRight(int index){
        int newIndex = index + 1;
        if(newIndex < 0 || newIndex >= 2090){
            return;
        }
        if(!areTheSame(cellArray[index], cellArray[newIndex])){
           makeCellSame(cellArray[index], cellArray[newIndex]);
        }
    }

    private boolean areTheSame(Cell cell1, Cell cell2){
        if(cell1.isNothing && cell2.isNothing){
            return true;
        }
        if(cell1.isPredator && cell2.isPredator) {
            return true;
        }
        if(cell1.isPrey && cell2.isPrey){
            return true;
        }
        return false;
    }


    public void makeCellSame(Cell constCell, Cell changeCell){
        if(constCell.isNothing){
            return;
        }
        if(constCell.isPredator){
            changeCell.makePredator();
        }
        if (constCell.isPrey) {
            changeCell.makePrey();
        }
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
